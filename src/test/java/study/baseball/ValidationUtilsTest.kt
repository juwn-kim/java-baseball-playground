package study.baseball

import baseball.ValidationUtil
import org.junit.jupiter.api.Test

class ValidationUtilsTest {
    @Test
    fun `야구_숫자_1_9_검사`() {
        assert(ValidationUtil.validNumber(1))
        assert(ValidationUtil.validNumber(9))
        assert(!ValidationUtil.validNumber(0))
        assert(!ValidationUtil.validNumber(10))
    }
}