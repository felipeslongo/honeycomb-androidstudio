package honeycomb.domain.valuetypes;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

class PercentageTest {
    private lateinit var _percentage50: Percentage

    @BeforeEach
    fun setUp() {
        _percentage50 = Percentage(0.5f)
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun compareTo() {
    }

    @Test
    fun isLessThan1() {
        val actual = _percentage50.isLessThan(Percentage.Percent.V040)

        assertFalse(actual)
    }

    @Test
    fun getValue() {
    }

    @Test
    fun component1() {
    }

    @Test
    fun testEquals() {
    }
}
