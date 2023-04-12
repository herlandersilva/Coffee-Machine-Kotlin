fun main() {
    val (first, operator, second) = readln()!!.split(" ")
    val firstNumber = first.toLong()
    val secondNumber = second.toLong()
    println( when (operator) {
        "+" -> firstNumber + secondNumber
        "-" -> firstNumber - secondNumber
        "/" -> {
            try {
                firstNumber / secondNumber
            } catch (_: ArithmeticException) {
                "Division by 0!"
            }
        }
        "*" -> firstNumber * secondNumber
        else -> "Unknown operator"
    })
}