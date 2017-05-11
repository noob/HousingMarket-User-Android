package com.example.hulonghua.one;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TrueMainActivity extends AppCompatActivity {
    @Bind(R.id.main_framelayout)
    FrameLayout mainFramelayout;
    @Bind(R.id.homepagetxt)
    TextView homepagetxt;
    @Bind(R.id.homepagelayout)
    LinearLayout homepagelayout;
    @Bind(R.id.shoppinglayout)
    LinearLayout shoppinglayout;
    @Bind(R.id.indentlayout)
    LinearLayout indentlayout;
    @Bind(R.id.minelayout)
    LinearLayout minelayout;
    @Bind(R.id.shoppingtxt)
    TextView shoppingtxt;
    @Bind(R.id.indenttxt)
    TextView indenttxt;
    @Bind(R.id.minetxt)
    TextView minetxt;
    private FragmentManager fragmentManager;
    private Shoppingfragment shoppingfragment;
    private Minefragment minefragment;
    private Indentfragment indentfragment;
    private Homepagefragment homepagefragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        init();
    }
    private void init(){
        setChooseItem(0);
        homepagelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(0);
            }
        });
        shoppinglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(1);
            }
        });
        indentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(2);
            }
        });
        minelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(3);
            }
        });
    }
    public void setChooseItem(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        clear();
        hideFragments(fragmentTransaction);
        switch (index) {
            case 0:
                homepagetxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (homepagefragment == null) {
                    // 如果loveCarFragment为空，则创建一个并添加到界面上
                    homepagefragment = new Homepagefragment();
                    fragmentTransaction.add(R.id.main_framelayout, homepagefragment);
                } else {
                    fragmentTransaction.show(homepagefragment);
                }
                break;

            case 1:
                shoppingtxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (shoppingfragment == null) {
                    shoppingfragment = new Shoppingfragment();
                    fragmentTransaction.add(R.id.main_framelayout, shoppingfragment);
                } else {
                    fragmentTransaction.show(shoppingfragment);
                }
                break;

            case 2:
                indenttxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (indentfragment == null) {
                    indentfragment = new Indentfragment();
                    fragmentTransaction.add(R.id.main_framelayout, indentfragment);
                } else {
                    fragmentTransaction.show(indentfragment);
//                    monitorFragment.onResume();
                }
                break;

            case 3:
                minetxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (minefragment == null) {
                    minefragment = new Minefragment();
                    fragmentTransaction.add(R.id.main_framelayout, minefragment);
                } else {
                    fragmentTransaction.show(minefragment);
//                    serviceFragment.onResume();
                }
                break;


        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    //隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (homepagefragment != null) {
            fragmentTransaction.hide(homepagefragment);
        }
        if (shoppingfragment != null) {
            fragmentTransaction.hide(shoppingfragment);
        }
        if (indentfragment != null) {
            fragmentTransaction.hide(indentfragment);

        }
        if (minefragment != null) {
            fragmentTransaction.hide(minefragment);
        }
    }
    public void clear(){
        homepagetxt.setTextColor(getResources().getColor(R.color.nomal));
        shoppingtxt.setTextColor(getResources().getColor(R.color.nomal));
        indenttxt.setTextColor(getResources().getColor(R.color.nomal));
        minetxt.setTextColor(getResources().getColor(R.color.nomal));

    }


}
