package com.example.rmatze.animation;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mBigGear1, mBigGear2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBigGear1 = (ImageView) findViewById(R.id.big_gear_1);
        mBigGear2 = (ImageView) findViewById(R.id.big_gear_2);

        // Step1 : create the  RotateAnimation object
        RotateAnimation anim = new RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // Step 2:  Set the Animation properties
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(5000);

        // Step 3: Start animating the image
        mBigGear1.startAnimation(anim);


        // Step1 : create the  RotateAnimation object
        RotateAnimation anim2 = new RotateAnimation(359f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // Step 2:  Set the Animation properties
        anim2.setInterpolator(new LinearInterpolator());
        anim2.setRepeatCount(Animation.INFINITE);
        anim2.setDuration(5000);

        // Step 3: Start animating the image
        mBigGear2.startAnimation(anim2);

        EkgPath path_view = (EkgPath) findViewById(R.id.path_1);
        path_view.init();

//        new Handler().postDelayed(new Runnable() {
//            public void run() {
//                EkgPath path_view2 = (EkgPath) findViewById(R.id.path_2);
//                path_view2.init(Color.WHITE);
//            }
//        }, 100);

    }
}
