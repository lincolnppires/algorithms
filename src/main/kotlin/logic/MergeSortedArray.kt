package logic

// https://leetcode.com/problems/merge-sorted-array/

fun mergeSortedArray(nums1: IntArray, num2: IntArray, m: Int, n: Int): IntArray {
    var indexNums1 = m - 1
    var indexNums2 = n - 1
    var indexSolution = nums1.size - 1

    while (indexNums1 >= 0 && indexNums2 >= 0) {
        nums1.forEach {
            print("|$it")
        }
        println()
        if (nums1[indexNums1] >= num2[indexNums2]) {
            nums1[indexSolution] = nums1[indexNums1]
            indexNums1--
        } else {
            nums1[indexSolution] = num2[indexNums2]
            indexNums2--
        }
        indexSolution--
    }
    println()
    while (indexNums2 >= 0) {
        nums1.forEach {
            print("|$it")
        }
        nums1[indexSolution] = num2[indexNums2]
        indexNums2--
        indexSolution--
    }
    while (indexNums1 >= 0) {
        nums1.forEach {
            print("|$it")
        }
        nums1[indexSolution] = nums1[indexNums1]
        indexNums1--
        indexSolution--
    }

    return nums1
}

fun main() {
    var nums1 = intArrayOf(1, 2, 5, 0, 0, 0)
    var nums2 = intArrayOf(12, 13, 16)
    var result = mergeSortedArray(nums1, nums2, 3, 3)
    println("\nResult final:")
    result.forEach {
        print("|$it")
    }
}
