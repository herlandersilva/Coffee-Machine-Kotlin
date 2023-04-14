fun main() {
    val inputList = mutableListOf(
        mutableListOf(mutableListOf(0, 0, 0), mutableListOf(0, 0, 0), mutableListOf(0, 0, 0)),
        mutableListOf(mutableListOf(0, 0, 0), mutableListOf(0, 0, 0), mutableListOf(0, 0, 0)),
        mutableListOf(mutableListOf(0, 0, 0), mutableListOf(0, 0, 0), mutableListOf(0, 0, 0))
    )

    "[".let(::print)
    inputList.joinToString().let(::print)
    "]".let(::println)
}