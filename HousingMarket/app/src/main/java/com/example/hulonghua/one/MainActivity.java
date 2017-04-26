package com.example.hulonghua.one;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.hulonghua.one.R;

public class MainActivity extends Activity {
private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        txt = (TextView)super.findViewById(R.id.txt);
txt.setText("上个界面正常");
    }
}
