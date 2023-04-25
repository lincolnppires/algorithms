package search

fun binarySearch(array: IntArray, target: Int, low: Int, high: Int): Int {
    var indexLow = low
    var indexHigh = high
    var middle: Int

    while (indexLow <= indexHigh) {
        // But if we calculate the middle index like this, it fails for larger values of int variables.
        // Specifically, it fails if the sum of low and high is greater than the maximum positive int value(231 – 1 ).
        //  The sum overflows to a negative value and the value stays negative when divided by 2.
        //middle = (indexLow + indexHigh) / 2
        middle = indexLow + (indexHigh - indexLow) / 2

        // println("indexLow: ${indexLow} - indexHigh ${indexHigh} - middle ${middle}")

        if (array[middle] == target) {
            return middle
        }

        if (array[middle] > target) {
            indexHigh = middle - 1
        } else {
            indexLow = middle + 1
        }
    }

    return -1
}

fun main() {
    var firstArray = intArrayOf(5, 9, 7, 10, 2, 5, 4, 78, 26, 52, 96, 32)
    firstArray.sort()
    firstArray.forEach { print("|$it") }
    println()
    var index = binarySearch(firstArray, 96, 0, firstArray.size - 1)
    println("Position of element: $index")

    if (index != -1) {
        println("Element: ${firstArray[index]}")
    } else {
        println("Not Found")
    }
}
