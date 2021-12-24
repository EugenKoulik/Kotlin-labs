package laba2

import kotlin.math.pow

// recursive descent method

class ArithmeticParser {

    fun calculateExpressionString(expressionText: String): Double {

        val lexemes = lexAnalyze(expressionText)

        val lexemeBuffer = LexemeBuffer(lexemes)

        return expr(lexemeBuffer)
    }

    // character definition

    private fun lexAnalyze(expText: String): List<Lexeme> {

        if (expText.isEmpty()) {
            throw IllegalArgumentException("Empty string")
        }

        val lexemes = ArrayList<Lexeme>()


        var bracketsBalance = 0
        var position = 0

        while (position < expText.length) {

            var currentSymbol = expText[position]

            when (currentSymbol) {
                '(' -> {
                    lexemes.add(Lexeme(LexemeType.LEFT_BRACKET, currentSymbol))
                    position++
                    bracketsBalance++
                }
                ')' -> {
                    lexemes.add(Lexeme(LexemeType.RIGHT_BRACKET, currentSymbol))
                    position++
                    bracketsBalance--
                }
                '+' -> {
                    lexemes.add(Lexeme(LexemeType.OP_PLUS, currentSymbol))
                    position++
                }
                '-' -> {
                    lexemes.add(Lexeme(LexemeType.OP_MINUS, currentSymbol))
                    position++
                }
                '*' -> {
                    lexemes.add(Lexeme(LexemeType.OP_MUL, currentSymbol))
                    position++
                }
                '/' -> {
                    lexemes.add(Lexeme(LexemeType.OP_DIV, currentSymbol))
                    position++
                }
                '^' -> {
                    lexemes.add(Lexeme(LexemeType.OP_DEG, currentSymbol))
                    position++
                }

                // if the character is a digit

                else -> if (currentSymbol in '0'..'9') {

                    val sb = StringBuilder()

                    // read the number
                    do {
                        sb.append(currentSymbol)
                        position++

                        if (position >= expText.length) {
                            break
                        }
                        currentSymbol = expText[position]

                    } while (currentSymbol in '0'..'9')

                    // add them to the array of tokens

                    lexemes.add(Lexeme(LexemeType.NUMBER, sb.toString()))

                } else {

                    if (currentSymbol != ' ') {
                        throw IllegalArgumentException("Unexpected character: $currentSymbol")
                    }
                    position++
                }
            }
        }

        // checking the balance of brackets

        if (bracketsBalance != 0) throw IllegalArgumentException("Out of balance between brackets!")

        lexemes.add(Lexeme(LexemeType.EOF, ""))
        return lexemes
    }

    // start evaluating an expression

    private fun expr(lexemes: LexemeBuffer): Double {

        val lexeme = lexemes.next()

        return if (lexeme.type == LexemeType.EOF) {
            0.0
        } else {

            lexemes.back()
            plusMinus(lexemes)
        }
    }

    // evaluating a subexpression of addition or subtraction

    private fun plusMinus(lexemes: LexemeBuffer): Double {

        var value = mulDiv(lexemes)

        while (true) {

            val lexeme = lexemes.next()

            when (lexeme.type) {

                LexemeType.OP_PLUS -> value += mulDiv(lexemes)
                LexemeType.OP_MINUS -> value -= mulDiv(lexemes)
                LexemeType.EOF, LexemeType.RIGHT_BRACKET -> {

                    lexemes.back()
                    return value
                }
                else -> throw IllegalArgumentException("Unexpected token")
            }
        }
    }

    // evaluating a multiplication or division subexpression

    private fun mulDiv(lexemes: LexemeBuffer): Double {

        var value = degree(lexemes)

        while (true) {

            val lexeme = lexemes.next()

            when (lexeme.type) {

                LexemeType.OP_MUL -> value *= degree(lexemes)
                LexemeType.OP_DIV -> value /= degree(lexemes)
                LexemeType.EOF, LexemeType.RIGHT_BRACKET, LexemeType.OP_PLUS, LexemeType.OP_MINUS -> {

                    lexemes.back()
                    return value
                }
                else -> throw IllegalArgumentException("Unexpected token")
            }
        }
    }

    // calculating the exponentiation subexpression

    private fun degree(lexemes: LexemeBuffer): Double {

        var value = factor(lexemes)

        while (true) {

            val lexeme = lexemes.next()

            when (lexeme.type) {

                LexemeType.OP_DEG -> value = value.pow(factor(lexemes))
                LexemeType.EOF, LexemeType.RIGHT_BRACKET, LexemeType.OP_PLUS,
                LexemeType.OP_MINUS, LexemeType.OP_MUL, LexemeType.OP_DIV -> {

                    lexemes.back()
                    return value
                }
                else -> throw IllegalArgumentException("Unexpected token")
            }
        }

    }

    // processing a number or expression in parentheses

    private fun factor(lexemes: LexemeBuffer): Double {

        var lexeme = lexemes.next()

        when (lexeme.type) {

            LexemeType.OP_MINUS -> {

                val value = factor(lexemes)
                return -value
            }
            LexemeType.OP_PLUS -> {

                return factor(lexemes)
            }
            LexemeType.NUMBER -> return lexeme.value.toDouble()
            LexemeType.LEFT_BRACKET -> {

                val value = plusMinus(lexemes)
                lexeme = lexemes.next()

                if (lexeme.type != LexemeType.RIGHT_BRACKET) {

                    throw IllegalArgumentException("Out of balance between brackets!")
                }

                return value
            }

            else -> throw IllegalArgumentException("Unexpected token")

        }
    }

}