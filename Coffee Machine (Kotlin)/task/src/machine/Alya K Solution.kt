package machine

fun main() {
    val coffeeMachine = DataCoffeeMachine()
    coffeeMachine.printing()
    println("Write action (buy, fill, take): ")
    when (readln()) {
        "buy" -> { println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
            when(readln().toInt()) {
                1 -> coffeeMachine.buy(Coffee.espresso)
                2 -> coffeeMachine.buy(Coffee.latte)
                3 -> coffeeMachine.buy(Coffee.cappuccino)
            }
        }
        "fill" -> coffeeMachine.fill()
        "take" -> coffeeMachine.take()
    }
    coffeeMachine.printing()
}

data class Coffee(val water: Int, val milk: Int, val beans: Int, val price: Int) {
    companion object {
        val espresso = Coffee(water = 250, milk = 0, beans = 16, price = 4)
        val latte = Coffee(water = 350, milk = 75, beans = 20, price = 7)
        val cappuccino = Coffee(water = 200, milk = 100, beans = 12, price = 6)
    }
}

data class DataCoffeeMachine(var water: Int = 400, var milk: Int = 540,
                             var beans: Int = 120, var money: Int = 550,
                             var cups: Int = 9) {
    fun printing() {
        println("The coffee machine has:\n" +
                "$water ml of water\n" +
                "$milk ml of milk\n" +
                "$beans g of coffee beans\n" +
                "$cups disposable cups\n" +
                "$$money of money\n")
    }

    fun buy(a: Coffee, cup: Int = 1) {
        water -= a.water
        milk -= a.milk
        beans -= a.beans
        money += a.price
        cups -= cup
    }

    fun fill() {
        println("Write how many ml of water you want to add: ")
        water += readln().toInt()
        println("Write how many ml of milk you want to add: ")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add: ")
        beans += readln().toInt()
        println("Write how many disposable cups you want to add: ")
        cups += readln().toInt()
    }

    fun take() {
        println("I gave you $$money")
        money = 0
    }
}