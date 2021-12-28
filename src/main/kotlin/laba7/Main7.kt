package laba7

import laba3.*


fun main() {


    val pathWrite = "C:\\Users\\Evgeniy\\IdeaProjects\\Kotlin-labs\\src\\main\\kotlin\\laba7\\NewFile.json"

    val serialize = SerializersModule
    val shapeFactory = ShapeFactoryImpl()

    val shapeList = (
            listOf(
                shapeFactory.createRandomShape(),
                shapeFactory.createRandomShape(),
                shapeFactory.createRandomShape()
            )
            )

    FileUtils.write(pathWrite, serialize.encode(shapeList))

    val newShapeList = serialize.decode(FileUtils.read(pathWrite)).toMutableList()

    println("Первая фигура до сериализации - ${shapeList[0].calcArea()}, ${shapeList[0].javaClass.name}")
    println("Первая фигура после сериализации - ${newShapeList[0].calcArea()}, ${newShapeList[0].javaClass.name}\n")

    println("Вторая фигура до сериализации - ${shapeList[1].calcArea()}, ${shapeList[1].javaClass.name}")
    println("Вторая фигура после сериализации - ${newShapeList[1].calcArea()}, ${newShapeList[1].javaClass.name}\n")

    println("Третья фигура до сериализации - ${shapeList[2].calcArea()}, ${shapeList[2].javaClass.name}")
    println("Третья фигура после сериализации - ${newShapeList[2].calcArea()}, ${newShapeList[2].javaClass.name}\n")

}