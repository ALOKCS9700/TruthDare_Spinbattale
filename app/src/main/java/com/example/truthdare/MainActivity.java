package com.example.truthdare;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    private Random random=new Random();
    private int lastDirection;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);


    }

    public void spin(View view){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bat);

        int newdirection= random.nextInt(36000);
        float pivotx= imageView.getWidth()/2;
        float pivoty= imageView.getHeight()/2;
        Animation rotate=new RotateAnimation(lastDirection,newdirection,pivotx,pivoty);
        rotate.setDuration(5000);
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
                mediaPlayer.start(); 
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
//                mediaPlayer.stop();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastDirection=newdirection;
        imageView.setAnimation(rotate);
        imageView.startAnimation(rotate);



    }
}