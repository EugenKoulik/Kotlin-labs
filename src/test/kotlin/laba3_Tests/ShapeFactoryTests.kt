package laba3_Tests

import laba3.*
import org.junit.jupiter.api.Assertions
import kotlin.test.Test

private const val PRECISION = 0.00001

class CircleTests {


    @Test
    fun test_circleArea_correctResult() {

        val circle = Circle(5.0)

        Assertions.assertEquals(Math.PI * 5.0 * 5.0, circle.calcArea(), PRECISION)
    }

    @Test
    fun test_circlePerimeter_correctResult() {

        val circle = Circle(5.0)

        Assertions.assertEquals(2 * Math.PI * 5.0, circle.calcPerimeter(), PRECISION)
    }

    @Test
    fun test_circleMinusRadius_exception() {

        try {

            Circle(-1.0)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(NEGATIVE_SIZE_ERROR_MESSAGE, e.message)
        }
    }

}


class RectangleTests {


    @Test
    fun test_rectangleArea_correctResult() {

        val rectangle = Rectangle(5.0, 10.0)

        Assertions.assertEquals(50.0, rectangle.calcArea(), PRECISION)
    }

    @Test
    fun test_rectanglePerimeter_correctResult() {

        val rectangle = Rectangle(5.0, 10.0)

        Assertions.assertEquals(30.0, rectangle.calcPerimeter(), PRECISION)
    }

    @Test
    fun test_rectangleMinusLength_exception() {

        try {

            Rectangle(-5.0, 10.0)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(NEGATIVE_SIZE_ERROR_MESSAGE, e.message)
        }
    }

    @Test
    fun test_rectangleMinusWidth_exception() {

        try {

            Rectangle(-5.0, 10.0)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(NEGATIVE_SIZE_ERROR_MESSAGE, e.message)
        }
    }

}


class SquareTests {


    @Test
    fun test_squareArea_correctResult() {

        val square = Square(5.0)

        Assertions.assertEquals(25.0, square.calcArea(), PRECISION)
    }

    @Test
    fun test_squarePerimeter_correctResult() {

        val square = Square(5.0)

        Assertions.assertEquals(20.0, square.calcPerimeter(), PRECISION)
    }

    @Test
    fun test_squareMinusSide_exception() {

        try {

            Square(-5.0)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(NEGATIVE_SIZE_ERROR_MESSAGE, e.message)
        }
    }

}



class TriangleTests {


    @Test
    fun test_triangleArea_correctResult() {

        val rectangle = Triangle(3.0, 4.0, 5.0)

        Assertions.assertEquals(6.0,  rectangle.calcArea(), PRECISION)
    }

    @Test
    fun test_trianglePerimeter_correctResult() {

        val triangle = Triangle(3.0, 4.0, 5.0)

        Assertions.assertEquals(12.0, triangle.calcPerimeter(), PRECISION)
    }

    @Test
    fun test_triangleMinusSide_exception() {

        try {

            Triangle(-3.0, 4.0, 5.0)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(NEGATIVE_SIZE_ERROR_MESSAGE, e.message)
        }
    }

    @Test
    fun test_triangleZeroSide_exception() {

        try {

            Triangle(0.0, 4.0, 5.0)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(NEGATIVE_SIZE_ERROR_MESSAGE, e.message)
        }
    }

    @Test
    fun test_triangleZeroSides_exception() {

        try {

            Triangle(0.0, 0.0, 0.0)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(NEGATIVE_SIZE_ERROR_MESSAGE, e.message)
        }
    }

    @Test
    fun test_triangleCannotExist_exception() {

        try {

            Triangle(1.0, 2.0, 10.0)

        } catch (e: IllegalArgumentException) {

            Assertions.assertEquals(TRIANGLE_EXISTENCE_ERROR_MESSAGE, e.message)
        }
    }

}