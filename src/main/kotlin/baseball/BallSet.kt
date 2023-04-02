package baseball

data class BallSet(
    val answers: List<Int>
) {
    private val answerBalls = answers.mapIndexed { index, i -> Ball(index + 1, i) }

    fun play(userBall: Ball): BallStatus {
        return answerBalls.map { it.play(userBall) }.firstOrNull { it != BallStatus.NOTHING } ?: BallStatus.NOTHING
    }

    fun play(userBall: BallSet): PlayResult {
        val playResult = PlayResult(0, 0)
        val userBalls = userBall.answers.mapIndexed { index, i -> Ball(index + 1, i) }
        userBalls.forEach {
            val ballStatus = play(it)
            playResult.report(ballStatus)
        }
        return playResult
    }
}