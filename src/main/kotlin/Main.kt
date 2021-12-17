import laba1.Alignment
import laba1.alignText

fun main() {


     // lab 1

    val testText = listOf("Some, text example",
        "Sometextexample",
        """Some
        |text
        |example
    """.trimMargin(),
        """Sometextexample
            |sometext
            |exa
            |m
            |p
            |l
        """.trimMargin(),
        "s s s s s s s",
        "And I will strike down upon thee with great vengeance and furious anger")


    try{

        for(currentWord in testText){

            println(alignText(currentWord, 10, Alignment.LEFT) + "\n")
        }
    }
    catch(e: Exception){

        println(e.message)

    }



    // lab 2


    /*val expression = ArithmeticParser()

    try{

        println(expression.calculateExpressionString(""))

    }catch (e: Exception){

        println(e.message)
    }

    */
}