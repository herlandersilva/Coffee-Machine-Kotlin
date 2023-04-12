package machine

enum class Ingredient(val desc: String) {
    WATER("water"),
    MILK("milk"),
    COFFEE_BEANS("coffee beans")
}

enum class Unit(val desc: String, val unit: String) {
    ML("ml", "ml"),
    GM("grams", "g")
}