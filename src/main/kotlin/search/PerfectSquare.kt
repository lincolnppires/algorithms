package search

fun isPerfectSquare(number: Int): Boolean {
    // resolve by binary search
    // high is number / 2 -> (number / 2)^2 is much more bigger than number
    var low = 1
    var high = number / 2
    var middle: Int

    if (number == 1) {
        return true
    }

    while(low <= high){
        middle = low + (high - low) / 2
        var squareMiddle = middle * middle

        if(squareMiddle == number) {
            println("number: ${middle}")
            return true
        }

        if(squareMiddle > number){
            high = middle - 1
        } else {
            low = middle + 1
        }
    }

    return false
}

fun main() {
    println("Perfect Number: ${isPerfectSquare(12)}")
}
