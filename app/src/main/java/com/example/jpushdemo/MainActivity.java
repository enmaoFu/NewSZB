package com.example.jpushdemo;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.yy.newszb.activity.R;

import cn.jpush.android.api.InstrumentedActivity;
import cn.jpush.android.api.JPushInterface;



public class MainActivity extends InstrumentedActivity implements OnClickListener{

	private Button mInit;
	/*private Button mSetting;
	private Button mStopPush;
	private Button mResumePush;
	private Button mGetRid;
	private TextView mRegId;
	private EditText msgText;*/
	
	public static boolean isForeground = false;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();   
		registerMessageReceiver();  // used for receive msg
	}
	
	private void initView(){

	    mInit = (Button)findViewById(R.id.init);
		mInit.setOnClickListener(this);
		
	}

	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.init:
			init();
			break;
		/*case R.id.setting:
			Intent intent = new Intent(MainActivity.this, PushSetActivity.class);
			startActivity(intent);
			break;
		case R.id.stopPush:
			JPushInterface.stopPush(getApplicationContext());
			break;
		case R.id.resumePush:
			JPushInterface.resumePush(getApplicationContext());
			break;
		case R.id.getRegistrationId:
			String rid = JPushInterface.getRegistrationID(getApplicationContext());
			if (!rid.isEmpty()) {
				mRegId.setText("RegId:" + rid);
			} else {
				Toast.makeText(this, "Get registration fail, JPush init failed!", Toast.LENGTH_SHORT).show();
			}
			break;*/
		}
	}
	
	// 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
	private void init(){
		 JPushInterface.init(getApplicationContext());
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
	
	/*private void setCostomMsg(String msg){
		 if (null != msgText) {
			 msgText.setText(msg);
			 msgText.setVisibility(android.view.View.VISIBLE);
         }
	}*/

}