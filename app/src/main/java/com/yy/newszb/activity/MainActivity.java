package com.yy.newszb.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.jpushdemo.ExampleUtil;
import com.yy.newszb.base.BaseFragmentActivity;
import com.yy.newszb.fragments.FiveFragment;
import com.yy.newszb.fragments.OneFragment;
import com.yy.newszb.fragments.ThreeFragment;
import com.yy.newszb.fragments.TwoFragment;
import com.yy.newszb.utils.Preference;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;


public class MainActivity extends BaseFragmentActivity implements View.OnClickListener{

    private static boolean mBackKeyPressed = false;//记录是否有首次按键

    private RelativeLayout one,two,three,five;//左边菜单的布局

    private FrameLayout contentf;

    private FragmentManager fm;

    private OneFragment of;//心电列表fragemnt

    private TwoFragment tf;//心电预诊fragment

    private ThreeFragment ttf;//远程心电fragment

    private FiveFragment fff;//一键升级fragment

    private LinearLayout.LayoutParams linearParams1;
    private LinearLayout.LayoutParams linearParams2;
    private LinearLayout.LayoutParams linearParams3;
    private LinearLayout.LayoutParams linearParams5;

    private Preference yp;//保存数据到本地

    private Button mInit;
	/*private Button mSetting;
	private Button mStopPush;
	private Button mResumePush;
	private Button mGetRid;
	private TextView mRegId;
	private EditText msgText;*/

    public static boolean isForeground = false;

    /**
     * 初始化视图
     */
    @Override
    protected void bindViews() {
        setContentView(R.layout.activity_main);
    }

    /**
     * 初始化组件
     */
    @Override
    protected void initControl() {

        /*mInit = (Button)findViewById(R.id.init);
        mInit.setOnClickListener(this);*/

        one = (RelativeLayout)findViewById(R.id.one);
        two = (RelativeLayout)findViewById(R.id.two);
        three = (RelativeLayout)findViewById(R.id.three);
        five = (RelativeLayout)findViewById(R.id.five);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        five.setOnClickListener(this);

    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        init();
        registerMessageReceiver();  // used for receive msg

        fm = getSupportFragmentManager();
        yp = new Preference(MainActivity.this);

        linearParams1 = (LinearLayout.LayoutParams) one.getLayoutParams();
        linearParams2 = (LinearLayout.LayoutParams) two.getLayoutParams();
        linearParams3 = (LinearLayout.LayoutParams) three.getLayoutParams();
        linearParams5 = (LinearLayout.LayoutParams) five.getLayoutParams();

        selectTab(0);

    }

    /**
     * 初始化标题栏
     */
    @Override
    protected void initActionBar() {

    }

    /**
     * 事件监听
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.one:
                selectTab(0);
                break;

            case R.id.two:
                selectTab(1);
                break;

            case R.id.three:
                selectTab(2);
                break;

            case R.id.five:
                selectTab(3);
                break;

            case R.id.init:
                init();
                break;
        }

    }

    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
    private void init(){
        //获得意图
        Intent intent = getIntent();
        //读取数据
        String bm = intent.getStringExtra("bm");
        Log.v("print",bm+"别名");
        JPushInterface.init(getApplicationContext());
        JPushInterface.setAlias(this, bm, new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                if(i == 0){
                    yp.setString("bm",s);//存别名到本地
                }
                Log.v("print","iiiiiiiiiiiiiiiiiiiiiiii"+i+"");
                Log.v("print","ssssssssssssssssssssssss"+s);
            }
        });
    }


    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }

    //for receive customer msg from jpush server
    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                String messge = intent.getStringExtra(KEY_MESSAGE);
                String extras = intent.getStringExtra(KEY_EXTRAS);
                StringBuilder showMsg = new StringBuilder();
                showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                if (!ExampleUtil.isEmpty(extras)) {
                    showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                }
                //setCostomMsg(showMsg.toString());
            }
        }
    }

    /**
     * 菜单切换
     * @param postion 选择了第几个fragement
     */
    public void selectTab(int postion){

        FragmentTransaction ft = fm.beginTransaction();

        switch (postion) {
            case 0:
                if(of == null){
                    of = new OneFragment();
                    ft.replace(R.id.content_frame, of);
                }else{
                    ft.replace(R.id.content_frame, of);
                }

                // 设置控件当前的布局参数
                linearParams1.width = 180;
                linearParams1.height = 105;

                linearParams2.width = 170;
                linearParams2.height = 105;

                linearParams3.width = 170;
                linearParams3.height = 105;

                linearParams5.width = 170;
                linearParams5.height = 105;

                one.setLayoutParams(linearParams1); // 使设置好的布局参数应用到控件
                two.setLayoutParams(linearParams2); // 使设置好的布局参数应用到控件
                three.setLayoutParams(linearParams3); // 使设置好的布局参数应用到控件
                five.setLayoutParams(linearParams5); // 使设置好的布局参数应用到控件

                break;

            case 1:
                if(tf == null){
                    tf = new TwoFragment();
                    ft.replace(R.id.content_frame, tf);
                }else{
                    ft.replace(R.id.content_frame, tf);
                }

                // 设置控件当前的布局参数
                linearParams1.width = 170;
                linearParams1.height = 105;

                linearParams2.width = 180;
                linearParams2.height = 105;

                linearParams3.width = 170;
                linearParams3.height = 105;

                linearParams5.width = 170;
                linearParams5.height = 105;

                one.setLayoutParams(linearParams1); // 使设置好的布局参数应用到控件
                two.setLayoutParams(linearParams2); // 使设置好的布局参数应用到控件
                three.setLayoutParams(linearParams3); // 使设置好的布局参数应用到控件
                five.setLayoutParams(linearParams5); // 使设置好的布局参数应用到控件

                break;

            case 2:

                if(ttf == null){
                    ttf = new ThreeFragment();
                    ft.replace(R.id.content_frame, ttf);
                }else{
                    ft.replace(R.id.content_frame, ttf);
                }

                // 设置控件当前的布局参数
                linearParams1.width = 170;
                linearParams1.height = 105;

                linearParams2.width = 170;
                linearParams2.height = 105;

                linearParams3.width = 180;
                linearParams3.height = 105;

                linearParams5.width = 170;
                linearParams5.height = 105;

                one.setLayoutParams(linearParams1); // 使设置好的布局参数应用到控件
                two.setLayoutParams(linearParams2); // 使设置好的布局参数应用到控件
                three.setLayoutParams(linearParams3); // 使设置好的布局参数应用到控件
                five.setLayoutParams(linearParams5); // 使设置好的布局参数应用到控件

                break;

            case 3:

                if(fff == null){
                    fff = new FiveFragment();
                    ft.replace(R.id.content_frame, fff);
                }else{
                    ft.replace(R.id.content_frame, fff);
                }

                // 设置控件当前的布局参数
                linearParams1.width = 170;
                linearParams1.height = 105;

                linearParams2.width = 170;
                linearParams2.height = 105;

                linearParams3.width = 170;
                linearParams3.height = 105;

                linearParams5.width = 180;
                linearParams5.height = 105;

                one.setLayoutParams(linearParams1); // 使设置好的布局参数应用到控件
                two.setLayoutParams(linearParams2); // 使设置好的布局参数应用到控件
                three.setLayoutParams(linearParams3); // 使设置好的布局参数应用到控件
                five.setLayoutParams(linearParams5); // 使设置好的布局参数应用到控件

                break;
        }

        ft.commit();

    }

    /**
     * 监听后退键，点击两次退出APP
     */
    @Override
    public void onBackPressed() {
        if(!mBackKeyPressed){
            showToast("再按一次退出程序");
            mBackKeyPressed = true;
            //延时两秒，如果超出则擦除第一次按键记录
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    mBackKeyPressed = false;
                }
            }, 2000);
        }else{
            //退出程序
            yp.removePreference();
            this.finish();
            System.exit(0);
        }
    }

}
