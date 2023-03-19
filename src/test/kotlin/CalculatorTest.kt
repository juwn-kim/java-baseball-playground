import io.mockk.*
import org.junit.jupiter.api.Test
import tdd.Calculator
import tdd.Putter

class CalculatorTest {

    @Test
    fun calculateTest() {
        val putter = mockk<Putter>()
        every {
            putter.getInputs()
        } returns listOf("2", "+", "3", "*", "4", "/", "2")

        val calculator = Calculator(putter)
        val result = calculator.calculate()
//        verify { calculator.calculate() }
        assert(result == 10.0)
    }
}