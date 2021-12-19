package laba2

fun main() {


    val expression = ArithmeticParser()

    try {

        println(expression.calculateExpressionString(""))

    } catch (e: Exception) {

        println(e.message)
    }

}