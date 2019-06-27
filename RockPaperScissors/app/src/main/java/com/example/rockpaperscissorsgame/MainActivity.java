package com.example.rockpaperscissorsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rockpaperscissors.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rock, paper, scissors;
    TextView score;
    ImageView computerChoice, playerChoice;

    int playerScore, computerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign on the layout; create the variables and assigning to them the IDs that are in the layout
        rock = (Button) findViewById(R.id.rock);
        paper = (Button) findViewById(R.id.paper);
        scissors = (Button) findViewById(R.id.scissors);

        computerChoice = (ImageView) findViewById(R.id.computerChoiceImage);
        playerChoice = (ImageView) findViewById(R.id.playerChoiceImage);

        score = (TextView) findViewById(R.id.scoreLabel);


        //create some actions so when a user clicks a button, he/she will have an on listener event for each of these
        //on each button case, set the picture of what the player chose
        //on each button, calculate a random number for the computer and see who wins


        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computerChoice.setImageResource(R.drawable.rock);
                String message = playerSelectedHand("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Player Score: " + Integer.toString(playerScore) + " Computer: " + Integer.toString(computerScore));
            }
        });


        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computerChoice.setImageResource(R.drawable.paper);
                String message = playerSelectedHand("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Player Score: " + Integer.toString(playerScore) + " Computer: " + Integer.toString(computerScore));


            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computerChoice.setImageResource(R.drawable.scissors);
                String message = playerSelectedHand("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Player Score: " + Integer.toString(playerScore) + " Computer: " + Integer.toString(computerScore));


            }
        });



    }

    public String playerSelectedHand(String playerChoice){
        //give a random number to computer and see who wins

        String computerHand = "";
        Random random = new Random();

        //a number from 1 to 3
        int computerChoiceNumber = random.nextInt(3) + 1;

        if (computerChoiceNumber == 1){
            computerHand = "rock";
        } else if (computerChoiceNumber == 2){
            computerHand = "scisscors";
        } else if (computerChoiceNumber == 3){
            computerHand = "paper";
        }

        //set the picture for the computer bases on what it chose^
        if (computerHand == "rock"){
            computerChoice.setImageResource(R.drawable.rock);
        } else if (computerHand == "scissors") {
            computerChoice.setImageResource(R.drawable.scissors);
        } if (computerHand == "paper"){
            computerChoice.setImageResource(R.drawable.paper);
        }


        //compare user and computer choice to determine who won
        if (computerHand == playerChoice){
            return "Draw.";
        } else if (playerChoice == "rock" && computerHand == "scissors"){
            playerScore++;
            return "Rock crushes scissors.  You won!";
        } else if (playerChoice == "rock" && computerHand == "paper"){
            computerScore++;
            return "Paper covers rock.  The computer won!";
        } else if (playerChoice == "scissors" && computerHand == "rock"){
            computerScore++;
            return "Rock crushes scissors.  The computer won!";
        } else if (playerChoice == "scissors" && computerHand == "paper"){
            playerScore++;
            return "Scissors cuts paper.  You won!";
        } else if (playerChoice == "paper" && computerHand == "rock"){
            playerScore++;
            return "Paper covers rock.  You won!";
        } else if (playerChoice == "paper" && computerHand == "scissors"){
            computerScore++;
            return "Scissors cuts paper.  The computer won!";
        }
        else return "Error.";
    }

}
