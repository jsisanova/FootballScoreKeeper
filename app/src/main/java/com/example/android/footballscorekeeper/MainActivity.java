package com.example.android.footballscorekeeper;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int scoreSpartak = 0;
    int scoreSlovan = 0;
    int yellowCardCountSpartak = 0;
    int yellowCardCountSlovan = 0;
    boolean isPressed = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the score for Spartak
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.spartakScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the score for Slovan
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.slovanScore);
        scoreView.setText(String.valueOf(score));
    }



    /**
     * Displays yellow / red card for Spartak
     */
    public void displayYellowCardSpartak(int number) {
        Button b = (Button) findViewById(R.id.yellowCardSpartak);
        b.setText(String.valueOf(number));

//        if more than 1 yellow card, card changes to red
        if (isPressed == false) {
            b.setBackgroundColor(getResources().getColor(R.color.yellowCardColor));
        }

//        after pressing reset color of card is yellow again
        if (number > 1) {
            b.setText(" ");
            b.setBackgroundColor(Color.RED);
        }
    }


    /**
     * Displays yellow / red card for Slovan
     */
    public void displayYellowCardSlovan(int number) {
        Button b = (Button) findViewById(R.id.yellowCardSlovan);
        b.setText(String.valueOf(number));

//        if more than 1 yellow card, card changes to red
        if (number > 1) {
            b.setText(" ");
            b.setBackgroundColor(Color.RED);
        }

//        after pressing reset color of card is yellow again
        if (isPressed == false) {
            b.setBackgroundColor(getResources().getColor(R.color.yellowCardColor));
        }
    }




    //called methods
    //    increase score for Spartak
    public void scoreGoalSpartak(View view) {
        scoreSpartak = scoreSpartak + 1;
        displayForTeamA(scoreSpartak);
    }

    //    increase score for Slovan
    public void scoreGoalSlovan(View view) {
        scoreSlovan = scoreSlovan + 1;
        displayForTeamB(scoreSlovan);
    }


    //    increase number of yellow cards for Spartak
    public void addOnYellowCardSpartak(View view) {
        yellowCardCountSpartak = yellowCardCountSpartak + 1;
        displayYellowCardSpartak(yellowCardCountSpartak);
    }

    //    increase number of yellow cards for Slovan
    public void addOnYellowCardSlovan(View view) {
        yellowCardCountSlovan = yellowCardCountSlovan + 1;
        displayYellowCardSlovan(yellowCardCountSlovan);
    }



    //    reset score
    public void resetScore(View view) {
        scoreSpartak = 0;
        scoreSlovan = 0;
        yellowCardCountSpartak = 0;
        yellowCardCountSlovan = 0;
        isPressed = false;
        displayForTeamA(scoreSpartak);
        displayForTeamB(scoreSlovan);
        displayYellowCardSpartak(yellowCardCountSpartak);
        displayYellowCardSlovan(yellowCardCountSlovan);
    }
}




