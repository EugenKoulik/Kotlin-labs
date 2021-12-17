import laba2.ArithmeticParser
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.Test as Test1

const val PRECISION = 0.00001

@RunWith(Parameterized::class)


class ArithmeticParserTests {

    private val expression = ArithmeticParser()

    @Test1
    fun test_addition_correctResult() {

        Assertions.assertEquals(10.0, expression.calculateExpressionString("5+5"), PRECISION)
    }

    @Test1
    fun test_subtraction_correctResult() {

        Assertions.assertEquals(0.0, expression.calculateExpressionString("5-5"), PRECISION)
    }

    @Test1
    fun test_multiplication_correctResult() {

        Assertions.assertEquals(25.0, expression.calculateExpressionString("5*5"), PRECISION)
    }

    @Test1
    fun test_division_correctResult() {

        Assertions.assertEquals(1.0, expression.calculateExpressionString("5/5"), PRECISION)
    }

    @Test1
    fun test_operations_correctResult() {

        Assertions.assertEquals(78.0, expression.calculateExpressionString("3+((1+2)*5^2)"), PRECISION)
    }

    @Test1
    fun test_noOperations_correctResult() {

        Assertions.assertEquals(25.0, expression.calculateExpressionString("25"), PRECISION)
    }


    @Test1
    fun test_moreBrackets_correctResult() {

        Assertions.assertEquals(14.0, expression.calculateExpressionString("((4+3))*8/4"), PRECISION)
    }

    @Test1
    fun test_moreBrackets_uncorrectResult() {

        try {

            expression.calculateExpressionString("5+5)")

        } catch (e: RuntimeException) {

            Assertions.assertEquals("Out of balance between brackets!", e.message)
        }
    }

    @Test1
    fun test_moreGaps_correctResult() {

        Assertions.assertEquals(-15.75, expression.calculateExpressionString("(4    + 3)  * 9 / -  4"), PRECISION)
    }

    @Test1
    fun test_unaryPlus_correctResult() {

        Assertions.assertEquals(259.0, expression.calculateExpressionString("3 + 4 ^ +4"), PRECISION)
    }

    @Test1
    fun test_unaryMinus_correctResult() {

        Assertions.assertEquals(-2.99609, expression.calculateExpressionString("-3 + 4 ^ -4"), PRECISION)
    }


    @Test1
    fun test_emptyExpression_exception() {
        try {

            expression.calculateExpressionString("")

        } catch (e: RuntimeException) {

            Assertions.assertEquals("Empty string", e.message)
        }
    }

    @Test1
    fun test_outOfOrderOfOperators_exception() {
        try {

            expression.calculateExpressionString("*2 - 1")

        } catch (e: RuntimeException) {

            Assertions.assertEquals("Unexpected token", e.message)
        }
    }

    @Test1
    fun test_onlyBrackets_exception() {
        try {

            expression.calculateExpressionString("()")

        } catch (e: RuntimeException) {

            Assertions.assertEquals("Unexpected token", e.message)
        }
    }


    @Test1
    fun test_binaryOperationAfterOperation_exception() {
        try {

            expression.calculateExpressionString("2 */ 3")

        } catch (e: RuntimeException) {

            Assertions.assertEquals("Unexpected token", e.message)
        }
    }


    @Test1
    fun test_wrongClosingBracket_exception() {
        try {

            expression.calculateExpressionString("()*(1 * 4)")

        } catch (e: RuntimeException) {

            Assertions.assertEquals("Unexpected token", e.message)
        }
    }

}