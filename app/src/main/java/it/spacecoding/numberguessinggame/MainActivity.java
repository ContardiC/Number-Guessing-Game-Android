package it.spacecoding.numberguessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button startButton;
    private RadioButton twoDigitsRadioButton, threeDigitsRadioButton, fourDigitsRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.btnStartGame);
        twoDigitsRadioButton = findViewById(R.id.rbTwoDigits);
        threeDigitsRadioButton = findViewById(R.id.rbThreeDigits);
        fourDigitsRadioButton = findViewById(R.id.rbFourDigits);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                if (!twoDigitsRadioButton.isChecked() && !threeDigitsRadioButton.isChecked() && !fourDigitsRadioButton.isChecked()) {
                    Snackbar.make(v, "Please select a number of digits", Snackbar.LENGTH_SHORT).show();
                } else {
                    if (twoDigitsRadioButton.isChecked()) {
                        intent.putExtra("digits", 2);
                    }
                    if (threeDigitsRadioButton.isChecked()) {
                        intent.putExtra("digits", 3);
                    }
                    if (fourDigitsRadioButton.isChecked()) {
                        intent.putExtra("digits", 4);
                    }
                    startActivity(intent);
                }
            }
        });

    }
}