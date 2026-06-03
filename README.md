# PRACTICA COMPARATIVAS 

Universidad Politecnica Salesiana 

Nombre: Martín Villacrés

## EXPLICACION GENERAL

El codigo implementa arreglos de objetos de la clase persona con un nombre y una edad aleatorios, usa metodos de ordenamiento para ordenar los arreglos de distintos tamaños anteriormente solícitados. Se solicitó dos escenarios, contar el tiempo en milisegundos de cuanto se tarda en ordenar los distintos casos y tamaños de los arreglos. 

## RESULTADOS OBTENIDOS

### Tabla 1: ESCENARIO 1: arreglo completamente desordenado

| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |
| :--- | :--- | :--- | :--- | :--- |
| 10.000 | 449.79ms | 6.56ms | QuickSort | QuickSort fue 68 veces más rápido que Inserción |
| 50.000 | 23513.244ms | 39.35ms | QuickSort | Inserción tardó 597 veces más que QuickSort |
| 100.000 | 246808.65ms | 105.94ms | QuickSort | Insertión se elevó mucho, demostrando una lentitud absoluta |

### Tabla 2: ESCENARIO 2: arreglo casi ordenado

| Tamaño de muestra | Tiempo Inserción | Tiempo QuickSort | Algoritmo más rápido | Observación |
| :--- | :--- | :--- | :--- | :--- |
| 10.000 | 1.18ms | 647.24ms | InsertionSort | QuickSort tardó 550 veces más que Inserción |
| 50.000 | 5.83ms | 25447.31ms | InsertionSort | QuickSort aumentó severamente |
| 100.000 | 23.28ms | 36257.65ms | InsertionSort | QuickSort tardó aprox 1557 veces más que Inserción |

## ANALISIS 

1. ¿Qué algoritmo fue más rápido en el escenario desordenado?

El algorítmo más rápido en ordenar los arreglos desordenados fue QuickSort.

2. ¿Qué algoritmo fue más rápido en el escenario casi ordenado?

El algorítmo más eficiente en este caso fue insertion, ya que al estar casi ordenado el arreglo, el algoritmo tiene mucho menos trabajo que realizar.

3. ¿El crecimiento del tamaño de la muestra afecto por igual a los dos algoritmos?

No, ya que al trabajar el ordenamiento de distintas maneras, los algorítmos se comportaron de una manera muy diferente siendo uno más efectivo en esta situación que el otro.

4. ¿Por qué inserción puede mejorar cuando el arreglo ya está casi ordenado?

POrque la forma de funcionar de este algorítmo es comparar los elementos con los elementos anteriores, facilitando el ordenamiento en el caso de que los elementos se encuentren casi ordenados.

5. ¿Por qué QuickSort suele ser mejor cuando los datos estan muy desordenados?

Porque la forma de funcionar de este algorítmo es dividir los elementos den dos partes y ordenarlas individualmente optimizando los tiempos de ordenación.

## CONCLUSIONES:

Conclusion 1: 
En el escenario de los arreglos desordenados el metodo de inserción no fue muy efectivo ya que al verificar prácticamente de uno en uno no optimiza tiempos, mientras que por otro lado el metodo quick al dividir los elementos optimiza los tiempos de ordenación.

Conclusion 2: 
EL método quick demostró una eficiencia en la ordenación de los elementos desordenados, pero en el escenario de agregación sus tiempos aumentaron en grán medida, ya que al tener que realizar todas las divisiones le toca verificar los datos nuevamente.

Conclusión 3: 
Ambos algorítmos tienen sus contras así que podría considerarse que dependiendo del caso uno u otro algorítmo es más eficiente, dependiendo del estado inicial de los datos se debería utilizar el mejor para optimizar procesos.






