package laba7

import java.io.File

object FileUtils {

    fun write(path: String, value: String) {
        File(path).writeText(value)
    }

    fun read(path: String): String {
        return File(path).readText()
    }
}