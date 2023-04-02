package baseball

data class Ball(
    val position: Int,
    val number: Int,
) {
    fun play(ball: Ball): BallStatus {
        return if (this == ball) {
            BallStatus.STRIKE
        } else if (ball.position != position && matchBall(ball)) {
            BallStatus.BALL
        } else {
            BallStatus.NOTHING
        };
    }

    private fun matchBall(ball: Ball): Boolean {
        return this.number == ball.number
    }

}

enum class BallStatus {
    NOTHING, BALL, STRIKE
}