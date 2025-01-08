package it.spacecoding.numberguessinggame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private TextView mTextViewLastNumber, mTextViewRight, mTextViewHint;
    private EditText mEditTextGuess;
    private Button mButtonConfirm;
    private Random random = new Random();
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
                    int userGuess = Integer.parseInt(guess);
                    mTextViewLastNumber.setText(guess);
                    mTextViewRight.setText(remainingRight);
                    if(randomNumber == userGuess){

                    }
                    if(randomNumber > userGuess){
                        mTextViewHint.setText("Increase your guess");
                    }
                    if(randomNumber < userGuess){
                        mTextViewHint.setText("Decrease your guess");
                    }
                    if(remainingRight == 0){

                    }
                    mEditTextGuess.setText("");
                }
            }
        });
    }
}