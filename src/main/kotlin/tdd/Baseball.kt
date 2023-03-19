package tdd

import java.util.*

class Baseball {
    private val userInput = UserInput()

    fun play() {
        while (userInput.isStartNewGame()) {
            val myNumber = generateMyNumber()
            dice(myNumber)
        }
    }

    private fun dice(myNumber: List<Int>) {
        var result = false

        while (!result) {
            val yourNumber = userInput.getInputs()
            result = check(myNumber, yourNumber)
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    fun generateMyNumber(): List<Int> {
        return (1..3).map { (0..9).random() }
    }

    fun check(myNumber: List<Int>, yourNumber: List<Int>): Boolean {
        var strike = 0
        var ball = 0

        for (i in myNumber.indices) {
            if (yourNumber[i] == myNumber[i]) {
                strike++
            } else if (myNumber.contains(yourNumber[i])) {
                ball++
            }
        }

        val result = """
            $ball 볼 $strike 스트라이크
        """.trimIndent()
        println(result)

        return strike == 3
    }
}

class UserInput {
    private val scanner = Scanner(System.`in`)

    fun isStartNewGame(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return scanner.nextLine().toInt() == 1
    }
    fun getInputs(): List<Int> {
        print("숫자를 입력해 주세요 : ")
        return scanner.nextLine().toCharArray().map { it.digitToInt() }
    }
}

fun main() {
    val baseball = Baseball()
    baseball.play()
}