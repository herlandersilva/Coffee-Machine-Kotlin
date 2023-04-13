package matteo.zattera

import java.math.BigInteger as Num

class CoffeeMachine(
    private var water: @Milliliters Num,
    private var milk: @Milliliters Num,
    private var coffeeBeans: @Grams Num,
    private var money: @Dollars Num,
    private var cups: Num
) {



    private fun buy(coffeeType: Coffee) {

        val insufficientResourcesList = buildList {
            if (water < coffeeType.water) add("water")
            if (milk < coffeeType.milk) add("milk")
            if (coffeeBeans < coffeeType.coffeeBeans) add("coffee beans")
            if (cups < Num.ONE) add("cups")
        }

        if (insufficientResourcesList.isEmpty()) {

            "I have enough resources, making you a coffee!".printlnIt()
            water -= coffeeType.water
            milk -= coffeeType.milk
            coffeeBeans -= coffeeType.coffeeBeans
            cups -= Num.ONE
            money += coffeeType.cost
        } else "Sorry, not enough ${insufficientResourcesList.joinToString().replace(Regex(", ([^,]+)$"), " and $1")}!".printlnIt()
    }

    fun buy() {
        when ("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:".reply()) {
            "1" -> buy(Coffee.ESPRESSO)
            "2" -> buy(Coffee.LATTE)
            "3" -> buy(Coffee.CAPPUCCINO)
            "back" -> return
            else -> throw IllegalArgumentException("The choice must be `1`, `2`, `3` or `back`.")
        }
    }

    fun fill() {
        water += "Write how many ml of water you want to add:".reply().toBigInteger()
            .takeIfPositiveOrThrowException("The milliliters of water must be a positive integer.")
        milk += "Write how many ml of milk you want to add:".reply().toBigInteger()
            .takeIfPositiveOrThrowException("The milliliters of milk must be a positive integer.")
        coffeeBeans += "Write how many grams of coffee beans you want to add:".reply().toBigInteger()
            .takeIfPositiveOrThrowException("The grams of coffee beans must be a positive integer.")
        cups += "Write how many disposable cups you want to add:".reply().toBigInteger()
            .takeIfPositiveOrThrowException("The amount of coffee cups must be a positive integer.")
    }

    fun take() = "I gave you \$$money".printlnIt().also { money = Num("0") }

    fun remaining() = """
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $coffeeBeans g of coffee beans
        $cups disposable cups
        $$money of money""".trimIndent().printlnIt()
}