import controllers.SortPersonaMethods;
import models.Persona;
import utils.Benchmarking;
import models.Resultado;

public class App {
    public static void main(String[] args) throws Exception {
        SortPersonaMethods sortMethods = new SortPersonaMethods();
        Persona [] personas = generarPersonas(10_000);
        Persona [] personasInsertion = personas.clone();
        Persona [] personasQuick = personas.clone();

        sortMethods.insertionSort(personasInsertion);
        sortMethods.quickSort(personasQuick, 0, personasQuick.length - 1);
        Resultado resultadoInsertion = Benchmarking.medirTiempo(
            () -> {
                sortMethods.insertionSort(personasInsertion);
                return null;
            },
            "Insertion Sort",
            "10,000 personas",
            10_000
        );
        Resultado resultadoQuick = Benchmarking.medirTiempo(
            () -> {
                sortMethods.quickSort(personasQuick, 0, personasQuick.length - 1);
                return null;
            },
            "Quick Sort",
            "10,000 personas",
            10_000
        );

        System.out.println("Desordenado |" + 
            resultadoInsertion.getAlgoritmo() + "|" +
            resultadoInsertion.getEscenario() + "|" +
            resultadoInsertion.getSample() + "|" +
            resultadoInsertion.getTiempoMillis() + "ms|" +
            resultadoInsertion.getTiempoNano() + "Nano"
        );
        // System.out.println("Algoritmo: " + resultadoQuick.getAlgoritmo() +
        //     ", Escenario: " + resultadoQuick.getEscenario() +
        //     ", Sample: " + resultadoQuick.getSample() +
        //     ", Tiempo (ms): " + resultadoQuick.getTiempoMillis() +
        //     ", Tiempo (ns): " + resultadoQuick.getTiempoNano()
        // );

    }

    public static Persona [] generarPersonas(int cantidad) {
        Persona [] personas = new Persona [cantidad];
        for (int i = 0; i < cantidad; i++) {
            String nombre= "Persona " + (i + 1);
            int edad = (int) (Math.random() * 101);
            personas [i] = new Persona (nombre, edad);
        }
        return personas;
    }
}
