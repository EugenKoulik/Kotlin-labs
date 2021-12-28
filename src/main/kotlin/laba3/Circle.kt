package laba3

import kotlin.math.pow
import kotlinx.serialization.Serializable


@Serializable
class Circle(private val radius: Double) : Shape {

    init {

        if (radius <= 0) throw IllegalArgumentException(NEGATIVE_SIZE_ERROR_MESSAGE)

    }

    override fun calcArea(): Double {

        return Math.PI * radius.pow(2)

    }

    override fun calcPerimeter(): Double {

        return 2 * Math.PI * radius
    }

}