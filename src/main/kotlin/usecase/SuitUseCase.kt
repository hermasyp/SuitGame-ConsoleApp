package usecase

import enum.SuitCharacter

interface SuitUseCase {
    fun decideWinner(playerOne : SuitCharacter?,playerTwo : SuitCharacter?) : Int
}