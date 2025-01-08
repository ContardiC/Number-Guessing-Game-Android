package it.spacecoding.numberguessinggame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private ImageView mImageViewLogo;
    private TextView mTextViewGameTitle;
    Animation mAnimationImage, mAnimationText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mImageViewLogo = findViewById(R.id.imageViewLogo);
        mTextViewGameTitle = findViewById(R.id.textViewGameTitle);
        mAnimationImage = AnimationUtils.loadAnimation(this, R.anim.image_animation);
        mAnimationText = AnimationUtils.loadAnimation(this, R.anim.text_animation);
        // Start animation
        mImageViewLogo.startAnimation(mAnimationImage);
        mTextViewGameTitle.startAnimation(mAnimationText);
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