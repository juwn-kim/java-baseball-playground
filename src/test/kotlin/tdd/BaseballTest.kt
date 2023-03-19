package tdd

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class BaseballTest {

    @BeforeEach
    fun before() {
        val putter = mockk<Putter>()
        every {
            putter.getInputs()
        } returns listOf("2", "+", "3", "*", "4", "/", "2")
    }

    @Test
    fun play() {
    }

    @Test
    fun generateMyNumber() {
        val baseball = Baseball()
        val result = baseball.generateMyNumber()

        assert(result.size == 3)
        result.forEach {
            assert(it in 0..9)
        }
    }

    @Test
    fun checkWhenSame() {
        val baseball = Baseball()

        val myNumber = listOf(1, 2, 3)
        val yourNumber = listOf(1, 2, 3)

        val result = baseball.check(myNumber, yourNumber)

        assert(result)
    }

    @Test
    fun checkWhenDifferent() {
        val baseball = Baseball()

        val myNumber = listOf(1, 2, 3)
        val yourNumber = listOf(1, 2, 5)

        val result = baseball.check(myNumber, yourNumber)

        assert(!result)
    }
}