const val MAX_WEATHER = 57
const val MIN_WEATHER = -97

const val DEFAULT_TEMP_DUBAI = 30
const val DEFAULT_TEMP_MOSCOW = 5
const val DEFAULT_TEMP_HANOI = 20

enum class DefaultTemp(val nameCity: String, val defaultTemp: Int) {
    DUBAI("Dubai", DEFAULT_TEMP_DUBAI),
    MOSCOW("Moscow", DEFAULT_TEMP_MOSCOW),
    HANOI("Hanoi", DEFAULT_TEMP_HANOI);

    fun getTemp(): Int {
        return this.defaultTemp
    }
}
class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value !in MIN_WEATHER..MAX_WEATHER) DefaultTemp.valueOf(name.uppercase()).getTemp() else value
        }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    // implement comparing here
    val list = listOf(firstCity, secondCity, thirdCity)
    val minTemp = list.minOf { it.degrees }
    list.takeIf { it -> it.count { it.degrees == minTemp } > 1 }?.apply { println("neither") }
        ?: run { list[list.indexOfFirst { it.degrees == minTemp }].name.let(::println) }
}