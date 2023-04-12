package machine

fun main() {
    Util.enableToSend()
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.`Buy, fill and take`()
}