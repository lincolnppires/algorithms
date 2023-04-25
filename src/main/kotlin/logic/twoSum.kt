package logic

fun twoSum2For(numbers: IntArray, target: Int): IntArray? {
    var hashNumber = HashMap<Int, Int>()

    for (index in 0 until numbers.size) {
        hashNumber.put(numbers[index], index)
    }
//    hashNumber.forEach { entry ->
//        println("${entry.key}: ${entry.value}")
//    }

    for (index in 0 until numbers.size) {
        var complement = target - numbers[index]
        if (hashNumber.contains(complement) && hashNumber[complement] != index) {
            return intArrayOf(index, hashNumber[complement]!!)
        }
    }
    return null
}

fun twoSum1For(numbers: IntArray, target: Int): IntArray? {
    var hashNumber = HashMap<Int, Int>()

    for (index in 0 until numbers.size) {
        var complement = target - numbers[index]
        if (hashNumber.contains(complement) && hashNumber[complement] != index) {
            return intArrayOf(index, hashNumber[complement]!!)
        }
        hashNumber.put(numbers[index], index)
    }
    return null
}

fun main() {
    println("Two for")
    var numbers = intArrayOf(2, 7, 11, 15)
    twoSum2For(numbers, 9)?.forEach {
        print("|$it")
    }

    println("\nOne for")
    twoSum1For(numbers, 9)?.forEach {
        print("|$it")
    }
}
