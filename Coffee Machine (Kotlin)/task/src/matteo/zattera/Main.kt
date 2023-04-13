package matteo.zattera

import java.math.BigInteger as Num

fun <T> T.printlnIt() = println(this)
fun <T> T.reply() = this.printlnIt().run { readln() }
fun Num.takeIfPositiveOrThrowException(message: String) = takeIf { it >= Num.ZERO } ?: throw IllegalArgumentException(message)

fun mainMatteoZattera() {

    val coffeeMachine = CoffeeMachine(
        Num(@Milliliters "400"),
        Num(@Milliliters "540"),
        Num(@Grams "120"),
        Num(@Dollars "550"),
        Num("9")
    )

    while (true) {
        when ("Write action (buy, fill, take, remaining, exit):".reply()) {
            "buy" -> coffeeMachine.buy()
            "fill" -> coffeeMachine.fill()
            "take" -> coffeeMachine.take()
            "remaining" -> coffeeMachine.remaining()
            "exit" -> break
            else -> throw IllegalArgumentException("Invalid action.")
        }
    }
}