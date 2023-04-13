fun main() {
    // Do not touch code below
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    // write your code here
    inputList.first().first().let(::print)
    " ".let(::print)
    inputList.first().last().let(::println)
    inputList.last().first().let(::print)
    " ".let(::print)
    inputList.last().last().let(::println)

}
