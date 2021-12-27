package laba4

import java.lang.ArithmeticException

class Matrix(rows: Int, columns: Int) {

    private var matrix: Array<Array<Double>>

     val rowsCount: Int
        get() {
            return matrix.size
        }
    

     val columnsCount: Int
        get() {

            return matrix[0].size
        }


    init {

        // if values and size were not specified in the constructor

        if (rows == 0 || columns == 0) {

            throw IllegalArgumentException(EMPTY_MATRIX)
        }

        // if only dimensions were specified - create a zero matrix

            matrix = Array(rows) {Array(columns) { 0.0 }}

    }

    constructor(matrixValues: Array<Array<Double>>) : this(rows = matrixValues.size, columns = matrixValues[0].size)
    {
        val firstRowSize = matrixValues[0].size

        matrixValues.forEach { row ->

            if (row.size != firstRowSize)
                throw IllegalArgumentException(DIFFERENT_SIZE)
        }

        matrix = matrixValues
    }


    operator fun plus(other: Matrix): Matrix {

        sizeEqual(other.rowsCount, other.columnsCount, this.rowsCount, this.columnsCount)

        // fill the answer matrix with zeros

        val matrixAnswer = Array(this.rowsCount) {

            Array(this.columnsCount) { 0.0 }
        }

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrixAnswer[i][j] = matrix[i][j] + other[i, j]
            }
        }

        return Matrix(matrixAnswer)
    }


    operator fun minus(other: Matrix): Matrix {

        sizeEqual(other.rowsCount, other.columnsCount, this.rowsCount, this.columnsCount)

        val matrixAnswer = Array(this.rowsCount) {

            Array(this.columnsCount) { 0.0 }

        }

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrixAnswer[i][j] = matrix[i][j] - other[i, j]
            }
        }

        return Matrix(matrixAnswer)
    }

    operator fun times(other: Matrix): Matrix {

        if (this.columnsCount != other.rowsCount) throw IllegalArgumentException(WRONG_RATIO_SIZES)

        val matrixAnswer = Array(this.rowsCount) {

            Array(other.columnsCount) { 0.0 }

        }

        for (i in 0 until this.rowsCount) {

            for (j in 0 until other.columnsCount) {

                for (k in 0 until this.columnsCount) {

                    matrixAnswer[i][j] += matrix[i][k] * other[k, j]
                }
            }
        }
        return Matrix(matrixAnswer)
    }

    operator fun times(scalar: Double): Matrix {

        val matrixAnswer = Array(this.rowsCount) {

            Array(this.columnsCount) { 0.0 }

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

        val matrixAnswer = Array(this.rowsCount) {

            Array(this.columnsCount) { 0.0 }

        }

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrixAnswer[i][j] = matrix[i][j] / scalar
            }
        }

        return Matrix(matrixAnswer)
    }


    operator fun get(i: Int, j: Int): Double {

        if ((i >= this.rowsCount) || (j >= this.columnsCount)) throw IndexOutOfBoundsException(OUT_OF_RANGE)

        return matrix[i][j]
    }

    operator fun unaryMinus(): Matrix {

        val matrixAnswer = Array(this.rowsCount) {

            Array(this.columnsCount) { 0.0 }
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

        sizeEqual(other.rowsCount, other.columnsCount, this.rowsCount, this.columnsCount)

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrix[i][j] += other[i, j]
            }
        }
    }

    operator fun minusAssign(other: Matrix) {

        sizeEqual(other.rowsCount, other.columnsCount, this.rowsCount, this.columnsCount)

        for (i in matrix.indices) {

            for (j in matrix[0].indices) {

                matrix[i][j] -= other[i, j]
            }
        }
    }

    operator fun timesAssign(other: Matrix) {

        if (this.columnsCount != other.rowsCount) throw IllegalArgumentException(WRONG_RATIO_SIZES)

        val newMatrix = Array(this.rowsCount) {

            Array(other.columnsCount) { 0.0 }
        }

        for (i in 0 until this.rowsCount) {

            for (j in 0 until other.columnsCount) {

                for (k in 0 until this.columnsCount) {

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


        if ((this.rowsCount != other.rowsCount) || (this.columnsCount!= other.columnsCount)) return false

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


    private fun sizeEqual(firstCountRows: Int, firstCountColumns: Int, secondCountRows: Int, secondCountColumns: Int): Boolean {

        if((firstCountRows != secondCountRows) || (firstCountColumns != secondCountColumns)){

            throw IllegalArgumentException(DIFFERENT_SIZE)
        }
        return true
    }

    operator fun set(i1: Int, i2: Int, value: Double) {

        if ((i1 >= this.rowsCount) || (i2 >= this.columnsCount)) throw IndexOutOfBoundsException(OUT_OF_RANGE)

        matrix[i1][i2] = value

    }

}




