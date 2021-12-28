package laba5

data class Author(val surname: String = "", val name: String = "", val patronymic: String = "") {

    init {

        if (surname.isEmpty() && name.isEmpty() && patronymic.isEmpty()) throw IllegalArgumentException(EMPTY_NAME)
    }

    override fun toString(): String = "$surname $name $patronymic"

}