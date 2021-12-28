package laba4_Tests

import laba4.*
import org.junit.jupiter.api.Assertions
import kotlin.test.Test

private const val PRECISION = 0.00001

class MatrixTests {

    private val matrix1 = Matrix(columns = 2, rows = 2)

    private val matrix2 = Matrix(columns = 2, rows = 2)

    init {

        matrix1[0, 0] = 1.0
        matrix1[0, 1] = 2.0
        matrix1[1, 0] = 3.0
        matrix1[1, 1] = 4.0

        matrix2[0, 0] = 1.0
        matrix2[0, 1] = 0.0
        matrix2[1, 0] = 0.0
        matrix2[1, 1] = 1.0

    }

    @Test
    fun test_initByArray_correctResult() {

        val matrixArr = Array(2) { Array(3) { 0.0 } }
        matrixArr[0] = arrayOf(1.0, 2.0)
        matrixArr[1] = arrayOf(3.0, 4.0)
        val matrix4 = Matrix(matrixArr)

        Assertions.assertEquals(Pair(2, 2), Pair(matrix4.rowsCount, matrix4.columnsCount))
        Assertions.assertEquals(1.0, matrix4[0, 0])
        Assertions.assertEquals(2.0, matrix4[0, 1])
        Assertions.assertEquals(3.0, matrix4[1, 0])
        Assertions.assertEquals(4.0, matrix4[1, 1])
    }

    @Test
    fun test_initBySize_correctResult() {

        val matrix4 = Matrix(columns = 2, rows = 2)

        matrix4[0, 0] = 1.0
        matrix4[0, 1] = 2.0
        matrix4[1, 0] = 3.0
        matrix4[1, 1] = 4.0

        Assertions.assertEquals(Pair(2, 2), Pair(matrix4.rowsCount, matrix4.columnsCount))
        Assertions.assertEquals(1.0, matrix4[0, 0])
        Assertions.assertEquals(2.0, matrix4[0, 1])
        Assertions.assertEquals(3.0, matrix4[1, 0])
        Assertions.assertEquals(4.0, matrix4[1, 1])
    }

    @Test
    fun test_emptyMatrix_exception() {

        try {

            val matrixArr = Array(2) { Array(3) { 0.0 } }

            Matrix(matrixArr)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(EMPTY_MATRIX, e.message)
        }
    }

    @Test
    fun test_differentRows_exception() {

        try {

            val matrixArr = Array(2) { Array(3) { 0.0 } }
            matrixArr[0] = arrayOf(1.0, 2.0, 10.0)
            matrixArr[1] = arrayOf(3.0, 4.0)

            Matrix(matrixArr)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }

    @Test
    fun test_plus_correctResult() {

        val matrixArr = Array(2) { Array(2) { 0.0 } }
        matrixArr[0] = arrayOf(2.0, 2.0)
        matrixArr[1] = arrayOf(3.0, 5.0)
        val matrixAnswer = Matrix(matrixArr)

        Assertions.assertEquals(matrixAnswer, (matrix1 + matrix2))
    }


    @Test
    fun test_plusDifferentSize_exception() {

        try {

            val matrixArr = Array(2) { Array(3) { 0.0 } }
            matrixArr[0] = arrayOf(2.0, 2.0, 3.0)
            matrixArr[1] = arrayOf(3.0, 5.0, 8.0)
            val matrixAnswer = Matrix(matrixArr)

            matrixAnswer + matrix1

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }


    @Test
    fun test_minus_correctResult() {

        val matrixArr = Array(2) { Array(2) { 0.0 } }
        matrixArr[0] = arrayOf(0.0, 2.0)
        matrixArr[1] = arrayOf(3.0, 3.0)
        val matrixAnswer = Matrix(matrixArr)

        Assertions.assertEquals(matrixAnswer, (matrix1 - matrix2))
    }

    @Test
    fun test_minusDifferentSize_exception() {

        try {

            val matrixArr = Array(2) { Array(3) { 0.0 } }
            matrixArr[0] = arrayOf(2.0, 2.0, 3.0)
            matrixArr[1] = arrayOf(3.0, 5.0, 8.0)
            val matrixAnswer = Matrix(matrixArr)

            matrixAnswer - matrix1

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }

    @Test
    fun test_times_correctResult() {

        val matrixArr = Array(2) { Array(2) { 0.0 } }
        matrixArr[0] = arrayOf(1.0, 2.0)
        matrixArr[1] = arrayOf(3.0, 4.0)
        val matrixAnswer = Matrix(matrixArr)

        Assertions.assertEquals(matrixAnswer, (matrix1 * matrix2))
    }


    @Test
    fun test_times_wrong_size_exception() {

        try {

            val matrixArr = Array(2) { Array(2) { 0.0 } }
            matrixArr[0] = arrayOf(2.0, 2.0)
            matrixArr[1] = arrayOf(3.0, 5.0)
            val matrixAnswer = Matrix(matrixArr)

            matrixAnswer * matrix1

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(WRONG_RATIO_SIZES, e.message)
        }
    }

    @Test
    fun test_timesScalar_correctResult() {

        val matrixArr = Array(2) { Array(2) { 0.0 } }
        matrixArr[0] = arrayOf(5.0, 10.0)
        matrixArr[1] = arrayOf(15.0, 20.0)
        val matrixAnswer = Matrix(matrixArr)

        Assertions.assertEquals(matrixAnswer, (matrix1 * 5.0))
    }


    @Test
    fun test_divScalar_correctResult() {

        val matrixArr = Array(2) { Array(2) { 0.0 } }
        matrixArr[0] = arrayOf(0.5, 1.0)
        matrixArr[1] = arrayOf(1.5, 2.0)
        val matrixAnswer = Matrix(matrixArr)

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

        val matrixArr = Array(2) { Array(2) { 0.0 } }
        matrixArr[0] = arrayOf(5.0, 10.0)
        matrixArr[1] = arrayOf(15.0, 20.0)
        val firstMatrix = Matrix(matrixArr)
        val secondMatrix = Matrix(matrixArr)

        Assertions.assertTrue(firstMatrix == secondMatrix)
    }


    @Test
    fun test_unaryPlus_correctResult() {

        val matrixArr = Array(2) { Array(2) { 0.0 } }
        matrixArr[0] = arrayOf(1.0, 2.0)
        matrixArr[1] = arrayOf(3.0, 4.0)
        val matrixAnswer = Matrix(matrixArr)

        Assertions.assertEquals(matrixAnswer, +matrix1)
    }


    @Test
    fun test_unaryMinus_correctResult() {

        val matrixArr = Array(2) { Array(2) { 0.0 } }
        matrixArr[0] = arrayOf(-1.0, -2.0)
        matrixArr[1] = arrayOf(-3.0, -4.0)
        val matrixAnswer = Matrix(matrixArr)

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

        val matrixArr1 = Array(2) { Array(2) { 0.0 } }
        matrixArr1[0] = arrayOf(0.0, 0.0)
        matrixArr1[1] = arrayOf(0.0, 0.0)

        val firstMatrix = Matrix(matrixArr1)

        val matrixArr2 = Array(2) { Array(2) { 0.0 } }
        matrixArr2[0] = arrayOf(10.0, 10.0)
        matrixArr2[1] = arrayOf(10.0, 10.0)

        val secondMatrix = Matrix(matrixArr2)

        val matrixArr3 = Array(2) { Array(2) { 0.0 } }
        matrixArr3[0] = arrayOf(10.0, 10.0)
        matrixArr3[1] = arrayOf(10.0, 10.0)

        val answerMatrix = Matrix(matrixArr3)

        firstMatrix += secondMatrix

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_plusAssignDifferentSize_exception() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(0.0, 0.0)
        matrixArray1[1] = arrayOf(0.0, 0.0)

        val firstMatrix = Matrix(matrixArray1)

        val matrixArray2 = Array(1) { Array(1) { 0.0 } }
        matrixArray2[0] = arrayOf(0.0)

        val secondMatrix = Matrix(matrixArray2)

        try {

            firstMatrix += secondMatrix

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }

    @Test
    fun test_minusAssign_correctResult() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(10.0, 10.0)
        matrixArray1[1] = arrayOf(10.0, 10.0)
        val firstMatrix = Matrix(matrixArray1)

        val matrixArray2 = Array(2) { Array(2) { 0.0 } }
        matrixArray2[0] = arrayOf(5.0, 5.0)
        matrixArray2[1] = arrayOf(5.0, 5.0)
        val secondMatrix = Matrix(matrixArray2)


        val matrixArray3 = Array(2) { Array(2) { 0.0 } }
        matrixArray3[0] = arrayOf(5.0, 5.0)
        matrixArray3[1] = arrayOf(5.0, 5.0)
        val answerMatrix = Matrix(matrixArray3)


        firstMatrix -= secondMatrix

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_minusAssignDifferentSize_exception() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(10.0, 10.0)
        matrixArray1[1] = arrayOf(10.0, 10.0)
        val firstMatrix = Matrix(matrixArray1)

        val matrixArray2 = Array(1) { Array(1) { 0.0 } }
        matrixArray2[0] = arrayOf(5.0)
        val secondMatrix = Matrix(matrixArray2)

        try {

            firstMatrix -= secondMatrix

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(DIFFERENT_SIZE, e.message)
        }
    }

    @Test
    fun test_timesAssign_correctResult() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(5.0, 10.0)
        matrixArray1[1] = arrayOf(15.0, 20.0)
        val firstMatrix = Matrix(matrixArray1)

        val matrixArray2 = Array(2) { Array(2) { 0.0 } }
        matrixArray2[0] = arrayOf(10.0, 10.0)
        matrixArray2[1] = arrayOf(10.0, 10.0)
        val secondMatrix = Matrix(matrixArray2)

        val matrixArray3 = Array(2) { Array(2) { 0.0 } }
        matrixArray3[0] = arrayOf(150.0, 150.0)
        matrixArray3[1] = arrayOf(350.0, 350.0)
        val answerMatrix = Matrix(matrixArray3)

        firstMatrix *= secondMatrix

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_timesAssignSize_correctResult() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(5.0, 10.0)
        matrixArray1[1] = arrayOf(15.0, 20.0)
        val firstMatrix = Matrix(matrixArray1)

        val matrixArray2 = Array(2) { Array(2) { 0.0 } }
        matrixArray2[0] = arrayOf(10.0, 10.0)
        matrixArray2[1] = arrayOf(10.0, 10.0)
        val secondMatrix = Matrix(matrixArray2)

        firstMatrix *= secondMatrix

        Assertions.assertEquals(Pair(2, 2), Pair(firstMatrix.rowsCount, firstMatrix.columnsCount))
    }

    @Test
    fun test_timesAssignDifferentSize_exception() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(10.0, 10.0)
        matrixArray1[1] = arrayOf(10.0, 10.0)
        val firstMatrix = Matrix(matrixArray1)

        val matrixArray2 = Array(1) { Array(1) { 0.0 } }
        matrixArray2[0] = arrayOf(5.0)
        val secondMatrix = Matrix(matrixArray2)

        try {

            firstMatrix *= secondMatrix

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(WRONG_RATIO_SIZES, e.message)
        }
    }

    @Test
    fun test_timesAssignScalar_correctResult() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(10.0, 10.0)
        matrixArray1[1] = arrayOf(10.0, 10.0)
        val firstMatrix = Matrix(matrixArray1)

        firstMatrix *= 2.0

        val matrixArray3 = Array(2) { Array(2) { 0.0 } }
        matrixArray3[0] = arrayOf(20.0, 20.0)
        matrixArray3[1] = arrayOf(20.0, 20.0)
        val answerMatrix = Matrix(matrixArray3)

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_divAssignScalar_correctResult() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(10.0, 10.0)
        matrixArray1[1] = arrayOf(10.0, 10.0)
        val firstMatrix = Matrix(matrixArray1)

        firstMatrix /= 2.0

        val matrixArray3 = Array(2) { Array(2) { 0.0 } }
        matrixArray3[0] = arrayOf(5.0, 5.0)
        matrixArray3[1] = arrayOf(5.0, 5.0)
        val answerMatrix = Matrix(matrixArray3)

        Assertions.assertEquals(answerMatrix, firstMatrix)
    }

    @Test
    fun test_set_correctResult() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(10.0, 10.0)
        matrixArray1[1] = arrayOf(10.0, 10.0)
        val firstMatrix = Matrix(matrixArray1)

        firstMatrix[0, 0] = 50.0

        Assertions.assertEquals(50.0, firstMatrix[0, 0], PRECISION)
    }

    @Test
    fun test_set_exception() {

        val matrixArray1 = Array(2) { Array(2) { 0.0 } }
        matrixArray1[0] = arrayOf(10.0, 10.0)
        matrixArray1[1] = arrayOf(10.0, 10.0)
        val firstMatrix = Matrix(matrixArray1)

        try {

            firstMatrix[50, 50] = 50.0

        } catch (e: IndexOutOfBoundsException) {

            Assertions.assertEquals(OUT_OF_RANGE, e.message)
        }
    }
}