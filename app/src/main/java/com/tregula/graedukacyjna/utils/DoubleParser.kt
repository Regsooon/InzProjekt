package com.tregula.graedukacyjna.utils

class DoubleParser {

    fun parse(parsable: String): Double =
            try {
                parsable.toDouble()
            } catch (ex: NumberFormatException) {
                0.0
            }
}
