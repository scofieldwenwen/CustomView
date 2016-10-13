package com.scofield.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.scofield.customview.view.RadianView;

import java.util.ArrayList;

public class RadianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radian);

        ArrayList<RadianBean> mData = new ArrayList<>();
        mData.add(new RadianBean("购物", 30));
        mData.add(new RadianBean("房租", 20));
        mData.add(new RadianBean("还款", 40));
        mData.add(new RadianBean("存款", 10));

        RadianView radianView = (RadianView) findViewById(R.id.radian_view);
        radianView.setData(mData);
    }
}
