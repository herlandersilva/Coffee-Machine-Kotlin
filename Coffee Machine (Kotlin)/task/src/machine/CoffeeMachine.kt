package machine

class CoffeeMachine {
    private var cups: Int = 9
    private var money = Monetary(550)
    private val waterSupplier: Volume = Volume(Ingredient.WATER, 400U, Unit.ML)
    private val milkSupplier: Volume = Volume(Ingredient.MILK, 540U, Unit.ML)
    private val coffeeBeansSupplier: Volume = Volume(Ingredient.COFFEE_BEANS, 120U, Unit.GM)

    fun `Starting to make a coffee`() = println("Starting to make a coffee")
    fun `Grinding coffee beans`() = println("Grinding coffee beans")
    fun `Boiling water`() = println("Boiling water")
    fun `Mixing boiled water with crushed coffee beans`() = println("Mixing boiled water with crushed coffee beans")
    fun `Pouring coffee into the cup`() = println("Pouring coffee into the cup")
    fun `Pouring some milk into the cup`() = println("Pouring some milk into the cup")
    fun `Coffee is ready!`() = println("Coffee is ready!")
    fun `How many ingredients to make x cups of coffee`() = this.howManyIngredientsNeedToMakeCoffeeXCups()
    fun `How many supplier the machine has`() = this.howManySupplierTheMachineHas()
    fun `Buy, fill and take`() = this.buyFillAndTake()


    override fun toString(): String {
        return "The coffee machine has:" + "\n" +
                this.machineSupplier()
    }

    private fun machineSupplier(): String {
        return this.waterSupplier.toString() + "\n" +
                this.milkSupplier.toString() + "\n" +
                this.coffeeBeansSupplier.toString() + "\n" +
                "%d disposable cups".format(cups) + "\n" +
                "%s%d of money".format(this.money.symbol, this.money.amount)
    }

    private fun howManyIngredientsNeedToMakeCoffeeXCups() {
        this.cups = Util.ask("Write how many cups of coffee you will need:").toInt()
        println(this.toString())
        val stdCoffeeCup = StandardCoffeeCup()
        val customWater: Volume = Volume(
            stdCoffeeCup.waterVolume.ingredient,
            stdCoffeeCup.waterVolume.quantity * cups.toUInt(),
            stdCoffeeCup.waterVolume.unit
        )
        val customMilk: Volume = Volume(
            stdCoffeeCup.milkVolume.ingredient,
            stdCoffeeCup.milkVolume.quantity * cups.toUInt(),
            stdCoffeeCup.milkVolume.unit
        )
        val customCoffeeBeans: Volume = Volume(
            stdCoffeeCup.coffeeVolume.ingredient,
            stdCoffeeCup.coffeeVolume.quantity * cups.toUInt(),
            stdCoffeeCup.coffeeVolume.unit
        )
        val customCoffeeCup = CustomCoffeeCup(customWater, customMilk, customCoffeeBeans)
        println(customCoffeeCup.waterVolume)
        println(customCoffeeCup.milkVolume)
        println(customCoffeeCup.coffeeVolume)
    }

    private fun howManySupplierTheMachineHas() {
        val waterSupplier = Volume(
            Ingredient.WATER,
            Util.ask("Write how many %s of %s the coffee machine has:".format(Unit.ML.desc, Ingredient.WATER.desc)).toUInt(),
            Unit.ML
        )
        val milkSupplier = Volume(
            Ingredient.MILK,
            Util.ask("Write how many %s of %s the coffee machine has:".format(Unit.ML.desc, Ingredient.MILK.desc)).toUInt(),
            Unit.ML
        )
        val coffeeBeansSupplier = Volume(
            Ingredient.COFFEE_BEANS,
            Util.ask("Write how many %s of %s the coffee machine has:".format(Unit.GM.desc, Ingredient.COFFEE_BEANS.desc)).toUInt(),
            Unit.GM
        )
        this.cups = Util.ask("Write how many cups of coffee you will need:").toInt()
        val nimOfCoffeePossible = StandardCoffeeCup().haveManySupplierToMakeCupOfCoffee(waterSupplier, milkSupplier, coffeeBeansSupplier)
        when {
            this.cups == nimOfCoffeePossible -> "Yes, I can make that amount of coffee"
            this.cups > nimOfCoffeePossible -> "No, I can make only %d cups of coffee".format(nimOfCoffeePossible)
            else -> "Yes, I can make that amount of coffee (and even %d more than that)".format(nimOfCoffeePossible - this.cups)
        }.also(::println)
    }

    private fun buyFillAndTake() {
        this.toString().let(::println)
        println()
        this.actionMenu()
        println()
        this.toString().let(::println)
    }

    private fun actionMenu() {
        when (Util.ask("Write action (buy, fill, take):")) {
            "buy" -> buyCoffee()
            "fill" -> fillSupplyMachine()
            "take" -> takeTheMoney()
        }
    }

    private fun buyCoffee() {
        val typeOfDrinkCoffee: MutableMap<String, CustomCoffeeCup> = mutableMapOf(
            "espresso" to CustomCoffeeCup(
                Volume(Ingredient.WATER, 250U, Unit.ML),
                Volume(Ingredient.MILK, 0U, Unit.ML),
                Volume(Ingredient.COFFEE_BEANS, 16U, Unit.GM),
                4
            ),
            "latte" to CustomCoffeeCup(
                Volume(Ingredient.WATER, 350U, Unit.ML),
                Volume(Ingredient.MILK, 75U, Unit.ML),
                Volume(Ingredient.COFFEE_BEANS, 20U, Unit.GM),
                7
            ),
            "cappuccino" to CustomCoffeeCup(
                Volume(Ingredient.WATER, 200U, Unit.ML),
                Volume(Ingredient.MILK, 100U, Unit.ML),
                Volume(Ingredient.COFFEE_BEANS, 12U, Unit.GM),
                6
            )
        ).toMutableMap()

        val cupNumber = mapOf(
            1 to "espresso",
            2 to "latte",
            3 to "cappuccino"
        )

        val optionCoffee = Util.ask("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:").toInt()
        this.waterSupplier.quantity -= typeOfDrinkCoffee[cupNumber[optionCoffee]]?.waterVolume?.quantity ?: 0U
        this.milkSupplier.quantity -= typeOfDrinkCoffee[cupNumber[optionCoffee]]?.milkVolume?.quantity ?: 0U
        this.coffeeBeansSupplier.quantity -= typeOfDrinkCoffee[cupNumber[optionCoffee]]?.coffeeVolume?.quantity ?: 0U
        this.cups--
        this.money.amount += typeOfDrinkCoffee[cupNumber[optionCoffee]]?.price ?: 0
    }

    private fun fillSupplyMachine() {
        this.waterSupplier.quantity += Util.ask("Write how many %s of %s you want to add:".format(Unit.ML.desc, Ingredient.WATER.desc)).toUInt()
        this.milkSupplier.quantity += Util.ask("Write how many %s of %s you want to add:".format(Unit.ML.desc, Ingredient.MILK.desc)).toUInt()
            this.coffeeBeansSupplier.quantity += Util.ask("Write how many %s of %s you want to add:".format(Unit.GM.desc, Ingredient.COFFEE_BEANS.desc)).toUInt()
        this.cups += Util.ask("Write how many disposable cups you want to add:").toInt()
    }

    private fun takeTheMoney() {
        "I gave you %s%d".format(this.money.symbol, this.money.amount).let(::println)
        this.money.amount = 0
    }
}

abstract class CoffeeCup {
    abstract val waterVolume: Volume
    abstract val milkVolume: Volume
    abstract val coffeeVolume: Volume
}

class CustomCoffeeCup(
    _waterVolume: Volume,
    _milkVolume: Volume,
    _coffeeVolume: Volume,
    _price: Int = 0
) : CoffeeCup() {
    val price = _price
    override val waterVolume = _waterVolume
    override val milkVolume = _milkVolume
    override val coffeeVolume = _coffeeVolume
}

class StandardCoffeeCup : CoffeeCup() {
    override val waterVolume = Volume(Ingredient.WATER, 200U, Unit.ML)
    override val milkVolume = Volume(Ingredient.MILK, 50U, Unit.ML)
    override val coffeeVolume = Volume(Ingredient.COFFEE_BEANS, 15U, Unit.GM)

    fun haveManySupplierToMakeCupOfCoffee(waterSupplier: Volume, milkSupplier: Volume, coffeeBeansSupplier: Volume): Int {
        return listOf(
            waterSupplier.quantity / waterVolume.quantity,
            milkSupplier.quantity / milkVolume.quantity,
            coffeeBeansSupplier.quantity / coffeeVolume.quantity
        ).minOf { it.toInt() }
    }
}