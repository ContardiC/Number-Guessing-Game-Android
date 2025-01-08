package it.spacecoding.numberguessinggame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private ImageView imageViewLogo;
    private TextView textViewGameTitle;
    Animation animationImage, animationText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageViewLogo = findViewById(R.id.imageViewLogo);
        textViewGameTitle = findViewById(R.id.textViewGameTitle);
        animationImage = AnimationUtils.loadAnimation(this, R.anim.image_animation);
        animationText = AnimationUtils.loadAnimation(this, R.anim.text_animation);
        // Start animation
        imageViewLogo.startAnimation(animationImage);
        textViewGameTitle.startAnimation(animationText);
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }.start();
    }
}