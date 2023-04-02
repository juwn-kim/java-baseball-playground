package study.baseball

import baseball.Ball
import baseball.BallStatus
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BallTest {
    private lateinit var ball: Ball

    @BeforeEach
    fun beforeEach() {
        ball = Ball(1, 4)
    }

    @Test
    fun nothing() {
        assert(ball.play(Ball(2, 5)) == BallStatus.NOTHING)
    }

    @Test
    fun ball() {
        val ball = Ball(1, 4)
        assert(ball.play(Ball(2, 4)) == BallStatus.BALL)
    }

    @Test
    fun strike() {
        val ball = Ball(1, 4)
        assert(ball.play(Ball(1, 4)) == BallStatus.STRIKE)
    }
}