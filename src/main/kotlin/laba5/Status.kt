package laba5

sealed class Status {

    object Available : Status() {
        override fun toString(): String = "Available"
    }

    data class UsedBy(val user: User) : Status() {
        override fun toString(): String = "Used by $user"
    }

    object ComingSoon : Status() {
        override fun toString(): String = "Coming soon"
    }

    object Restoration : Status() {
        override fun toString(): String = "Restoration"
    }

}