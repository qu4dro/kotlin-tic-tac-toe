class Field(private val size: Int) {

    private val moveCount = 0
    private val empty = "___"
    private var field = Array(size) { Array(size) { empty } }
    var isGameFinished = false

    fun resetField() {
        field = Array(size) { Array(size) { empty } }
    }

    fun printField() {
        field.forEach { row ->
            row.forEach {
                println(it)
            }
            println()
        }
        println()
    }
}