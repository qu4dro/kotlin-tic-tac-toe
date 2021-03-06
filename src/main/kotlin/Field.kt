import kotlin.math.pow

class Field(private val size: Int) {


    private val empty = "___"
    private var field = Array(size) { Array(size) { empty } }
    var isGameFinished = false
    private var moveCount = 0

    fun resetField() {
        field = Array(size) { Array(size) { empty } }
    }

    fun printField() {
        field.forEach { row ->
            row.forEach {
                if (it == empty) {
                    print("|$it|")
                } else {
                    print("| $it |")
                }
            }
            println()
        }
        println()
    }

    fun setFigure(x: Int, y: Int, figure: String): Boolean {
        if (!isGameFinished && isPositionValid(x, y) && field[x][y] == empty) {
            field[x][y] = figure
            moveCount++
            printField()
            isGameFinished = isMoveWin(x, y, figure) || isDraw()
            if (isGameFinished) {
                println("WIN")
            } else if (isDraw()) {
                println("DRAW")
            }
            return true
        }
        else {
            println("Your move is invalid, try again!")
            printField()
            return false
        }
    }


    fun isMoveWin(x: Int, y: Int, figure: String): Boolean {
        return when {
            checkColumn(x, y, figure) -> true
            checkRow(x, y, figure) -> true
            checkDiagonalFirst(x, y, figure) -> true
            checkDiagonalSecond(x, y, figure) -> true
            else -> false
        }
    }

    fun isDraw() = (moveCount == (size * size))

    fun resetGame() {
        resetField()
        isGameFinished = false
        moveCount = 0
    }

    private fun isPositionValid(x: Int, y: Int) = ((x in 0 until size) && (y in 0 until size))

    private fun checkColumn(x: Int, y: Int, figure: String): Boolean {
        for (i in 0 until size) {
            when {
                field[x][i] != figure -> break
                (i == size - 1) -> return true
            }

        }
        return false
    }

    private fun checkRow(x: Int, y: Int, figure: String): Boolean {
        for (i in 0 until size) {
            when {
                field[i][y] != figure -> break
                (i == size - 1) -> return true
            }
        }
        return false
    }

    private fun checkDiagonalFirst(x: Int, y: Int, figure: String): Boolean {
        if (x == y) {
            for (i in 0 until size) {
                when {
                    field[i][i] != figure -> break
                    (i == size - 1) -> return true
                }
            }

        }
        return false
    }

    private fun checkDiagonalSecond(x: Int, y: Int, figure: String): Boolean {
        if (x + y == size - 1) {
            for (i in 0 until size) {
                when {
                    field[i][(size - 1 - i)] != figure -> break
                    (i == size - 1) -> return true
                }
            }
        }
        return false
    }
}