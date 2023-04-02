package baseball

data class PlayResult(
    var strike: Int = 0,
    var ball: Int = 0,
) {
    fun report(ballStatus: BallStatus) {
        when (ballStatus) {
            BallStatus.BALL -> ball++
            BallStatus.STRIKE -> strike++
            else -> {}
        }
    }
}