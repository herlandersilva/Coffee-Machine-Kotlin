const val SIZE = 3

fun main() {
    val (s1, operator, s2) = List(SIZE) { readln() }

    println(
        when (operator) {
            Operator.EQUALS.operation -> Operator.EQUALS.result(s1, s2)
            Operator.PLUS.operation -> Operator.PLUS.result(s1, s2)
            Operator.ENDS_WITH.operation -> Operator.ENDS_WITH.result(s1, s2)
            else -> Operator.UNKNOWN.result(s1, s2)
        }
    )
}

enum class Operator(
    val operation: String = "",
    val result: (String, String) -> Any
) {
    EQUALS(
        operation = "equals",
        result = { s1, s2 ->
            s1 == s2
        }
    ),
    PLUS(
        operation = "plus",
        result = { s1, s2 ->
            s1 + s2
        }
    ),
    ENDS_WITH(
        operation = "endsWith",
        result = { s1, s2 ->
            s1.endsWith(s2)
        }
    ),
    UNKNOWN(
        result = { _, _ ->
            "Unknown operation"
        }
    )
}