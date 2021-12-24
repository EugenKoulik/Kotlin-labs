package laba4_Tests

import laba4.*
import org.junit.jupiter.api.Assertions
import kotlin.test.Test

private const val PRECISION = 0.00001

class MatrixTests {

    private val matrix1 = Matrix(
        listOf(
            doubleArrayOf(1.0, 2.0),
            doubleArrayOf(3.0, 4.0)
        )
    )
    private val matrix2 = Matrix(
        listOf(
            doubleArrayOf(1.0, 0.0),
            doubleArrayOf(0.0, 1.0)
        )
    )


    @Test
    fun test_initByArray_correctResult() {

        val matrixArr = listOf(
            doubleArrayOf(1.0, 2.0),
            doubleArrayOf(3.0, 4.0)
        )

        val matrix4 = Matrix(matrixArr)

        Assertions.assertEquals(Pair(2, 2), matrix4.size)
        Assertions.assertEquals(1.0, matrix4[0, 0])
        Assertions.assertEquals(2.0, matrix4[0, 1])
        Assertions.assertEquals(3.0, matrix4[1, 0])
        Assertions.assertEquals(4.0, matrix4[1, 1])
    }

    @Test
    fun test_initBySize_correctResult() {

        val matrix4 = Matrix(rows = 2, columns = 2)

        matrix4[0, 0] = 1.0
        matrix4[0, 1] = 2.0
        matrix4[1, 0] = 3.0
        matrix4[1, 1] = 4.0

        Assertions.assertEquals(Pair(2, 2), matrix4.size)
        Assertions.assertEquals(1.0, matrix4[0, 0])
        Assertions.assertEquals(2.0, matrix4[0, 1])
        Assertions.assertEquals(3.0, matrix4[1, 0])
        Assertions.assertEquals(4.0, matrix4[1, 1])
    }

    @Test
    fun test_emptyMatrix_exception() {

        try {

            Matrix(emptyList())

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(EMPTY_MATRIX, e.message)
        }
    }

    @Test
    fun test_differentRows_exception() {

        try {

            Matrix(listOf(doubleArrayOf(1.0, 2.0), doubleArrayOf(3.0, 4.0, 5.0)))

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }

    @Test
    fun test_plus_correctResult() {

        val matrixAnswer = Matrix(
            listOf(
                doubleArrayOf(2.0, 2.0),
                doubleArrayOf(3.0, 5.0)
            )
        )

        Assertions.assertEquals(matrixAnswer, (matrix1 + matrix2))
    }


    @Test
    fun test_plusDifferentSize_exception() {

        try {

            Matrix(listOf(doubleArrayOf(1.0, 2.0), doubleArrayOf(3.0, 4.0))) + matrix1

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }


    @Test
    fun test_minus_correctResult() {

        val matrixAnswer = Matrix(
            listOf(
                doubleArrayOf(0.0, 2.0),
                doubleArrayOf(3.0, 3.0)
            )
        )

        Assertions.assertEquals(matrixAnswer, (matrix1 - matrix2))
    }

    @Test
    fun test_minusDifferentSize_exception() {

        try {

            Matrix(listOf(doubleArrayOf(1.0, 2.0), doubleArrayOf(3.0, 4.0))) - matrix1

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }

    @Test
    fun test_times_correctResult() {

        val matrixAnswer = Matrix(
            listOf(
                doubleArrayOf(1.0, 2.0),
                doubleArrayOf(3.0, 4.0)
            )
        )

        Assertions.assertEquals(matrixAnswer, (matrix1 * matrix2))
    }


    @Test
    fun test_times_wrong_size_exception() {

        try {

            Matrix(listOf(doubleArrayOf(1.0, 2.0), doubleArrayOf(3.0, 4.0))) * matrix1

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(WRONG_RATIO_SIZES, e.message)
        }
    }

    @Test
    fun test_timesScalar_correctResult() {

        val matrixAnswer = Matrix(
            listOf(
                doubleArrayOf(5.0, 10.0),
                doubleArrayOf(15.0, 20.0)
            )
        )

        Assertions.assertEquals(matrixAnswer, (matrix1 * 5.0))
    }


    @Test
    fun test_divScalar_correctResult() {

        val matrixAnswer = Matrix(
            listOf(
                doubleArrayOf(0.5, 1.0),
                doubleArrayOf(1.5, 2.0)
            )
        )

        Assertions.assertEquals(matrixAnswer, (matrix1 / 2.0))
    }


    @Test
    fun test_div_scalar_division_by_zero_exception() {

        try {

            matrix1 / 0.0

        } catch (e: ArithmeticException) {

            Assertions.assertEquals(ZERO_DIVISION, e.message)
        }
    }

    @Test
    fun test_get_correctResult() {

        Assertions.assertEquals(3.0, matrix1[1, 0], PRECISION)
    }

    @Test
    fun test_get_exception() {

        try {

            matrix1[100, 0]

        } catch (e: IndexOutOfBoundsException) {

            Assertions.assertEquals(OUT_OF_RANGE, e.message)
        }
    }


    @Test
    fun test_equals_correctResult() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(0.5, 1.0),
                doubleArrayOf(1.5, 2.0)
            )
        )

        val secondMatrix = Matrix(
            listOf(
                doubleArrayOf(0.5, 1.0),
                doubleArrayOf(1.5, 2.0)
            )
        )

        Assertions.assertTrue(firstMatrix == secondMatrix)
    }


    @Test
    fun test_unaryPlus_correctResult() {

        val matrixAnswer = Matrix(
            listOf(
                doubleArrayOf(1.0, 2.0),
                doubleArrayOf(3.0, 4.0)
            )
        )

        Assertions.assertEquals(matrixAnswer, +matrix1)
    }


    @Test
    fun test_unaryMinus_correctResult() {

        val matrixAnswer = Matrix(
            listOf(
                doubleArrayOf(-1.0, -2.0),
                doubleArrayOf(-3.0, -4.0)
            )
        )

        Assertions.assertEquals(matrixAnswer, -matrix1)
    }


    @Test
    fun test_toString_correctResult() {

        Assertions.assertEquals(
            "1.0 \t2.0 \t\n" +
                    "3.0 \t4.0 \t\n", matrix1.toString()
        )
    }

    @Test
    fun test_plusAssign_correctResult() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(0.0, 0.0),
                doubleArrayOf(0.0, 0.0)
            )
        )

        val secondMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0, 10.0),
                doubleArrayOf(10.0, 10.0)
            )
        )

        val answerMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0, 10.0),
                doubleArrayOf(10.0, 10.0)
            )
        )

        firstMatrix += secondMatrix

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_plusAssignDifferentSize_exception() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(0.0, 0.0),
                doubleArrayOf(0.0, 0.0)
            )
        )

        val secondMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0)
            )
        )

        try {

            firstMatrix += secondMatrix

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }

    @Test
    fun test_minus_assign() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(0.0, 0.0),
                doubleArrayOf(0.0, 0.0)
            )
        )

        val secondMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0, 10.0),
                doubleArrayOf(10.0, 10.0)
            )
        )

        val answerMatrix = Matrix(
            listOf(
                doubleArrayOf(-10.0, -10.0),
                doubleArrayOf(-10.0, -10.0)
            )
        )

        firstMatrix -= secondMatrix

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_minusAssignDifferentSize_exception() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(0.0, 0.0),
                doubleArrayOf(0.0, 0.0)
            )
        )

        val secondMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0)
            )
        )

        try {

            firstMatrix -= secondMatrix

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }

    @Test
    fun test_timesAssign_correctResult() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(5.0, 10.0),
                doubleArrayOf(15.0, 20.0)
            )
        )

        val secondMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0, 10.0),
                doubleArrayOf(10.0, 10.0)
            )
        )

        val answerMatrix = Matrix(
            listOf(
                doubleArrayOf(150.0, 150.0),
                doubleArrayOf(350.0, 350.0)
            )
        )

        firstMatrix *= secondMatrix

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_timesAssignSize_correctResult() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(5.0, 10.0),
                doubleArrayOf(15.0, 20.0)
            )
        )

        val secondMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0, 10.0),
                doubleArrayOf(10.0, 10.0)
            )
        )

        firstMatrix *= secondMatrix

        Assertions.assertEquals(Pair(2, 2), firstMatrix.size)
    }

    @Test
    fun test_timesAssignDifferentSize_exception() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(5.0, 10.0),
                doubleArrayOf(15.0, 20.0)
            )
        )

        val secondMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0)
            )
        )

        try {

            firstMatrix *= secondMatrix

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(WRONG_RATIO_SIZES, e.message)
        }
    }

    @Test
    fun test_timesAssignScalar_correctResult() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(5.0, 10.0),
                doubleArrayOf(15.0, 20.0)
            )
        )

        firstMatrix *= 2.0

        val answerMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0, 20.0),
                doubleArrayOf(30.0, 40.0)
            )
        )

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_divAssignScalar_correctResult() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0, 10.0),
                doubleArrayOf(20.0, 20.0)
            )
        )

        firstMatrix /= 2.0

        val answerMatrix = Matrix(
            listOf(
                doubleArrayOf(5.0, 5.0),
                doubleArrayOf(10.0, 10.0)
            )
        )

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_set_correctResult() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0, 10.0),
                doubleArrayOf(20.0, 20.0)
            )
        )
        firstMatrix[0, 0] = 50.0

        Assertions.assertEquals(50.0, firstMatrix[0, 0], PRECISION)
    }

    @Test
    fun test_set_exception() {

        val firstMatrix = Matrix(
            listOf(
                doubleArrayOf(10.0, 10.0),
                doubleArrayOf(20.0, 20.0)
            )
        )

        try {

            firstMatrix[50, 50] = 50.0

        } catch (e: IndexOutOfBoundsException) {

            Assertions.assertEquals(OUT_OF_RANGE, e.message)
        }
    }
}