package honeycomb.domain.valuetypes

import honeycomb.kotlin.ComparableResult

/**
 * It represents a percentage value type
 * and provides a high-level abstraction to manipulate percent values.
 * The percentage is stored as a [Float] [value].
 */
data class Percentage(val value: Float) : Comparable<Percentage> {
    override fun compareTo(other: Percentage) = comparator.compare(this, other)

    fun isLessThan(percent: Percent): Boolean {
        val other = create(percent)
        return when (compareTo(other)) {
            ComparableResult.LESS.result -> true
            else -> false
        }
    }

    companion object {
        //using the method reference syntax as an alternative to lambdas
        val comparator = compareBy(Percentage::value)

        fun create(percent: Percent) =
            Percentage(percent.value.toFloat() / 100f)

        /**
         * Creates from a division operation of two integers.
         * @param dividend is number that will be divided
         * @param divisor is the number that will divide the [dividend]
         * @return [Percentage] instance
         */
        fun create(dividend: Int, divisor: Int) =
            Percentage(dividend.toFloat() / divisor.toFloat())
    }

    /**
     * Convenience enum whose each member represents
     * a constant [Integer] percent [value] from 0 to 100
     */
    enum class Percent(val value: Int) {
        V000(0),
        V005(5),
        V010(10),
        V020(20),
        V030(30),
        V040(40),
        V050(50),
        V060(60),
        V070(70),
        V080(80),
        V090(90),
        V095(95),
        V100(100)
    }
}
