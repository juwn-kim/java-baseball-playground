package baseball

class ValidationUtil {
    companion object {
        private const val MIN = 1
        private const val MAX = 9

        fun validNumber(number: Int): Boolean {
            return number in MIN..MAX
        }
    }
}