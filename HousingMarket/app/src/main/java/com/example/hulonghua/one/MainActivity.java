package com.example.hulonghua.one;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class MainActivity extends Activity {
    @Bind(R.id.register)
    TextView register;
    @Bind(R.id.region)
    TextView region;
    @Bind(R.id.phonenumber)
    EditText phonenumber;
    @Bind(R.id.verify)
    TextView verify;
    @Bind(R.id.verifynumber)
    EditText verifynumber;
    @Bind(R.id.getverify)
    Button getverify;
    @Bind(R.id.intentbt)
    Button intentbt;
    public Handler handler;
    public int id;
    public Intent intent;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = MainActivity.this;
        init();


    }
    private void init(){
       initSMSSDK();
       getverify.setOnClickListener(new VerifyOnClickListener());
        intentbt.setOnClickListener(new OnClickListenerIntent());
    }

    public class OnClickListenerIntent implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            /*handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    id = msg.arg1;
                }
            };
            if(id ==SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrueMainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(MainActivity.this,"验证码错误",Toast.LENGTH_SHORT);
            }*/
            SMSSDK.submitVerificationCode("86", phonenumber.getText().toString(), verifynumber.getText().toString());
            Log.i("message","verifynumber.tostring= "+verifynumber.getText().toString());
        }
    }
    public class VerifyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(phonenumber.getText().toString().length()<10 || phonenumber.getText().toString().isEmpty() ||
                    phonenumber.getText().toString().length()>11){
                Toast.makeText(MainActivity.this,"你输入的号码格式不对",Toast.LENGTH_SHORT).show();
            }else{
                SMSSDK.getVerificationCode("86", phonenumber.getText().toString());
                getverify.setClickable(false);
                getverify.setBackgroundColor(getResources().getColor(R.color.huise));
                new CountDownTimer(1000 * 60, 1000) {

                    @Override
                    public void onTick(long l) {
                        String s = "重新获取(" + (l / 1000) + ")";
                        getverify.setText(s);
                    }

                    @Override
                    public void onFinish() {
                        getverify.setClickable(true);
                        getverify.setBackgroundColor(getResources().getColor(R.color.juice));
                        getverify.setText("获取验证码");
                    }
                }.start();
            }
        }
    }
    private Handler mHandler = new MyHandler(this);
    private final static int SMSSID = 0;

    private static class MyHandler extends Handler {

        private final WeakReference<MainActivity> mActivity;

        public MyHandler(MainActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final MainActivity activity = mActivity.get();
            Log.i("message","start?");
            if (activity != null) {
                switch (msg.what) {
                    case SMSSID:
                        int event = msg.arg1;
                        int result = msg.arg2;
                        Log.i("message","event= "+event);
                        Log.i("message","result= "+result);
                        Object data = msg.obj;
                        Log.i("message","data= "+data);
                        if (result == SMSSDK.RESULT_COMPLETE) {

                                //短信注册成功后，返回MainActivity
                                Log.i("message","start else");
                                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {   //提交验证码成功
//                                activity.userLogin();
                                    activity.intent = new Intent(activity, TrueMainActivity.class);
                                    activity.startActivity(activity.intent);
                                    activity.exit();

                                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                                } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {   //返回支持发送验证码的国家列表
                                }
                            }

                         else {
                            Log.i("message","start noresult");
                            if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                            } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                                Toast.makeText(activity,"验证码错误",Toast.LENGTH_SHORT);
                            }
                            Toast.makeText(activity,"验证码错误",Toast.LENGTH_SHORT);
                        }
                        break;
                    default:
                        break;
                }
            }
        }


    }
    public EventHandler eh;
    private void initSMSSDK(){
        Log.i("aaa","do");
        SMSSDK.initSDK(this,"1de870b7fa261","0eac54f7a46d3818b134d374afd3a3e7");
         eh=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {
                Message message = new Message();
                message.arg1 = event;
                Log.i("aaa","message"+message.arg1);
                message.arg2 = result;
                message.obj = data;
                mHandler.sendMessage(message);

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        SMSSDK.registerEventHandler(eh);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SMSSDK.unregisterEventHandler(eh);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
    private void exit() {
        MainActivity.this.finish();
    }
}
