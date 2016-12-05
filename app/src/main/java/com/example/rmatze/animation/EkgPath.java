package com.example.rmatze.animation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by rmatze@gmail.com on 9/14/16.
 */

public class EkgPath extends View {

    Path path;
    Paint paint;
    float length;

    public EkgPath(Context context) {
        super(context);
    }

    public EkgPath(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public EkgPath(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public void init()
    {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
        path.moveTo(0, 150);
        path.lineTo(150, 150);
        path.lineTo(170, 185);
        path.lineTo(190, 0);
        path.lineTo(210, 150);
        path.lineTo(300, 150);
        path.lineTo(350, 150);
        path.lineTo(370, 185);
        path.lineTo(390, 0);
        path.lineTo(410, 150);
        path.lineTo(500, 150);
        path.lineTo(550, 150);
        path.lineTo(570, 185);
        path.lineTo(590, 0);
        path.lineTo(610, 150);
        path.lineTo(700, 150);
        path.lineTo(750, 150);
        path.lineTo(770, 185);
        path.lineTo(790, 0);
        path.lineTo(810, 150);
        path.lineTo(900, 150);
        path.lineTo(950, 150);
        path.lineTo(970, 185);
        path.lineTo(990, 0);
        path.lineTo(1010, 150);
        path.lineTo(1100, 150);






//        path.moveTo(0, 200);
//        path.lineTo(150, 200);
//        path.lineTo(170, 235);
//        path.lineTo(190, 50);
//        path.lineTo(210, 200);
//        path.lineTo(300, 200);
//        path.lineTo(350, 200);
//        path.lineTo(370, 235);
//        path.lineTo(390, 50);
//        path.lineTo(410, 200);
//        path.lineTo(500, 200);
//        path.lineTo(550, 200);
//        path.lineTo(570, 235);
//        path.lineTo(590, 50);
//        path.lineTo(610, 200);
//        path.lineTo(700, 200);
//        path.lineTo(750, 200);
//        path.lineTo(770, 235);
//        path.lineTo(790, 50);
//        path.lineTo(810, 200);
//        path.lineTo(900, 200);
//        path.lineTo(950, 200);
//        path.lineTo(970, 235);
//        path.lineTo(990, 50);
//        path.lineTo(1010, 200);
//        path.lineTo(1100, 200);
//
//        paint.setColor(Color.WHITE);
//        path.moveTo(0, 150);
//        path.lineTo(150, 150);
//        path.lineTo(170, 185);
//        path.lineTo(190, 0);
//        path.lineTo(210, 150);
//        path.lineTo(300, 150);
//        path.lineTo(350, 150);
//        path.lineTo(370, 185);
//        path.lineTo(390, 0);
//        path.lineTo(410, 150);
//        path.lineTo(500, 150);
//        path.lineTo(550, 150);
//        path.lineTo(570, 185);
//        path.lineTo(590, 0);
//        path.lineTo(610, 150);
//        path.lineTo(700, 150);
//        path.lineTo(750, 150);
//        path.lineTo(770, 185);
//        path.lineTo(790, 0);
//        path.lineTo(810, 150);
//        path.lineTo(900, 150);
//        path.lineTo(950, 150);
//        path.lineTo(970, 185);
//        path.lineTo(990, 0);
//        path.lineTo(1010, 150);
//        path.lineTo(1100, 150);


        // Measure the path
        PathMeasure measure = new PathMeasure(path, false);
        length = measure.getLength();

        float[] intervals = new float[]{length, length};

        ObjectAnimator animator = ObjectAnimator.ofFloat(EkgPath.this, "phase", 1.0f, 0.0f);
        animator.setDuration(3000);
        animator.start();
    }

    //is called by animtor object
    public void setPhase(float phase)
    {
        Log.d("pathview","setPhase called with:" + String.valueOf(phase));
        paint.setPathEffect(createPathEffect(length, phase, 0.0f));
        invalidate();//will calll onDraw
    }

    private static PathEffect createPathEffect(float pathLength, float phase, float offset)
    {
        return new DashPathEffect(new float[] { pathLength, pathLength },
                Math.max(phase * pathLength, offset));
    }

    @Override
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        c.drawPath(path, paint);
    }
}
