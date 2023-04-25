package logic

fun reverseNumber(numberInput: Int): Int {
    var reverseNumber = 0
    var number = numberInput

    while (number != 0) {
        var remainder = number % 10
        reverseNumber = reverseNumber * 10 + remainder
        number = number / 10
    }
    return reverseNumber
}

fun main() {
    println("Reverse: ${reverseNumber(987654321)}")
    println("Reverse: ${reverseNumber(123456789)}")
    println("Reverse: ${reverseNumber(0)}")
}
