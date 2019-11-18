package honeycomb.kotlin

/**
 * Convenience result enum values to be used by classes implementing [Comparable] interface.
 * Make your intentions clear.
 */
enum class ComparableResult(val result: Int) {
    /**
     * Represents a comparison result where an object is less than other object
     */
    LESS(-1),
    /**
     * Represents a comparison result where an object is equal to other object
     */
    EQUAL(0),
    /**
     * Represents a comparison result where an object is greater than other object
     */
    GREATER(1)
}
