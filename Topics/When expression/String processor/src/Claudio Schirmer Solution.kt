fun main() {
    Array(3) { readLine()!! }
        .run {
            val (a, o, b) = this
            when (o) {
                "equals" -> a.equals(b)
                "plus" -> a + b
                "endsWith" -> a.endsWith(b)
                else -> "Unknown operation"
            }
        }.let(::println)
}