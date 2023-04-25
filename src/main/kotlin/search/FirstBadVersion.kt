package search

fun firstBadVersion(lastVersion: Int): Int {
    var start = 1
    var end = lastVersion
    var result = -1

    while (start <= end) {
        var middle = start + (end - start) / 2
        var isBad = isBadVersion(middle)

        if (isBad) {
            result = middle
            end = middle - 1
        } else {
            start = middle + 1
        }
    }
    return result
}

fun main() {
    println("First bad version: ${firstBadVersion(10)}")
}
private fun isBadVersion(version: Int): Boolean {
    return version >= 3
}
