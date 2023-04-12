fun main() {
    val size = readln().toInt()
    val mutList: MutableList<Int> = mutableListOf()
    for (i in 0 until size) {
        mutList.add(readln().toInt())
    }
    val shift = readln().toInt() % size

    val newList:MutableList<Int> = mutableListOf()
    newList += mutList.subList(size - shift, size)
    newList += mutList.subList(0, size - shift)

    println(newList.joinToString(" "))
}
