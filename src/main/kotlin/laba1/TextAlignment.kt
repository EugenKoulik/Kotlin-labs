package laba1

enum class Alignment {
    LEFT,
    RIGHT,
    CENTER,
    JUSTIFY
}

fun alignText(
    text: String,
    lineWidth: Int = 10,
    alignment: Alignment = Alignment.LEFT
): String {

    // checking entered values
    when {
        (text.isEmpty()) -> throw IllegalArgumentException("Empty line entered")
        (lineWidth <= 0) -> throw IllegalArgumentException("Line width less than or equal to zero")
    }

    // transform text

    return when (alignment) {

        Alignment.LEFT -> alignLeft(splitLines(text, lineWidth))
        Alignment.CENTER -> alignCenter(splitLines(text, lineWidth), lineWidth)
        Alignment.RIGHT -> alignRight(splitLines(text, lineWidth), lineWidth)
        Alignment.JUSTIFY -> alignJustify(splitLines(text, lineWidth), lineWidth)
    }

}

// split lines based on specified length

private fun splitLines(text: String, lineWidth: Int): MutableList<String> {

    val mutableText: MutableList<String> = mutableListOf() // line-by-line representation of edited text
    var currentWord = ""
    var currentString = ""

    for (currentSymbol in text) {

        currentWord += currentSymbol

        // interpretation of the next character

        when (currentSymbol) {

            ' ' -> {

                if (currentWord != " ") currentString += currentWord
                currentWord = ""
            }
            '\n' -> {

                if (currentWord != "\n") {
                    currentString += currentWord
                    mutableText.add(currentString.trim())
                }
                currentString = ""
                currentWord = ""
            }
        }

        // if it doesn't fit

        if (currentString.length + currentWord.length == lineWidth) {

            // if the word does not fit

            if (currentString.isEmpty()) {
                mutableText.add(currentWord.trim())
                currentWord = ""
            }

            // if the string does not fit

            else {
                currentString += currentWord
                mutableText.add(currentString.trim())
                currentWord = ""
                currentString = ""
            }
        }
    }

    // writing the last characters

    currentString += currentWord
    mutableText.add(currentString.trim())

    return mutableText
}

private fun alignLeft(text: MutableList<String>): String {

    return text.joinToString(System.lineSeparator())
}

private fun alignCenter(text: MutableList<String>, lineWidth: Int): String {

    for (i in 0 until text.size) {

        val stringLen = text[i].length

        val indent = stringLen + (lineWidth - stringLen) / 2 // left margin

        text[i] = text[i].padStart(indent)
    }
    return text.joinToString(System.lineSeparator())
}

private fun alignRight(text: MutableList<String>, lineWidth: Int): String {

    val iterate = text.listIterator()

    while (iterate.hasNext()) {

        val oldValue = iterate.next()
        iterate.set(oldValue.padStart(lineWidth)) // adding spaces to the left
    }

    return text.joinToString(System.lineSeparator())
}

private fun alignJustify(text: MutableList<String>, lineWidth: Int): String {

    for (i in 0 until text.size) {

        text[i] = text[i].trim()

        val wordCount = text[i].count { it == ' ' } + 1 // number of words per line
        val noSpaceStringLen = text[i].count { it != ' ' } // length of the current line without spaces

        if (wordCount != 1) {

            val spaceSize = (lineWidth - noSpaceStringLen) / (wordCount - 1)
            text[i] = text[i].replace(" ", " ".repeat(spaceSize))
        }
    }
    return text.joinToString(System.lineSeparator())
}