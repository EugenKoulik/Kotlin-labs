package laba5

data class User(val surname: String = "", val name: String = "", val patronymic: String = "") {

    override fun toString(): String {

        return "$surname $name $patronymic"
    }
}