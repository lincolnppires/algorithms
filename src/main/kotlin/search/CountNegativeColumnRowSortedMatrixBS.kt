package search

// https://www.geeksforgeeks.org/count-negative-numbers-in-a-column-wise-row-wise-sorted-matrix/

fun countNegativeColumnRowSortedMatrixBS(matrix: Array<IntArray>): Int {
    var count = 0

    for (i in 0 until matrix.size) {
        println("Process Line $i")
        var indexLastNegative = binarySearchLastNegativeIndex(matrix[i], 0, matrix[i].size - 1)
        if (indexLastNegative >= 0) {
            println("update count add which index: $indexLastNegative")
            count = count + (indexLastNegative + 1)
            println("row $i count: $count")
        }
    }
    return count
}

fun binarySearchLastNegativeIndex(rowMatrix: IntArray, start: Int, end: Int): Int {
    rowMatrix.forEach { print("|$it") }
    var indexLow = start
    var indexHigh = end

    while (indexLow <= indexHigh) {
        var middle = indexLow + (indexHigh - indexLow) / 2
        println("Binary Search - low: $indexLow and high: $indexHigh and middle $middle")
        if (rowMatrix[middle] < 0) {
            println("Element ${rowMatrix[middle]} in index $middle")
            if (middle < rowMatrix.size - 1 && rowMatrix[middle + 1] < 0) {
                println("Increase indexLow")
                indexLow = middle + 1
            } else {
                println("last negative index $middle")
                return middle
            }
        } else {
            println("Decrease indeHigh")
            indexHigh = middle - 1
        }
    }
    return -1
}

fun main() {
    var matrix = arrayOf(
        intArrayOf(-3, -2, -1, 1),
        intArrayOf(-2, 2, 3, 4),
        intArrayOf(4, 5, 7, 8),
    )

    println("Result count: ${countNegativeColumnRowSortedMatrixBS(matrix)}")
}
