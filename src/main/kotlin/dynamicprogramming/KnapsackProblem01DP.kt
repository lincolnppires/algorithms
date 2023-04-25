package dynamicprogramming

// https://www.geeksforgeeks.org/printing-items-01-knapsack/
// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
// https://www.youtube.com/watch?v=vLLIU2UQN-o

fun knapSackDP(capacityOfKnapsack: Int, weights: IntArray, profits: IntArray, numberOfItems: Int): Int {
    var knapsackTable = Array(numberOfItems + 1) { IntArray(capacityOfKnapsack + 1) }
    knapsackTable.forEach {
        it.forEach { print("|$it") }
        println()
    }

    var totalBenefit = 0

    for (i in 1 until numberOfItems + 1) {
        for (weight in 1 until capacityOfKnapsack + 1) {
            var notTakingItem = knapsackTable[i - 1][weight]
            println("Not Taking: ${notTakingItem}")
            var takingItem = 0

            if (i < numberOfItems && weights[i] <= weight) {
                takingItem = profits[i] + knapsackTable[i - 1][weight - weights[i]]
                println("TakingItem: ${takingItem}")
            }
            knapsackTable[i][weight] = Math.max(notTakingItem, takingItem)
            knapsackTable.forEach {
                it.forEach { print("|$it") }
                println()
            }
        }
        totalBenefit = knapsackTable[numberOfItems][capacityOfKnapsack]
    }
    return totalBenefit
}

fun main() {
    var profits = intArrayOf(60, 100, 120)
    var weights = intArrayOf(1, 2, 3)
    var capacity = 5
    var numberOfItens = profits.size
    println(knapSackDP(capacity, weights, profits, numberOfItens))
}
