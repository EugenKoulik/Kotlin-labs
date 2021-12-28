@file:Suppress("UNUSED_EXPRESSION")

package laba4

fun main() {

    val matrix1 = Matrix(columns = 2, rows = 3)

    matrix1[0, 0] = 10.0
    matrix1[0, 1] = 10.0
    matrix1[1, 0] = 20.0
    matrix1[1, 1] = -5.0
    matrix1[2, 0] = 4.0
    matrix1[2, 1] = 88.0

    val matrix2 = Matrix(columns = 2, rows = 3)

    matrix2[0, 0] = 5.0
    matrix2[0, 1] = 5.0
    matrix2[1, 0] = 20.0
    matrix2[1, 1] = 7.0
    matrix2[2, 0] = 4.0
    matrix2[2, 1] = 20.0

    val matrix3 = Matrix(columns = 3, rows = 2)

    matrix3[0, 0] = 10.0
    matrix3[0, 1] = -10.0
    matrix3[0, 2] = 40.0
    matrix3[1, 0] = -20.0
    matrix3[1, 1] = -40.0
    matrix3[1, 2] = -80.0


    val matrix4 = Matrix(columns = 2, rows = 3)

    matrix4[0, 0] = 1.0
    matrix4[0, 1] = 2.0
    matrix4[1, 0] = 3.0
    matrix4[1, 1] = 4.0
    matrix4[2, 0] = 3.0
    matrix4[2, 1] = 4.0

    val matrix5 = Matrix(columns = 2, rows = 2)

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

    println("Matrix4 size: ${matrix4.rowsCount} / ${matrix4.columnsCount}\n")

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