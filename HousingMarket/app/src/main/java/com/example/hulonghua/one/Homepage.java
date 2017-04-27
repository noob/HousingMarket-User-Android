package com.example.hulonghua.one;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class Homepage extends Activity {
private TextView locationtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_homepage);
        locationtxt =(TextView)super.findViewById(R.id.location);
        locationtxt.setText("位置：");
    }
}
