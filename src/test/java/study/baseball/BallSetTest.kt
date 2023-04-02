package study.baseball

import baseball.Ball
import baseball.BallSet
import baseball.BallStatus
import org.junit.jupiter.api.Test

class BallSetTest {
    @Test
    fun play_nothing() {
        val answers = BallSet(listOf(1, 2, 3))
        val playResult = answers.play(BallSet(listOf(4, 5, 6)))
        assert(playResult.strike == 0)
        assert(playResult.ball == 0)
    }

    @Test
    fun play_3_strike() {
        val answers = BallSet(listOf(1, 2, 3))
        val playResult = answers.play(BallSet(listOf(1, 2, 3)))
        assert(playResult.strike == 3)
        assert(playResult.ball == 0)
    }

    @Test
    fun play_1_strike_2_ball() {
        val answers = BallSet(listOf(1, 2, 3))
        val playResult = answers.play(BallSet(listOf(3, 2, 1)))
        assert(playResult.strike == 1)
        assert(playResult.ball == 2)
    }

    @Test
    fun play_2ball() {
        val answers = BallSet(listOf(1, 2, 3))
        val playResult = answers.play(BallSet(listOf(2, 3, 6)))
        assert(playResult.strike == 0)
        assert(playResult.ball == 2)
    }

    @Test
    fun nothing() {
        val answers = BallSet(listOf(1, 2, 3))
        val result = answers.play(Ball(1, 4))
        assert(result == BallStatus.NOTHING)
    }

    @Test
    fun ball() {
        val answers = BallSet(listOf(1, 2, 3))
        val result = answers.play(Ball(1, 2))
        assert(result == BallStatus.BALL)
    }

    @Test
    fun strike() {
        val answers = BallSet(listOf(1, 2, 3))
        val result = answers.play(Ball(1, 1))
        assert(result == BallStatus.STRIKE)
    }
}