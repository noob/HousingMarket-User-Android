package com.example.hulonghua.one;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.wx.ovalimageview.RoundImageView;
import com.youth.banner.Banner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hulonghua on 2017/5/3.
 */
public class Homepagefragment extends Fragment {
    @Bind(R.id.location)
    TextView location;
    @Bind(R.id.scan)
    Button scan;
    @Bind(R.id.searchView)
    SearchView searchView;
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.housemaket)
    RoundImageView housemaket;
    @Bind(R.id.zahuo)
    RoundImageView zahuo;
    @Bind(R.id.shuiguo)
    RoundImageView shuiguo;
    @Bind(R.id.shucai)
    RoundImageView shucai;
    @Bind(R.id.housemakettxt)
    TextView housemakettxt;
    @Bind(R.id.zahuotxt)
    TextView zahuotxt;
    @Bind(R.id.shuiguotxt)
    TextView shuiguotxt;
    @Bind(R.id.shucaitxt)
    TextView shucaitxt;
    @Bind(R.id.more)
    RoundImageView more;
    @Bind(R.id.no1)
    RoundImageView no1;
    @Bind(R.id.no2)
    RoundImageView no2;
    @Bind(R.id.no3)
    RoundImageView no3;
    @Bind(R.id.moretxt)
    TextView moretxt;
    @Bind(R.id.no1txt)
    TextView no1txt;
    @Bind(R.id.no2txt)
    TextView no2txt;
    @Bind(R.id.no3txt)
    TextView no3txt;
    private Context context;
    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;
    /**
     * 选择系统图片Request Code
     */
    public static final int REQUEST_IMAGE = 112;
    public Homepagefragment() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_layout, container, false);
        ButterKnife.bind(this, view);
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
        List<Integer> imgesUrl = new ArrayList<>();
        imgesUrl.add(R.mipmap.c);
        imgesUrl.add(R.mipmap.f);
        imgesUrl.add(R.mipmap.d);
        banner.setImages(imgesUrl);
        banner.setImageLoader(new GlideImageLoader());
        banner.start();
        housemaket.setImageResource(R.mipmap.c, Color.BLACK, 1, true);
        zahuo.setImageResource(R.mipmap.c, Color.BLACK, 1, true);
        shuiguo.setImageResource(R.mipmap.c, Color.BLACK, 1, true);
        shucai.setImageResource(R.mipmap.c, Color.BLACK, 1, true);
        more.setImageResource(R.mipmap.c, Color.BLACK, 1, true);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class OnQuetyTextListenerImpl implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            if (!TextUtils.isEmpty(newText)) {

            } else {

            }
            return false;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(context, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(context, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }



    }
}
