import java.util.*

private lateinit var field: Field
private val player1: PlayerFigure = PlayerFigure.PLAYER1
private val player2: PlayerFigure = PlayerFigure.PLAYER2
private var currentPlayer = player2

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    println("Print size of the board")
    val size = Integer.parseInt(scanner.nextLine())
    field = Field(size)
    field.printField()

    while (!field.isGameFinished) {
        takeTurns()
        println("$currentPlayer turn")
        println("Enter x coordinate")
        val x = Integer.parseInt(scanner.nextLine())
        println("Enter y coordinate")
        val y = Integer.parseInt(scanner.nextLine())
        if (!field.setFigure(y - 1, x - 1, currentPlayer.figure)) {
            takeTurns()
        }
    }
}

fun takeTurns() {
    currentPlayer = if (player1 == currentPlayer) {
        player2
    } else {
        player1
    }
}