fun main() {
    val first = readln()
    val operation = readln()
    val second = readln()
    when (operation) {
        "equals" -> (first == second).toString()
        "plus" -> first + second
        "endsWith" -> first.endsWith(second, true).toString()
        else -> "Unknown operation"
    }.let(::println)
}