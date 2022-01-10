import enum.SuitCharacter
import usecase.SuitUseCase
import usecase.SuitUseCaseImpl
import java.lang.IllegalArgumentException

class App {

    private var playerOne: SuitCharacter? = null
    private var playerTwo: SuitCharacter? = null
    private lateinit var suitUseCase: SuitUseCase

    fun run() {
        initialize()
        printHeader()
        inputPlayerCharacters()
        proceedWinner()
    }

    private fun initialize(){
        suitUseCase = SuitUseCaseImpl()
    }

    private fun printHeader() {
        println("==================================")
        println("THE SUIT GAME")
        println("==================================")
        println("Choose between Rock,Paper,Scissor!")
        println("==================================")
    }

    private fun inputPlayerCharacters() {
        while (playerOne == null) {
            inputPlayerOne()
        }
        while (playerTwo == null) {
            inputPlayerTwo()
        }
    }

    private fun inputPlayerOne() {
        println("Please Input Character from Player 1 : ")
        playerOne = parseUserInput(getInputFromUser())
    }

    private fun inputPlayerTwo() {
        println("Please Input Character from Player 2 : ")
        playerTwo = parseUserInput(getInputFromUser())
    }

    private fun proceedWinner() {
        if (playerOne != null && playerTwo != null) {
            when (suitUseCase.decideWinner(playerOne, playerTwo)) {
                SuitUseCaseImpl.PLAYER_ONE_WIN -> {
                    println("==================================")
                    println("PLAYER ONE WON !")
                    println("==================================")
                }
                SuitUseCaseImpl.PLAYER_TWO_WIN -> {
                    println("==================================")
                    println("PLAYER TWO WON !")
                    println("==================================")
                }
                SuitUseCaseImpl.DRAW -> {
                    println("==================================")
                    println("DRAW GAME !")
                    println("==================================")
                }
            }
        }
    }

    private fun parseUserInput(input: String): SuitCharacter? {
        return if (input.isNotEmpty()) {
            try {//batu > BATU
                SuitCharacter.valueOf(input.uppercase())
            }catch (e : IllegalArgumentException){
                println("Please choose between Rock,Paper,Scissor!")
                null
            }
        } else {
            println("Choose between Rock,Paper,Scissor!")
            null
        }
    }

    private fun getInputFromUser(): String {
        return try {// "pisang " > "pisang" > "PISANG"
            readLine().toString().trim().uppercase()
        } catch (e: Exception) {
            ""
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}