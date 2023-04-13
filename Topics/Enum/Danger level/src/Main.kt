enum class DangerLevel {
    LOW,
    MEDIUM,
    HIGH;

    fun getLevel(): Int {
        return this.ordinal + 1
    }
}