package laba3

import kotlin.math.sqrt

class Triangle(val side1: Double = 1.0, val side2: Double = 1.0, val side3: Double = 1.0) : Shape {

    override var shapeType = Shapes.TRIANGLE

    init {

        if ((side1 <= 0) || (side2 <= 0) || (side3 <= 0)) throw IllegalArgumentException(NEGATIVE_SIZE_ERROR_MESSAGE)

        // triangle existence condition

        if (side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2)

            throw IllegalArgumentException(TRIANGLE_EXISTENCE_ERROR_MESSAGE)

        shapeType = Shapes.TRIANGLE
    }

    // Heron's formula

    override fun calcArea(): Double {

        val halfPerimeter = (side1 + side2 + side3) / 2

        return sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3))
    }

    override fun calcPerimeter(): Double {

        return side1 + side2 + side3
    }

}