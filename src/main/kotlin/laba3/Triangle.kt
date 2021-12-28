package laba3

import kotlin.math.sqrt
import kotlinx.serialization.Serializable

@Serializable
class Triangle(private val side1: Double = 1.0, private val side2: Double = 1.0, private val side3: Double = 1.0) :
    Shape {

    init {

        if ((side1 <= 0) || (side2 <= 0) || (side3 <= 0)) throw IllegalArgumentException(NEGATIVE_SIZE_ERROR_MESSAGE)

        // triangle existence condition

        if (side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2)

            throw IllegalArgumentException(TRIANGLE_EXISTENCE_ERROR_MESSAGE)
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