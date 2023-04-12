fun main() = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    .map { it * readLine()!!.toInt() }
    .run { indexOf(maxOrNull()) + 1 }
    .let(::println)