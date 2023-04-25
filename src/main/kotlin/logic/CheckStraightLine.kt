package logic

data class Point(val x: Int, val y: Int)

fun checkStraightLine(coordinates: Array<Point>): Boolean {
    var slope = coordinates[1].y - coordinates[0].y.toDouble() / coordinates[1].x - coordinates[0].x.toDouble()

    for (i in 1 until coordinates.size - 1) {
        var numerator = coordinates[i + 1].y - coordinates[i].y
        var denominator = coordinates[i + 1].x - coordinates[i].x
        var actualSlope = numerator.toDouble() / denominator.toDouble()

        if (actualSlope != slope) {
            return false
        }
    }
    return true
}

fun main() {
    var coordinates = arrayOf(
        Point(1, 2),
        Point(2, 3),
        Point(3, 4),
        Point(4, 5),
        Point(5, 6),
        Point(6, 7),
    )
    println(
        "Result: ${
            checkStraightLine(coordinates)}",
    )

    coordinates = arrayOf(
        Point(1, 1),
        Point(2, 2),
        Point(3, 4),
        Point(4, 5),
        Point(5, 6),
        Point(7, 7),
    )
    println("Result: ${
        checkStraightLine(coordinates)}")
}
