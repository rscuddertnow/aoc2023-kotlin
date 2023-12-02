package day01

import Day
import Lines

class Day1 : Day() {
    val digits:List<String> = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    override fun part1(input: Lines): Any {
        return input.fold(0) { total, line: String ->
            val firstDigit = line.first { it.isDigit() }
            val lastDigit = line.findLast { it.isDigit() }

            "$firstDigit$lastDigit".toInt() + total
        }
    }

    override fun part2(input: Lines): Any {
        return input.fold(0) { total, line: String ->
            val firstDigit = line.findAnyOf(digits).let(::getDigit)
            val lastDigit = line.findLastAnyOf(digits).let(::getDigit)

            "$firstDigit$lastDigit".toInt() + total
        }
    }

    private fun getDigit(stringDigit:Pair<Int, String>?) : String {
        return when(stringDigit!!.second) {
            "zero" -> "0"
            "one" -> "1"
            "two" -> "2"
            "three" -> "3"
            "four" -> "4"
            "five" -> "5"
            "six" -> "6"
            "seven" -> "7"
            "eight" -> "8"
            "nine" -> "9"
            else -> stringDigit.second
        }
    }

}