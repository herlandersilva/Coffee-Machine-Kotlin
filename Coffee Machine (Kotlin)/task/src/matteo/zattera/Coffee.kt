package matteo.zattera
import java.math.BigInteger as Num

enum class Coffee(
    val water: @Milliliters Num,
    val milk: @Milliliters Num,
    val coffeeBeans: @Grams Num,
    val cost: @Dollars Num
) {

    ESPRESSO(
        water = Num(@Milliliters "250"),
        milk = Num(@Milliliters "0"),
        coffeeBeans = Num(@Grams "16"),
        cost = Num(@Dollars "4")
    ),
    LATTE(
        water = Num(@Milliliters "350"),
        milk = Num(@Milliliters "75"),
        coffeeBeans = Num(@Grams "20"),
        cost = Num(@Dollars "7")
    ),
    CAPPUCCINO(
        water = Num(@Milliliters "200"),
        milk = Num(@Milliliters "100"),
        coffeeBeans = Num(@Grams "12"),
        cost = Num(@Dollars "6")
    )
}