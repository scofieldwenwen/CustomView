package com.scofield.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBasicShapeClick(View view) {
        startActivity(new Intent(this,BasicShapeActivity.class));
    }
    public void onRadianClick(View view) {
        startActivity(new Intent(this,RadianActivity.class));
    }
    public void onCanvasClick(View view) {
        startActivity(new Intent(this,CanvasActivity.class));
    }
}
