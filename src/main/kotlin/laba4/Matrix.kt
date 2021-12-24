package laba4

import java.lang.ArithmeticException

class Matrix(matrixValues: List<DoubleArray> = emptyList(), rows: Int = 0, columns: Int = 0) {

    private var matrix: List<DoubleArray>

    val size: Pair<Int, Int>
        get() {

            return Pair(matrix.size, matrix[0].size)
        }

    init {

        // if values and size were not specified in the constructor

        if (matrixValues.isEmpty() && (rows == 0 || columns == 0)) {

            throw IllegalArgumentException(EMPTY_MATRIX)
        }

        // if only dimensions were specified - create a zero matrix

        if (matrixValues.isEmpty() && (rows > 0 && columns > 0)) {

            matrix = List(columns) { DoubleArray(rows) { 0.0 } }
        }

        // write the values to the array list

        else {

            val firstRowSize = matrixValues[0].size

            matrixValues.forEach { row ->

                if (row.size != firstRowSize)
                    throw IllegalArgumentException(DIFFERENT_SIZE)
            }

            matrix = matrixValues.toList()
        }
    }


    operator fun plus(other: Matrix): Matrix {

        if (!sizeEqual(other.size)) throw IllegalArgumentException(DIFFERENT_SIZE)

        // fill the answer matrix with zeros

        val matrixAnswer = List(size.first) {

            DoubleArray(size.second) { 0.0 }
        }

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrixAnswer[i][j] = matrix[i][j] + other[i, j]
            }
        }

        return Matrix(matrixAnswer)
    }


    operator fun minus(other: Matrix): Matrix {

        if (!sizeEqual(other.size)) throw IllegalArgumentException(DIFFERENT_SIZE)

        val matrixAnswer = List(size.first) {

            DoubleArray(size.second) { 0.0 }

        }

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrixAnswer[i][j] = matrix[i][j] - other[i, j]
            }
        }

        return Matrix(matrixAnswer)
    }

    operator fun times(other: Matrix): Matrix {

        if (size.second != other.size.first) throw IllegalArgumentException(WRONG_RATIO_SIZES)

        val matrixAnswer = List(size.first) {

            DoubleArray(other.size.second) { 0.0 }

        }

        for (i in 0 until size.first) {

            for (j in 0 until other.size.second) {

                for (k in 0 until size.second) {

                    matrixAnswer[i][j] += matrix[i][k] * other[k, j]
                }
            }
        }
        return Matrix(matrixAnswer)
    }

    operator fun times(scalar: Double): Matrix {

        val matrixAnswer = List(size.first) {

            DoubleArray(size.second) { 0.0 }

        }

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrixAnswer[i][j] = matrix[i][j] * scalar
            }
        }

        return Matrix(matrixAnswer)
    }

    operator fun div(scalar: Double): Matrix {

        if (scalar == 0.0) throw ArithmeticException(ZERO_DIVISION)

        val matrixAnswer = List(size.first) {

            DoubleArray(size.second) { 0.0 }

        }

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrixAnswer[i][j] = matrix[i][j] / scalar
            }
        }

        return Matrix(matrixAnswer)
    }

    operator fun get(i: Int, j: Int): Double {

        if ((i >= size.first) || (j >= size.second)) throw IndexOutOfBoundsException(OUT_OF_RANGE)

        return matrix[i][j]
    }

    operator fun unaryMinus(): Matrix {

        val matrixAnswer = List(size.first) {

            DoubleArray(size.second) { 0.0 }
        }

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrixAnswer[i][j] = -matrix[i][j]
            }
        }

        return Matrix(matrixAnswer)
    }

    operator fun unaryPlus(): Matrix = this


    operator fun plusAssign(other: Matrix) {

        if (!sizeEqual(other.size)) throw IllegalArgumentException(DIFFERENT_SIZE)

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrix[i][j] += other[i, j]
            }
        }
    }

    operator fun minusAssign(other: Matrix) {

        if (!sizeEqual(other.size)) throw IllegalArgumentException(DIFFERENT_SIZE)

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrix[i][j] -= other[i, j]
            }
        }
    }

    operator fun timesAssign(other: Matrix) {

        if (size.second != other.size.first) throw IllegalArgumentException(WRONG_RATIO_SIZES)

        val newMatrix: List<DoubleArray> = List(size.first) {

            DoubleArray(other.size.second) { 0.0 }
        }

        for (i in 0 until size.first) {

            for (j in 0 until other.size.second) {

                for (k in 0 until size.second) {

                    newMatrix[i][j] += matrix[i][k] * other[k, j]
                }
            }
        }

        matrix = newMatrix

    }

    operator fun timesAssign(scalar: Double) {

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrix[i][j] *= scalar
            }
        }
    }

    operator fun divAssign(scalar: Double) {

        if (scalar == 0.0) throw ArithmeticException(ZERO_DIVISION)

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrix[i][j] /= scalar
            }
        }
    }


    override fun equals(other: Any?): Boolean {

        other as Matrix

        if (size != other.size) return false

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                if (matrix[i][j] != other[i, j]) {

                    return false

                }

            }
        }

        return true
    }

    // the method equals() contains definitions in the Matrix class, so the method hashCode must also be defined!

    override fun hashCode(): Int {

        return matrix.hashCode()
    }

    override fun toString(): String {

        var matrixString = ""

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrixString += matrix[i][j].toString() + " \t"
            }

            matrixString += "\n"
        }

        return matrixString
    }


    private fun sizeEqual(s: Pair<Int, Int>): Boolean {

        return size == s
    }

    operator fun set(i1: Int, i2: Int, value: Double) {

        if ((i1 >= size.first) || (i2 >= size.second)) throw IndexOutOfBoundsException(OUT_OF_RANGE)

        matrix[i1][i2] = value

    }

}




