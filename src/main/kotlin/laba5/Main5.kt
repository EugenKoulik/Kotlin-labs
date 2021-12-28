package laba5

import java.time.Year

fun main() {

    try {

        val library = Library()

        val user1 = User("Kulik", "Evgenii", "Andreevich")
        val user2 = User("Iron", "Man")
        val user3 = User("Carlson")

        val book1 = Book("Anna Karenina", Year.parse("1877"), listOf(Author("Tolstoy", "Lev")), Genre.NOVEL)
        val book2 = Book("The Great Gatsby", Year.parse("1925"), listOf(Author("Fitzgerald", "Scott")), Genre.NOVEL)
        val book3 = Book("Hamlet", Year.parse("1601"), listOf(Author("Shakespeare", "William")), Genre.TRAGEDY)

        library.registerUser(user1)
        library.registerUser(user2)
        library.registerUser(user3)

        println(library.getAllBooks())

        library.addBook(book1)
        library.addBook(book2)
        library.addBook(book3)

        println(library.getAllAvailableBooks())

        library.takeBook(user1, library.findBooks("Anna Karenina")[0])
        library.takeBook(user2, library.findBooks("The Great Gatsby")[0])

        println(library.getBookStatus(book1))
        println(library.getBookStatus(book2))
        println(library.getBookStatus(book3))


    } catch (e: Exception) {

        println(e.message)
    }

}