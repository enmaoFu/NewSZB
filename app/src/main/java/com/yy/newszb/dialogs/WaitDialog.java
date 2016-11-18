package com.yy.newszb.dialogs;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.yy.newszb.activity.R;


/**
 * 自定义对话框  旋转过渡
 * @author fuenmao
 *
 */
public class WaitDialog extends ProgressDialog {

	private ImageView dialog_iv;
	private AnimationDrawable animationDrawable;
	private Context context;

	public WaitDialog(Context context) {
		super(context, R.style.waitDialog);
		setCanceledOnTouchOutside(false);
		this.context=context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		initData();
	}

	private void initData() {
		dialog_iv.setBackgroundResource(R.anim.dialog_animation);
		animationDrawable = (AnimationDrawable) dialog_iv.getBackground();
		animationDrawable.start();
	}

	private void initView() {
		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
		lp.width = (int) (d.widthPixels * 0.3); // 高度设置为屏幕的0.6
		lp.height=(int) (d.widthPixels * 0.3);
		lp.alpha=0.5f;
		dialogWindow.setAttributes(lp);

		setContentView(R.layout.dialog_layout);
		dialog_iv = (ImageView) findViewById(R.id.dialog_iv);
	}
}
