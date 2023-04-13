data class AmirDataCity(val name: String) {
    var degrees: Int = 0
        set(temp) {
            val checkTemp: (Int) -> Int = { if (temp < -92 || temp > 57) it else temp }
            field = when (name) {
                "Moscow" -> checkTemp(5)
                "Hanoi" -> checkTemp(20)
                "Dubai" -> checkTemp(30)
                else -> throw Exception("Unknown city")
            }
        }
}

fun coldestCity(vararg cities: AmirDataCity) = cities.minByOrNull { it.degrees }
    ?.let { city -> if (cities.count { city.degrees == it.degrees } != 1) "neither" else city.name }

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = AmirDataCity("Dubai")
    firstCity.degrees = first
    val secondCity = AmirDataCity("Moscow")
    secondCity.degrees = second
    val thirdCity = AmirDataCity("Hanoi")
    thirdCity.degrees = third

    print(coldestCity(firstCity, secondCity, thirdCity))
}
