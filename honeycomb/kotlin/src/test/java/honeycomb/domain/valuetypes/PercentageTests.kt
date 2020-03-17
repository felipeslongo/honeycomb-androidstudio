package honeycomb.domain.valuetypes;

import honeycomb.kotlin.ComparableResult
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import java.lang.Exception

open class PercentageTests {
    protected lateinit var percentage50: Percentage

    @BeforeEach
    fun setUp() {
        percentage50 = Percentage(0.5f)
    }

    @AfterEach
    fun tearDown() {
    }

    class CreateTests : PercentageTests(){
        @Test
        fun givenAnPercent_whenCreatedFromIt_shouldCreateAEqualPercentage(){
            val percent = Percentage.Percent.V050

            val actual = Percentage.create(percent)

            assertEquals(0.5f, actual.value)
        }

        @Test
        fun givenAZeroDivisor_whenCreatedFromIt_shouldReturnAInfinityFloat(){
            val zeroDivisor = 0

            val actual = Percentage.create(50, zeroDivisor)

            assertEquals(Float.POSITIVE_INFINITY, actual.value)
        }

        @Test
        fun givenTwoIntegers_whenCreatedFromIt_shouldCreateAPercentageFromTheDivision(){
            val actual = Percentage.create(50, 100)

            assertEquals(0.5f, actual.value)
        }
    }

    class CompareToTests : PercentageTests(){
        @Test
        fun givenAnEqualPercentage_whenComparedTo_shouldBeEqualTo(){
            val equalTo = Percentage(0.5f)

            val actual = percentage50.compareTo(equalTo)

            assertEquals(ComparableResult.EQUAL, actual)
        }

        @Test
        fun givenAnGreaterPercentage_whenComparedTo_shouldBeLessThan(){
            val greaterThan50 = Percentage(0.55f)

            val actual = percentage50.compareTo(greaterThan50)

            assertEquals(ComparableResult.GREATER, actual)
        }

        @Test
        fun givenAnLesserPercentage_whenComparedTo_shouldBeGreaterThan(){
            val lessThan50 = Percentage(0.45f)

            val actual = percentage50.compareTo(lessThan50)

            assertEquals(ComparableResult.LESS, actual)
        }
    }

    class IsLessThanTests : PercentageTests(){
        @Test
        fun givenAnEqualPercent_whenComparedTo_shouldBeFalse(){
            val equalTo = Percentage.Percent.V050

            val actual = percentage50.isLessThan(equalTo)

            assertFalse(actual)
        }

        @Test
        fun givenAnGreaterPercent_whenComparedTo_shouldBeFalse(){
            val greaterThan50 = Percentage.Percent.V060

            val actual = percentage50.isLessThan(greaterThan50)

            assertTrue(actual)
        }

        @Test
        fun givenAnLesserPercent_whenComparedTo_shouldBeTrue(){
            val lessThan50 = Percentage.Percent.V040

            val actual = percentage50.isLessThan(lessThan50)

            assertFalse(actual)
        }
    }
}
