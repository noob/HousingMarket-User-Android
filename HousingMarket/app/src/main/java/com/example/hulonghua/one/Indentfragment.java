package com.example.hulonghua.one;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import childfragment.Allfragment;
import childfragment.Finishfragment;
import childfragment.Nopainfragment;
import childfragment.Refundfragment;
import childfragment.Sendingfragment;
import childfragment.Waitsendfragment;

/**
 * Created by hulonghua on 2017/5/3.
 */
public class Indentfragment extends Fragment {
    @Bind(R.id.dingdanlist)
    TextView dingdanlist;
    @Bind(R.id.alllayouttxt)
    TextView alllayouttxt;
    @Bind(R.id.alllayout)
    LinearLayout alllayout;
    @Bind(R.id.nopainlayouttxt)
    TextView nopainlayouttxt;
    @Bind(R.id.nopainlayout)
    LinearLayout nopainlayout;
    @Bind(R.id.waitsendlayouttxt)
    TextView waitsendlayouttxt;
    @Bind(R.id.waitsendlayout)
    LinearLayout waitsendlayout;
    @Bind(R.id.sendingtxt)
    TextView sendingtxt;
    @Bind(R.id.sending)
    LinearLayout sending;
    @Bind(R.id.finishlayouttxt)
    TextView finishlayouttxt;
    @Bind(R.id.finishlayout)
    LinearLayout finishlayout;
    @Bind(R.id.refundlayouttxt)
    TextView refundlayouttxt;
    @Bind(R.id.refundlayout)
    LinearLayout refundlayout;
    @Bind(R.id.indent_framelayout)
    FrameLayout indentFramelayout;
    private Context context;
    private FragmentManager fragmentManager;
    private Allfragment allfragment;
    private Finishfragment finishfragment;
    private Nopainfragment nopainfragment;
    private Refundfragment refundfragment;
    private Sendingfragment sendingfragment;
    private Waitsendfragment waitsendfragment;
    public Indentfragment() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.indent_layout, container, false);
        ButterKnife.bind(this, view);
        fragmentManager = getChildFragmentManager();
        init();
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
    private void init(){
        setChooseItem(0);
        alllayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(0);
            }
        });
        nopainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(1);
            }
        });
        waitsendlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(2);
            }
        });
        sending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(3);
            }
        });
        finishlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(4);
            }
        });
        refundlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setChooseItem(5);
            }
        });
    }
    public void setChooseItem(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        clear();
        hideFragments(fragmentTransaction);
        switch (index) {
            case 0:
                alllayouttxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (allfragment == null) {
                    // 如果loveCarFragment为空，则创建一个并添加到界面上
                    allfragment = new Allfragment();
                    fragmentTransaction.add(R.id.indent_framelayout, allfragment);
                } else {
                    fragmentTransaction.show(allfragment);
                }
                break;

            case 1:
                nopainlayouttxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (nopainfragment == null) {
                    nopainfragment = new Nopainfragment();
                    fragmentTransaction.add(R.id.indent_framelayout, nopainfragment);
                } else {
                    fragmentTransaction.show(nopainfragment);
                }
                break;

            case 2:
                waitsendlayouttxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (waitsendfragment == null) {
                    waitsendfragment = new Waitsendfragment();
                    fragmentTransaction.add(R.id.indent_framelayout, waitsendfragment);
                } else {
                    fragmentTransaction.show(waitsendfragment);
//                    monitorFragment.onResume();
                }
                break;

            case 3:
                sendingtxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (sendingfragment == null) {
                    sendingfragment = new Sendingfragment();
                    fragmentTransaction.add(R.id.indent_framelayout, sendingfragment);
                } else {
                    fragmentTransaction.show(sendingfragment);
//                    serviceFragment.onResume();
                }
                break;
            case 4:
                finishlayouttxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (finishfragment == null) {
                    finishfragment = new Finishfragment();
                    fragmentTransaction.add(R.id.indent_framelayout, finishfragment);
                } else {
                    fragmentTransaction.show(finishfragment);
//                    serviceFragment.onResume();
                }
                break;
            case 5:
                refundlayouttxt.setTextColor(getResources().getColor(R.color.juice));
                //判断是否存在并创建或显示
                if (refundfragment == null) {
                    refundfragment = new Refundfragment();
                    fragmentTransaction.add(R.id.indent_framelayout, refundfragment);
                } else {
                    fragmentTransaction.show(refundfragment);
//                    serviceFragment.onResume();
                }
                break;


        }
        fragmentTransaction.commitAllowingStateLoss();
    }
    //隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (allfragment != null) {
            fragmentTransaction.hide(allfragment);
        }
        if (finishfragment != null) {
            fragmentTransaction.hide(finishfragment);
        }
        if (nopainfragment != null) {
            fragmentTransaction.hide(nopainfragment);
        }
        if (refundfragment != null) {
            fragmentTransaction.hide(refundfragment);
        }
        if (sendingfragment != null) {
            fragmentTransaction.hide(sendingfragment);
        }
        if (waitsendfragment != null) {
            fragmentTransaction.hide(waitsendfragment);
        }
    }
    public void clear(){
        alllayouttxt.setTextColor(getResources().getColor(R.color.nomal));
        finishlayouttxt.setTextColor(getResources().getColor(R.color.nomal));
        nopainlayouttxt.setTextColor(getResources().getColor(R.color.nomal));
        refundlayouttxt.setTextColor(getResources().getColor(R.color.nomal));
        sendingtxt.setTextColor(getResources().getColor(R.color.nomal));
        waitsendlayouttxt.setTextColor(getResources().getColor(R.color.nomal));

    }

}
