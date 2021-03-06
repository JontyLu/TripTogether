package com.example.lenovo.triptogether.AppStart;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.triptogether.BottomNavigationBarActivity.BottomNavigationBarDemoActivity;
import com.example.lenovo.triptogether.R;

public class AppStart extends AppCompatActivity {

    private ImageView welcomeTag = null;
    private TextView slogon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (Build.VERSION.SDK_INT>16){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }*/
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }

        final View view = View.inflate(this, R.layout.appstart,null);
        setContentView(view);
        setContentView(R.layout.appstart);


        //渐变展示启动屏幕
        AlphaAnimation anima = new AlphaAnimation(0.3f,1.0f);
        anima.setDuration(2000);
        welcomeTag = (ImageView) findViewById(R.id.appstart) ;
        //slogon = (TextView) findViewById(R.id.slogan);
        welcomeTag.startAnimation(anima);
       // slogon.startAnimation(anima);
        anima.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                welcomeTag.setBackgroundResource(R.drawable.logo);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                redirecTo();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
    private void redirecTo(){
        Intent intent = new Intent(this,BottomNavigationBarDemoActivity.class);
        startActivity(intent);
        finish();
    }
}
