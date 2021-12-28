package laba5

import java.time.Year

class Library : LibraryServiceInterface {

    private val users = mutableListOf<User>()
    private val books: MutableSet<Book> = mutableSetOf()
    private val bookStatuses = mutableMapOf<Book, Status>()


    override fun findBooks(substring: String): List<Book> {

        return bookStatuses.keys.filter { book -> book.title.contains(substring) }
    }

    override fun findBooks(author: Author): List<Book> {

        return bookStatuses.keys.filter { book -> book.authors.contains(author) }
    }

    override fun findBooks(year: Year): List<Book> {

        return bookStatuses.keys.filter { book -> book.year == year }
    }

    override fun findBooks(genre: Genre): List<Book> {

        return bookStatuses.keys.filter { book -> book.genre == genre }
    }


    override fun getAllBooks(): List<Book> {

        return bookStatuses.keys.toList()
    }

    override fun getAllAvailableBooks(): List<Book> {

        return bookStatuses.filter { it.value == Status.Available }.keys.toList()
    }


    override fun getBookStatus(book: Book): Status {

        if (!bookStatuses.contains(book)) throw Exception(BOOK_WITHOUT_STATUS)

        return bookStatuses[book]!!
    }

    override fun getAllBookStatuses(): Map<Book, Status> {

        return bookStatuses.toMap()
    }

    override fun setBookStatus(book: Book, status: Status) {

        if (!bookStatuses.contains(book)) throw IllegalStateException(BOOK_NOT_FOUND)

        bookStatuses.replace(book, status)
    }

    override fun addBook(book: Book, status: Status) {

        if (bookStatuses.keys.contains(book)) throw IllegalStateException(BOOK_ALREADY_EXIST)

        bookStatuses[book] = status

        books.add(book)

    }

    override fun registerUser(user: User) {

        if (users.contains(user)) throw IllegalStateException(USER_ALREADY_EXIST)

        users.add(user)
    }

    override fun unregisterUser(user: User) {

        if (!users.contains(user)) throw IllegalStateException(USER_NOT_FOUND)

        users.remove(user)
    }

    override fun takeBook(user: User, book: Book) {

        if (!users.contains(user)) throw IllegalStateException(USER_NOT_FOUND)

        if (!bookStatuses.contains(book) || bookStatuses[book] !is Status.Available) throw IllegalStateException(
            IMPOSSIBLE_GIVE_BOOK
        )

        bookStatuses.replace(book, Status.UsedBy(user))
    }

    override fun returnBook(book: Book) {

        if (!bookStatuses.contains(book)) throw IllegalStateException(BOOK_NOT_FOUND)

        if (bookStatuses[book] !is Status.UsedBy) throw IllegalStateException(USER_NOT_FOUND)

        bookStatuses.replace(book, Status.Available)
    }
}