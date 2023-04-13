data class ThomasDataCity(val name: String, private val temperature: Int) {
    var degrees: Int = temperature
        set(value) {
            field = if (value !in -92..57) temperature else value
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = ThomasDataCity("Dubai", 30)
    firstCity.degrees = first
    val secondCity = ThomasDataCity("Moscow", 5)
    secondCity.degrees = second
    val thirdCity = ThomasDataCity("Hanoi", 20)
    thirdCity.degrees = third

    val cities = listOf(firstCity, secondCity, thirdCity)
        .sortedBy(ThomasDataCity::degrees)
        .distinctBy { it.degrees }

    print(if (cities.size < 3) "neither" else cities.first().name)
}