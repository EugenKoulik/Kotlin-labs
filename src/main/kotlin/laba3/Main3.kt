package laba3

fun main() {


    val shapeFactory = ShapeFactoryImpl()


    val figures = listOf(
        shapeFactory.createRandomCircle(),
        shapeFactory.createRandomSquare(),
        shapeFactory.createRandomRectangle(),
        shapeFactory.createRandomTriangle(),
        shapeFactory.createCircle(3.0),
        shapeFactory.createSquare(4.0),
        shapeFactory.createRectangle(3.0, 4.0),
        shapeFactory.createTriangle(3.0, 4.0, 5.0)
    )

    var sumArea = 0.0
    var sumPerimeter = 0.0
    var minArea: Shape? = null
    var maxArea: Shape? = null
    var minPerimeter: Shape? = null
    var maxPerimeter: Shape? = null


    for (currentFigure in figures) {

        sumArea += currentFigure.calcArea()
        sumPerimeter += currentFigure.calcPerimeter()

        if (minArea == null || currentFigure.calcArea() < minArea.calcArea())
            minArea = currentFigure

        if (maxArea == null || currentFigure.calcArea() > maxArea.calcArea())
            maxArea = currentFigure

        if (minPerimeter == null || currentFigure.calcPerimeter() < minPerimeter.calcPerimeter())
            minPerimeter = currentFigure

        if (maxPerimeter == null || currentFigure.calcPerimeter() > maxPerimeter.calcPerimeter())
            maxPerimeter = currentFigure
    }


    println("\nTotal area : $sumArea")
    println("\nTotal perimeter : $sumPerimeter")

    println("\nFigure with biggest area: ${maxArea!!.calcArea()} - ${maxArea.javaClass.name}")
    println("\nFigure with smallest area: ${minArea!!.calcArea()} - ${maxArea.javaClass.name}")
    println("\nFigure with biggest perimeter: ${maxPerimeter!!.calcPerimeter()} - ${maxArea.javaClass.name}")
    println("\nFigure with smallest perimeter: ${minPerimeter!!.calcPerimeter()} - ${maxArea.javaClass.name}")

}