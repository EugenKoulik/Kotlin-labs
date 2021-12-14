fun main() {

    val testText = listOf<String>("Some, text example",
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
}