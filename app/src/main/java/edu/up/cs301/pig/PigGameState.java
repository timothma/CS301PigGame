package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by macnary17 on 10/15/2015.
 */
public class PigGameState extends GameState {
    public int id;
    public int player1Score;
    public int player2Score;
    public int hold;
    public int dieValue;

    public PigGameState(){
        id = 0;
        player1Score = 0;
        player2Score = 0;
        hold = 0;
        dieValue = 1;
    }

    public PigGameState(PigGameState copyState){
        this.id = copyState.id;
        this.player1Score = copyState.player1Score;
        this.player2Score = copyState.player2Score;
        this.hold = copyState.hold;
        this.dieValue = copyState.dieValue;
    }

    public int getId(){
        return this.id;
    }

    public int getPlayer1Score(){
        return this.player1Score;
    }

    public int getPlayer2Score(){
        return this.player2Score;
    }

    public int getHold(){
        return this.hold;
    }

    public int getDieValue(){
        return this.dieValue;
    }

    public void toggleHold(){
        if(id == 0){
            player1Score += hold;
        }
        else{
            player2Score += hold;
        }
    }

    public void toggleRoll(){
        Random rand = new Random();
        int rand1 = rand.nextInt(6) + 1;

        if(rand1 == 1){
            hold = 0;

            if(id == 1){
                id = 0;
            }
            else{
                id = 1;
            }
        }
        else{
            hold += dieValue;
        }


    }
}
