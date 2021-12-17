package laba2

class Lexeme {
    var type: LexemeType
    var value: String

    constructor(type: LexemeType, value: String) {
        this.type = type
        this.value = value
    }

    constructor(type: LexemeType, value: Char) {
        this.type = type
        this.value = value.toString()
    }
}