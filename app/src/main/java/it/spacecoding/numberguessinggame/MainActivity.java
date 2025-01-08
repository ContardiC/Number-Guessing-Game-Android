package it.spacecoding.numberguessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button mButtonStart;
    private RadioButton mRadioButtonTwoDigitsOpt, mRadioButtonThreeDigitsOpt, mRadioButtonFourDigitsOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mButtonStart = findViewById(R.id.btnStartGame);
        mRadioButtonTwoDigitsOpt = findViewById(R.id.rbTwoDigits);
        mRadioButtonThreeDigitsOpt = findViewById(R.id.rbThreeDigits);
        mRadioButtonFourDigitsOpt = findViewById(R.id.rbFourDigits);

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                if (!mRadioButtonTwoDigitsOpt.isChecked() && !mRadioButtonThreeDigitsOpt.isChecked() && !mRadioButtonFourDigitsOpt.isChecked()) {
                    Snackbar.make(v, "Please select a number of digits", Snackbar.LENGTH_SHORT).show();
                } else {
                    if (mRadioButtonTwoDigitsOpt.isChecked()) {
                        intent.putExtra("digits", 2);
                    }
                    if (mRadioButtonThreeDigitsOpt.isChecked()) {
                        intent.putExtra("digits", 3);
                    }
                    if (mRadioButtonFourDigitsOpt.isChecked()) {
                        intent.putExtra("digits", 4);
                    }
                    startActivity(intent);
                }
            }
        });

    }
}