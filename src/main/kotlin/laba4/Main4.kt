package laba4

fun main() {


    val matrix1 = Matrix(
        listOf(
            doubleArrayOf(5.0, 5.0, 20.0),
            doubleArrayOf(-1.0, 10.0, 15.0)
        )
    )
    val matrix2 = Matrix(
        listOf(
            doubleArrayOf(10.0, 10.0, 5.0),
            doubleArrayOf(-5.0, -20.0, 0.0)
        )
    )
    val matrix3 = Matrix(
        listOf(
            doubleArrayOf(10.0, -10.0),
            doubleArrayOf(40.0, -20.0),
            doubleArrayOf(-40.0, -80.0)
        )
    )

    val matrix4 = Matrix(rows = 2, columns = 2)

    matrix4[0, 0] = 1.0
    matrix4[0, 1] = 2.0
    matrix4[1, 0] = 3.0
    matrix4[1, 1] = 4.0

    val matrix5 = Matrix(rows = 2, columns = 2)

    matrix5[0, 0] = 1.0
    matrix5[0, 1] = 5.0
    matrix5[1, 0] = 1.0
    matrix5[1, 1] = 5.0

    // show input

    println("matrix1: \n$matrix1")
    println("matrix2: \n$matrix2")
    println("matrix3: \n$matrix3")
    println("matrix4: \n$matrix4")
    println("matrix5: \n$matrix5")

    // show answers

    println(matrix4.size)

    println("matrix1 + matrix2: \n${matrix1 + matrix2}")
    println("matrix2 - matrix1:\n${matrix2 - matrix1}")
    println("matrix1 * matrix3:\n${matrix1 * matrix3}")

    println("matrix1 * 4:\n${matrix1 * 4.0}")
    println("matrix1 / 2:\n${matrix1 / 2.0}")

    println("-matrix1:\n${-matrix1}")
    println("matrix1[0, 1]:\n${matrix1[0, 1]}")
    println("matrix1 == matrix2: \n${matrix1 == matrix2}")

    matrix1 += matrix2
    matrix2 -= matrix1
    matrix3 *= matrix4
    matrix4 *= 4.0
    matrix5 /= 2.0

    println("matrix1 += matrix2: \n${matrix1}")
    println("matrix2 -= matrix1:\n${matrix2}")
    println("matrix1 *= matrix3:\n${matrix3}")
    println("matrix1 *= 4:\n${matrix4}")
    println("matrix1 /= 2:\n${matrix5}")

}