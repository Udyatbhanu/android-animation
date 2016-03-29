package com.home.ubbs.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isJerryShowing = true;
    ImageView jerry,garfield;

    public void clickImage(View view){
        Log.i("Info", "Image clicked");
        if(isJerryShowing){
            jerry.animate().alpha(0f).setDuration(2000);
            garfield.animate().alpha(1f).setDuration(2000);
            isJerryShowing = false;
        }else{
            garfield.animate().alpha(0f).setDuration(2000);
            jerry.animate().alpha(1f).setDuration(2000);

            isJerryShowing = true;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jerry = (ImageView)findViewById(R.id.jerry);
        garfield = (ImageView)findViewById(R.id.garfield);
        if(null!=savedInstanceState){
            isJerryShowing =  savedInstanceState.getBoolean("isJerryShowing");
            if(isJerryShowing){
                jerry.setAlpha(1f);
                garfield.setAlpha(0f);
            }else{
                jerry.setAlpha(0f);
                garfield.setAlpha(1f);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean("isJerryShowing", isJerryShowing);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
}
