package usecase

import enum.SuitCharacter

class SuitUseCaseImpl : SuitUseCase {

    companion object{
        const val DRAW = 0
        const val PLAYER_ONE_WIN = 1
        const val PLAYER_TWO_WIN = 2
    }

    override fun decideWinner(playerOne : SuitCharacter?,playerTwo : SuitCharacter?) : Int {
        return if(playerOne == playerTwo){
            DRAW
        }else if(playerOne == SuitCharacter.ROCK){
            if(playerTwo == SuitCharacter.PAPER){
                PLAYER_TWO_WIN
            }else{
                PLAYER_ONE_WIN
            }
        }else if(playerOne == SuitCharacter.PAPER){
            if(playerTwo == SuitCharacter.SCISSOR){
                PLAYER_TWO_WIN
            }else{
                PLAYER_ONE_WIN
            }
        }else{
            //if player 1 pick scissor
            if(playerTwo == SuitCharacter.ROCK){
                PLAYER_TWO_WIN
            }else{
                PLAYER_ONE_WIN
            }
        }
    }


}