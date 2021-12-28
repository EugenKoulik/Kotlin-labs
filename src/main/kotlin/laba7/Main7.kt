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

    val newShapeList = serialize.decode(FileUtils.read(pathWrite)).toMutableList()


    FileUtils.write(pathWrite, serialize.encode(shapeList + newShapeList))


}