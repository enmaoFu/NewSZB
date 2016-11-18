package com.yy.newszb.activity;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.yy.newszb.base.BaseActivity;
import com.yy.newszb.https.HttpServer;
import com.yy.newszb.interfaces.HttpUrlDefinition;
import com.yy.newszb.json.LoginJsonEntity;
import com.yy.newszb.utils.NetworkJudge;
import com.yy.newszb.utils.Preference;

import cn.jpush.android.api.JPushInterface;

/**
 * 登陆页面
 * @author fuenmao
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener,HttpUrlDefinition{

    private EditText ed_user;//用户名
    private EditText ed_pwd;//密码
    private Button but_login;//登陆按钮

    private NetworkJudge net;//判断网络工具类
    private Preference yp;//保存数据到本地
    private String user;

    private Intent intent = new Intent();

    /**
     * 初始化视图
     */
    @Override
    protected void bindViews() {
        setContentView(R.layout.activity_login);
    }

    /**
     * 初始化组件
     */
    @Override
    protected void initControl() {
        ed_user = (EditText)findViewById(R.id.ed_user);
        ed_pwd = (EditText)findViewById(R.id.ed_pwd);
        but_login = (Button)findViewById(R.id.but_login);
        but_login.setOnClickListener(this);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        yp = new Preference(LoginActivity.this);
        String id = getIntent().getStringExtra("xinx");
        Log.v("print",id+"````````////////////```````");
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

        switch (v.getId()){

            case R.id.but_login:
                user = ed_user.getText().toString().trim();
                String pwd = ed_pwd.getText().toString().trim();
                if(user.equals("")){
                    showToast("用户名不能为空");
                }else if(pwd.equals("")){
                    showToast("密码不能为空");
                }else{
                    if(net == null){
                        net = new NetworkJudge(this);
                    }
                    boolean flag = net.checkNetworkAvailable();
                    if(flag == true){
                        HttpServer hs = new HttpServer(this);
                        RequestParams rp = new RequestParams();
                        rp.put("username",user);
                        rp.put("password",pwd);
                        hs.postServer(URL_LOGIN, rp, loginHandler, "print");
                    }else{
                        showToast("登录失败请检查网络");
                    }
                }
                break;
        }
    }

    /**
     * 登陆Handler消息异步
     */
    Handler loginHandler = new Handler(){

        public void handleMessage(android.os.Message msg){

            switch (msg.what) {
                case 1:
                    String text = msg.obj.toString();
                    Log.v("print", text);
                    if(!text.equals("")){
                        //gson解析
                        LoginJsonEntity lje = new Gson().fromJson(text, LoginJsonEntity.class);
                        int status = lje.getStatus();
                        if(status == 0){
                            String docterId = lje.getData().getId();
                            if(!docterId.equals("")){
                                yp.setString("docterId",docterId);
                                intent.setClass(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(LoginActivity.this,"返回数据错误，请联系技术支持",Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_LONG).show();
                            Log.v("print", "账号或密码错误");
                        }
                        Log.v("print", status + "");
                    }else{
                        showToast("登录失败请检查网络");
                    }
                    break;

                case 999:
                    String text1 = msg.obj.toString();
                    Log.v("print", text1);

                    break;
            }

        };

    };

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(LoginActivity.this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(LoginActivity.this);
    }
}
