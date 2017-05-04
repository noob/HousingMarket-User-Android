package com.example.hulonghua.one;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Homepage extends Activity {
    @Bind(R.id.location)
    TextView location;
    @Bind(R.id.scan)
    Button scan;
    @Bind(R.id.searchView)
    SearchView searchView;
    @Bind(R.id.banner)
    Banner banner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_homepage);
        ButterKnife.bind(this);
        location.setText("位置：");
        Class<?> c = searchView.getClass();
        try {
            Field f = c.getDeclaredField("mSearchPlate");//通过反射，获得类对象的一个属性对象
            f.setAccessible(true);//设置此私有属性是可访问的
            View v = (View) f.get(searchView);//获得属性的值
            v.setBackgroundResource(R.drawable.searchview_shape);//设置此view的背景
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchView.setOnQueryTextListener(new OnQuetyTextListenerImpl());
        banner = (Banner) findViewById(R.id.banner);
        List<Integer> imgesUrl = new ArrayList<>();
        imgesUrl.add(R.mipmap.c);
        imgesUrl.add(R.mipmap.f);
        imgesUrl.add(R.mipmap.d);
        banner.setImages(imgesUrl);
        banner.setImageLoader(new GlideImageLoader());
        banner.start();
    }

    public class OnQuetyTextListenerImpl implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextChange(String newText) {
            if (!TextUtils.isEmpty(newText)) {

            } else {

            }
            return false;
        }

        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    protected void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }
}
