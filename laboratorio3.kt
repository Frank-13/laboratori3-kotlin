import kotlin.system.measureTimeMillis

fun main() {
    while (true) {
        println("Seleccione una opcion: ")
        println("1. Ordenar una lista usando Bubble Sort")
        println("2. Ordenar una lista usando Quick Sort")
        println("3. Calcular el factorial de un numero")
        println("4. Resolver las Torres de Hanoi")
        println("5. Salir")

        when (val op = readLine()?.toIntOrNull()) {
            1 -> {
                // Ordenar una lista usando Bubble Sort
                println("Opción 1 seleccionada")
                println("Ingrese los elementos de la lista separados por comas: ")
                val list = readLine()?.split(",")?.mapNotNull { it.toIntOrNull() }?.toMutableList()
                if (list != null && list.isNotEmpty()) {
                    bubbleSort(list)
                    println("Lista ordenada: $list")
                } else {
                    println("Lista inválida")
                }
            }
            2 -> {
                // Ordenar una lista usando Quick Sort
                println("Opción 2 seleccionada")
                println("Ingrese los elementos de la lista separados por comas: ")
                val list = readLine()?.split(",")?.mapNotNull { it.toIntOrNull() }?.toMutableList()
                if (list != null && list.isNotEmpty()) {
                    quickSort(list)
                    println("Lista ordenada: $list")
                } else {
                    println("Lista inválida")
                }
            }
            3 -> {
                // Calcular el factorial de un numero
                println("Opción 3 seleccionada")
                println("Ingrese un número: ")
                val n = readLine()?.toIntOrNull()
                if (n != null) {
                    println("El factorial de $n es ${factorial(n)}")
                } else {
                    println("Número inválido")
                }
            }
            4 -> {
                // Resolver las Torres de Hanoi
                println("Opción 4 seleccionada")
                println("Ingrese el número de discos: ")
                val n = readLine()?.toIntOrNull()
                if (n != null) {
                    hanoi(n, 'A', 'C', 'B')
                } else {
                    println("Número inválido")
                }
            }
            5 -> {
                // Salir
                println("Saliendo...")
                break
            }
            else -> {
                println("Opción inválida")
            }
        }
    }
}

fun bubbleSort(list: MutableList<Int>) {
    val time = measureTimeMillis {
        var cambio: Boolean
        do {
            cambio = false
            for (i in 0 until list.size - 1) {
                if (list[i] > list[i + 1]) {
                    val temp = list[i]
                    list[i] = list[i + 1]
                    list[i + 1] = temp
                    cambio = true
                }
            }
        } while (cambio)
    }
    println("Tiempo de ejecución: $time ms")
}

fun quickSort(list: MutableList<Int>, low: Int = 0, high: Int = list.size - 1) {
    if (low < high) {
        val pi = partition(list, low, high)
        quickSort(list, low, pi - 1)
        quickSort(list, pi + 1, high)
    }
}

fun partition(list: MutableList<Int>, low: Int, high: Int): Int {
    val pivot = list[high]
    var i = low - 1
    for (j in low until high) {
        if (list[j] <= pivot) {
            i++
            val temp = list[i]
            list[i] = list[j]
            list[j] = temp
        }
    }
    val temp = list[i + 1]
    list[i + 1] = list[high]
    list[high] = temp
    return i + 1
}

fun factorial(n: Int): Int {
    return if (n == 0) {
        1
    } else {
        n * factorial(n - 1)
    }
}

fun hanoi(n: Int, from: Char, to: Char, aux: Char) {
    if (n == 1) {
        println("Mover disco 1 de $from a $to")
        return
    }
    hanoi(n - 1, from, aux, to)
    println("Mover disco $n de $from a $to")
    hanoi(n - 1, aux, to, from)
}