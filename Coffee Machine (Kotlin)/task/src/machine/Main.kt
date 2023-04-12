package machine

fun main() {
    Util.disableToSend()
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.`Buy, fill and take`()
}