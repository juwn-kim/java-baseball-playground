package tdd

import java.util.*

class Calculator(
    private val putter: Putter,
) {
    fun calculate(): Double {
        val inputs = putter.getInputs()

        val numberQueue = LinkedList<Double>()
        val operatorQueue = LinkedList<Any>()

        inputs.forEach {
            if (isNumeric(it)) {
                numberQueue.add(it.toDouble())
            } else {
                operatorQueue.add(it)
            }
        }

        while (operatorQueue.size != 0) {
            val value1 = numberQueue.pop()
            val value2 = numberQueue.pop()
            val temp = when (operatorQueue.pop()) {
                "-" -> value1 - value2
                "*" -> value1 * value2
                "+" -> value1 + value2
                "/" -> value1 / value2
                else -> 0.0
            }
            numberQueue.add(0, temp)
        }

        return numberQueue.pop()
    }



    private fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { it.isDigit() }
    }
}

class Putter {
    fun getInputs(): List<String> {
        val scanner = Scanner(System.`in`)
        return scanner.nextLine().split(" ")
    }
}

fun main() {
    val calculator = Calculator(Putter())
    println("result: ${calculator.calculate()}")
}