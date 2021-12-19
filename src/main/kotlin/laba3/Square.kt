package laba3

import kotlin.math.pow

class Square(val side: Double) : Shape {

    override var shapeType = Shapes.SQUARE

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