import controllers.SortPersonaMethods;
import models.*;
import utils.Benchmarking;

public class App {

    public static void main(String[] args) throws Exception {
        SortPersonaMethods sortMethods = new SortPersonaMethods();

        int[] longitudes = {10_000, 50_000, 100_000};

        for (int size : longitudes) {
            ejecutarBenchmark(sortMethods, size);
        }
    }

    private static void ejecutarBenchmark(SortPersonaMethods sortMethods, int size) throws Exception {

        Persona[] base = generarPersonas(size);
        Persona[] copiaInsercion = base.clone();
        Persona[] copiaQuickSort = base.clone();

        Resultado resultadoInsercion = Benchmarking.medirTiempo(
            () -> { sortMethods.insertionSort(copiaInsercion); return null; },
            "Inserción", "Desordenado", size
        );
        imprimirResultado(resultadoInsercion);

        Resultado[] resultadoQuickSort = new Resultado[1];
        Thread hiloQuick = new Thread(null, () -> {
            try {
                resultadoQuickSort[0] = Benchmarking.medirTiempo(
                    () -> { sortMethods.quickSort(copiaQuickSort, 0, copiaQuickSort.length - 1); return null; },
                    "QuickSort", "Desordenado", size
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "quicksort-thread", 64 * 1024 * 1024);
        hiloQuick.start();
        hiloQuick.join();
        imprimirResultado(resultadoQuickSort[0]);

        // Escenario 2: Casi ordenado + 1 persona
        Persona[] baseOrdenada = base.clone();
        sortMethods.insertionSort(baseOrdenada);

        Persona[] casiOrdenado = new Persona[baseOrdenada.length + 1];
        System.arraycopy(baseOrdenada, 0, casiOrdenado, 0, baseOrdenada.length);
        casiOrdenado[casiOrdenado.length - 1] = new Persona("Persona Nueva", (int)(Math.random() * 101));

        Persona[] copiaInsertionCasi = casiOrdenado.clone();
        Persona[] copiaQuickCasi = casiOrdenado.clone();

        Resultado resInsercionCasi = Benchmarking.medirTiempo(
            () -> { sortMethods.insertionSort(copiaInsertionCasi); return null; },
            "Inserción", "Casi ordenado + 1 persona", size + 1
        );
        imprimirResultado(resInsercionCasi);

        Resultado[] resultadoQuickCasi = new Resultado[1];
        Thread hiloQuickCasi = new Thread(null, () -> {
            try {
                resultadoQuickCasi[0] = Benchmarking.medirTiempo(
                    () -> { sortMethods.quickSort(copiaQuickCasi, 0, copiaQuickCasi.length - 1); return null; },
                    "QuickSort", "Casi ordenado + 1 persona", size + 1
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "quicksort-casi-thread", 64 * 1024 * 1024);
        hiloQuickCasi.start();
        hiloQuickCasi.join();
        imprimirResultado(resultadoQuickCasi[0]);

        System.out.println();
    }

    public static Persona[] generarPersonas(int cantidad) {
        Persona[] personas = new Persona[cantidad];
        for (int i = 0; i < cantidad; i++) {
            String nombre = "Persona " + (i + 1);
            int edad = (int) (Math.random() * 101);
            personas[i] = new Persona(nombre, edad);
        }
        return personas;
    }

    private static void imprimirResultado(Resultado resultante) {
        System.out.println(
            resultante.getEscenario() + " | " +
            resultante.getAlgoritmo() + " | " +
            resultante.getSample() + " | " +
            resultante.getTiempoMillis() + " ms"
        );
    }
}