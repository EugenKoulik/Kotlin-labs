package laba2

// array traversal information

class LexemeBuffer(private var lexemes: List<Lexeme>) {

    private var pos = 0

    operator fun next(): Lexeme {
        return lexemes[pos++]
    }

    fun back() {
        pos--
    }
}