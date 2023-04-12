fun main() {
    val n = readln().toInt()
    val companyIncome = MutableList<Double>(n) { readln().toDouble() }
    val taxRate = MutableList<Double>(n) { readln().toDouble() * 0.01 }
    val companyTax = MutableList<Double>(n) { companyIncome[it] * taxRate[it] }

    println(companyTax.indexOf(companyTax.maxOrNull()).plus(1))
}