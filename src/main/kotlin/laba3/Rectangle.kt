package laba3

import kotlinx.serialization.Serializable


@Serializable
class Rectangle(private val length: Double = 1.0, private val width: Double = 1.0) : Shape {

    init {

        if (length <= 0) throw IllegalArgumentException(NEGATIVE_SIZE_ERROR_MESSAGE)

        if (width <= 0) throw IllegalArgumentException(NEGATIVE_SIZE_ERROR_MESSAGE)

    }

    override fun calcArea(): Double {

        return length * width
    }

    override fun calcPerimeter(): Double {

        return 2 * (length + width)
    }

}