package mf

class Machine() {
    private constructor(water: Int, milk: Int, beans: Int, cups: Int, money: Int) : this() {
        this.state = State(water, milk, beans, cups, money)
    }

    enum class Coffee(val cost: Int, val water: Int, val milk: Int, val beans: Int) {
        ESPRESSO(4, 250, 0, 16),
        LATTE(7, 350, 75, 20),
        CAPPUCCINO(6, 200, 100, 12)
    }

    private inner class State(var water: Int, var milk: Int, var beans: Int, var cups: Int, var money: Int)

    companion object Factory {
        fun init(water: Int, milk: Int, beans: Int, cups: Int, money: Int): Machine =
            Machine(water, milk, beans, cups, money)
    }

    private var state = State(0, 0, 0, 0, 0)

    fun printState() {
        val state = """
      The coffee machine has:
      ${state.water} ml of water
      ${state.milk} ml of milk
      ${state.beans} g of coffee beans
      ${state.cups} disposable cups
      $${state.money} of money
      """.trimIndent()
        println(state)
    }

    fun sellCoffee() {
        when (readInt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")) {
            1 -> deductCoffeeFromState(Coffee.ESPRESSO)
            2 -> deductCoffeeFromState(Coffee.LATTE)
            3 -> deductCoffeeFromState(Coffee.CAPPUCCINO)
        }
    }

    private fun deductCoffeeFromState(coffee: Coffee) {
        state.water -= coffee.water
        state.milk -= coffee.milk
        state.beans -= coffee.beans
        state.cups -= 1
        state.money += coffee.cost
    }

    fun topUp() {
        state.water += readInt("Write how many ml of water you want to add:")
        state.milk += readInt("Write how many ml of milk you want to add:")
        state.beans += readInt("Write how many grams of coffee beans you want to add:")
        state.cups += readInt("Write how many disposable cups you want to add:")
    }

    fun giveMoney() {
        println("I gave you $${state.money}")
        state.money = 0
    }
}

fun main() {
    val machine = Machine.init(400, 540, 120, 9, 550)
    machine.printState()

    println("Write action (buy, fill, take):")
    val action = readln()
    when (action) {
        "buy" -> machine.sellCoffee()
        "fill" -> machine.topUp()
        "take" -> machine.giveMoney()
    }

    machine.printState()
}

fun readInt(prompt: String): Int {
    println(prompt)
    return readln().toInt()
}
