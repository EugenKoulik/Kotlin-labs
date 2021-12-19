package laba3

class Rectangle(val length: Double = 1.0, val width: Double = 1.0) : Shape {

    override var shapeType = Shapes.RECTANGLE

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