package laba3

import kotlin.math.pow
import kotlinx.serialization.Serializable


@Serializable
class Square(private val side: Double) : Shape {

    init {

        if (side <= 0) throw IllegalArgumentException(NEGATIVE_SIZE_ERROR_MESSAGE)

    }

    override fun calcArea(): Double {

        return side.pow(2)
    }

    override fun calcPerimeter(): Double {

        return 4 * side
    }

}