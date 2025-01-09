package it.spacecoding.numberguessinggame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private TextView mTextViewLastNumber, mTextViewRight, mTextViewHint;
    private EditText mEditTextGuess;
    private Button mButtonConfirm;
    private Random random = new Random();
    ArrayList<Integer> guesses = new ArrayList<>();
    int userAttempts = 0;
    int randomNumber;
    int remainingRight = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        mTextViewLastNumber = findViewById(R.id.tvLastNumber);
        mTextViewRight = findViewById(R.id.tvRight);
        mTextViewHint = findViewById(R.id.tvHint);
        mEditTextGuess = findViewById(R.id.etGuess);
        mButtonConfirm = findViewById(R.id.btnConfirm);

        int digits = getIntent().getIntExtra("digits", 2);
        switch (digits) {
            case 2:
                randomNumber = random.nextInt(90) + 10;
                break;
            case 3:
                randomNumber = random.nextInt(900) + 100;
                break;
            case 4:
                randomNumber = random.nextInt(9000) + 1000;
                break;
        }
        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guess = mEditTextGuess.getText().toString();
                if (guess.isEmpty()) {
                    Toast.makeText(GameActivity.this, "Please enter a guess", Toast.LENGTH_SHORT).show();
                } else {

                    mTextViewLastNumber.setVisibility(View.VISIBLE);
                    mTextViewRight.setVisibility(View.VISIBLE);
                    mTextViewHint.setVisibility(View.VISIBLE);
                    remainingRight--;
                    userAttempts++;
                    guesses.add(Integer.parseInt(guess));
                    int userGuess = Integer.parseInt(guess);
                    guesses.add(userGuess);
                    mTextViewLastNumber.setText("Your last guess is :" + guess);
                    mTextViewRight.setText("Your remaining right is :" +remainingRight);
                    if(randomNumber == userGuess){
                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Number Guessing Game");
                        builder.setCancelable(false);
                        builder.setMessage("Congratulations. You guessed the number in " + userAttempts + " attempts" +
                                "\n\nWould You like to play again?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });
                        builder.create().show();
                    }
                    if(randomNumber > userGuess){
                        mTextViewHint.setText("Increase your guess");
                    }
                    if(randomNumber < userGuess){
                        mTextViewHint.setText("Decrease your guess");
                    }
                    if(remainingRight == 0){
                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Number Guessing Game");
                        builder.setCancelable(false);
                        builder.setMessage("Sorry your right are over. "+
                                "\n\nWould You like to play again?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });
                        builder.create().show();
                    }
                    mEditTextGuess.setText("");
                }
            }
        });
    }
}