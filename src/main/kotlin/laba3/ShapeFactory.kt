package laba3

interface ShapeFactory {

    fun createCircle(radius: Double): Circle
    fun createSquare(side: Double): Square
    fun createRectangle(length: Double, width: Double): Rectangle
    fun createTriangle(a: Double, b: Double, c: Double): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}