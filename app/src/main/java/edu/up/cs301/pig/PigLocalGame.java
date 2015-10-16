package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */
    PigGameState myState;

    public PigLocalGame() {

        myState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    public boolean canMove(int playerIdx) {

        if(playerIdx == myState.getId()){
            return true;
        }

        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    public boolean makeMove(GameAction action) {

        if(canMove(getPlayerIdx(action.getPlayer())) == true){
            if(action instanceof PigHoldAction){
                myState.toggleHold();
            }
            else{
                myState.toggleRoll();
            }
        }

        return false;

    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

        PigGameState copyState;
        copyState= new PigGameState(myState);

        p.sendInfo(copyState);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    public String checkIfGameOver() {

        if(myState.getPlayer1Score() >= 50){
            return "Player 1 has won the game";
        }
        if(myState.getPlayer2Score() >= 50){
            return "Player 2 has won the game";
        }
        return null;
    }

}// class PigLocalGame
