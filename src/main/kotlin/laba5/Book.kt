package laba5

import java.time.Year


data class Book(val title: String, val year: Year, val authors: List<Author>, val genre: Genre) {


    init {

        if (year.isAfter(Year.now())) throw IllegalArgumentException(WRONG_YEAR)

    }

    override fun toString(): String {

        var authorsList = ""

        for (currentAuthor in authors) {

            authorsList += currentAuthor
            authorsList += " "

        }

        authorsList.trim()

        return "$title $year $authorsList $genre"

    }

}