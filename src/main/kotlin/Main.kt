fun main(args: Array<String>) {
    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")

    var div = 3.toDouble() / 2.toDouble()
    println("Valor div: $div")

    val generatedArray = IntArray(10) { it }
    generatedArray.forEach { print(it) }

    println()
    val intArray = IntArray(5)
    println("size: ${intArray.size}")
    intArray.forEach { print(it) }

    println()
    val intArray2 = intArrayOf(-5)
    println("size: ${intArray2.size}")
    intArray2.forEach { print(it) }

    println()
    val intArray3 = arrayOfNulls<Int>(5)
    println("size: ${intArray3.size}")
    intArray3.forEach { print(it) }

    println()
    val rows = 3
    val cols = 4
    val matrix = Array(rows) { IntArray(cols) }
    for (row in matrix) {
        println(row.contentToString())
    }
    println()
    val graph: Array<MutableList<Int>> = arrayOf(
        mutableListOf(1, 2, 3),
        mutableListOf(4, 5),
        mutableListOf(6),
    )
    for (i in 0 until graph.size) {
        print("$i -> ")
        graph[i].forEach {
            print("|$it")
        }
        println()
    }

    println()
    val graphChar: Array<MutableList<Char>> = arrayOf(
        mutableListOf('A', 'B', 'C'),
        mutableListOf('D', 'E'),
        mutableListOf('F'),
    )
    println(graphChar[0])
    println(graphChar[1])
    println(graphChar[2])
}
