package machine

data class Volume(val ingredient: Ingredient, var quantity: UInt, val unit: machine.Unit) {
    override fun toString(): String {
        return "%d %s of %s".format(quantity.toInt(), unit.unit, ingredient.desc)
    }
}