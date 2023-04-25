package logic

//https://www.geeksforgeeks.org/count-negative-numbers-in-a-column-wise-row-wise-sorted-matrix/

fun countNegativeColumnRowSortedMatrix(matrix: Array<IntArray>): Int {
    matrix.forEach {
        it.forEach {
            print("| $it")
        }
        println()
    }
    var count = 0
    var indexLine = 0
    var indexColumn = matrix[0].size - 1

    while (indexLine < matrix.size && indexColumn >= 0) {
        if (matrix[indexLine][indexColumn] < 0) {
            count = count + (indexColumn + 1)
            indexLine++
        } else {
            indexColumn--
        }
    }

    return count
}

fun main() {
    var matrix: Array<IntArray> = arrayOf<IntArray>(
        intArrayOf(-3, -2, -1, 1),
        intArrayOf(-2, 2, 3, 4),
        intArrayOf(4, 5, 7, 8),
    )

    println("Result: ${countNegativeColumnRowSortedMatrix(matrix)}")
}
