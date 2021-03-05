class Field(private val size: Int) {


    private val empty = "___"
    private var field = Array(size) { Array(size) { empty } }
    private var isGameFinished = false
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

    fun setFigure(x: Int, y: Int, figure: String) {
        if (!isGameFinished && isPositionValid(x, y) && field[x][y] == empty) {
            field[x][y] = figure
            moveCount++
            printField()
        }
    }

    fun isPositionValid(x: Int, y: Int) = ((x in 0 until size) && (y in 0 until size))
}