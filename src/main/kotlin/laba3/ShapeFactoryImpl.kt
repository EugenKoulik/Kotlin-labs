package laba3

import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt


class ShapeFactoryImpl : ShapeFactory {

    // creating a shape with the specified parameters

    override fun createCircle(radius: Double): Circle = Circle(radius)
    override fun createRectangle(length: Double, width: Double): Rectangle = Rectangle(length, width)
    override fun createSquare(side: Double): Square = Square(side)
    override fun createTriangle(a: Double, b: Double, c: Double): Triangle = Triangle(a, b, c)

    // creating a shape with random parameters

    override fun createRandomCircle(): Circle = Circle(Random.nextDouble(BOTTOM_BOUND, UPPER_BOUND))
    override fun createRandomSquare(): Square = Square(Random.nextDouble(BOTTOM_BOUND, UPPER_BOUND))
    override fun createRandomRectangle(): Rectangle = Rectangle(
        Random.nextDouble(BOTTOM_BOUND, UPPER_BOUND),
        Random.nextDouble(BOTTOM_BOUND, UPPER_BOUND)
    )

    override fun createRandomTriangle(): Triangle {

        val a = Random.nextDouble(BOTTOM_BOUND, UPPER_BOUND)
        val b = Random.nextDouble(BOTTOM_BOUND, UPPER_BOUND)

        val c = Random.nextDouble(abs(a - b) + 0.0001, a + b - 0.0001)
        return Triangle(a, b, c)
    }

    // random shape generation

    override fun createRandomShape(): Shape {

        return when (Random.nextInt(1..4)) {

            1 -> createRandomCircle()
            2 -> createRandomSquare()
            3 -> createRandomRectangle()
            else -> createRandomTriangle()
        }
    }
}