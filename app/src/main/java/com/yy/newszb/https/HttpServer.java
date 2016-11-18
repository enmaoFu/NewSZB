package com.yy.newszb.https;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.yy.newszb.base.BaseHttpUtils;
import com.yy.newszb.dialogs.WaitDialog;

/**
 * 请求服务器基础类
 * @author fuenmao
 *
 */
public class HttpServer {

	private Context context;

	private WaitDialog dialog;

	public HttpServer(Context context) {
		this.context = context;
		//this.dialog = new WaitDialog(context);
	}

	/**
	 * 显示对话框
	 */
	private void showDialog() {
		if (dialog != null) {
			dialog.dismiss();
			dialog = null;
		}
		if (dialog == null) {
			dialog = new WaitDialog(context);
			dialog.show();
		}
	}

	/**
	 * 隐藏对话框
	 */
	private void hideDialog() {
		if (dialog != null) {
			dialog.dismiss();
		}
	}

	/**
	 * post请求方法
	 * @param url
	 * 			地址
	 * @param params
	 * 			参数
	 * @param handler
	 * 			消息对象
	 * @param TAG
	 * 			返回的信息标示
	 */
	public void postServer(String url, final RequestParams params,final Handler handler, final String TAG) {

		BaseHttpUtils.post(url, params, new AsyncHttpResponseHandler() {

			/** 数据请求成功后操作 */
			@Override
			public void onSuccess(String content) {
				/** 回传数据到activity页面 */
				Message msg = new Message();
				msg.what = 1;
				msg.obj = content;
				handler.sendMessage(msg);
				//Log.v(TAG, content);
				hideDialog();
			}

			/** 请求失败 */
			@Override
			public void onFailure(Throwable error) {
				Message msg = new Message();
				msg.what = 999;
				msg.obj = error.toString();
				handler.sendMessage(msg);
				//Log.v(TAG, error.toString());
				hideDialog();
			}

			/** 开始 */
			@Override
			public void onStart() {
				showDialog();
				Log.v(TAG, params.toString());
			}

			@Override
			public void onFinish() {

			}

		});

	}

	/**
	 * get请求方法
	 *
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @param handler
	 *            消息对象
	 * @param TAG
	 *            返回的信息的标示
	 */
	public void getServer(String url, final RequestParams params,
						  final Handler handler, final String TAG) {
		BaseHttpUtils.get(url, params, new AsyncHttpResponseHandler() {

			/** 数据请求成功后操作 */
			@Override
			public void onSuccess(String content) {
				/** 回传数据到activity页面 */
				Message msg = new Message();
				msg.what = 1;
				msg.obj = content;
				handler.sendMessage(msg);
				//Log.v(TAG, content);
				hideDialog();
			}

			/** 请求失败 */
			@Override
			public void onFailure(Throwable error) {
				Message msg = new Message();
				msg.what = 999;
				msg.obj = error.toString();
				handler.sendMessage(msg);
				//Log.v(TAG, error.toString());
				hideDialog();
			}

			/** 开始 */
			@Override
			public void onStart() {
				showDialog();
				Log.v(TAG, params.toString());
			}

			@Override
			public void onFinish() {

			}
		});
	}

	/**
	 * post请求方法
	 *
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @param handler
	 *            消息对象
	 * @param TAG
	 *            返回的信息的标示
	 */
	public void PostNoDialogServer(String url, final RequestParams params,final Handler handler, final String TAG) {
		BaseHttpUtils.post(url, params, new AsyncHttpResponseHandler(){

			/** 数据请求成功后操作 */
			@Override
			public void onSuccess(String content) {
				/** 回传数据到activity页面 */
				Message msg = new Message();
				msg.what = 1;
				msg.obj = content;
				handler.sendMessage(msg);
				//Log.v(TAG, content);
			}

			/** 请求失败 */
			@Override
			public void onFailure(Throwable error) {
				Message msg = new Message();
				msg.what = 999;
				msg.obj = error.toString();
				handler.sendMessage(msg);
				//Log.v(TAG, error.toString());
			}

			/** 开始 */
			@Override
			public void onStart() {
				Log.v(TAG, params.toString());
			}

			@Override
			public void onFinish() {

			}

		});
	}

	/**
	 * get请求方法
	 *
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @param handler
	 *            消息对象
	 * @param TAG
	 *            返回的信息的标示
	 */
	public void GetNoDialogServer(String url, final RequestParams params,final Handler handler, final String TAG) {
		BaseHttpUtils.get(url, params, new AsyncHttpResponseHandler() {

			/** 数据请求成功后操作 */
			@Override
			public void onSuccess(String content) {
				/** 回传数据到activity页面 */
				Message msg = new Message();
				msg.what = 1;
				msg.obj = content;
				handler.sendMessage(msg);
				//Log.v(TAG, content);
			}

			/** 请求失败 */
			@Override
			public void onFailure(Throwable error) {
				Message msg = new Message();
				msg.what = 999;
				msg.obj = error.toString();
				handler.sendMessage(msg);
				//Log.v(TAG, error.toString());
			}

			/** 开始 */
			@Override
			public void onStart() {
				Log.v(TAG, params.toString());
			}

			@Override
			public void onFinish() {

			}
		});
	}

	/**
	 * get 上传方法
	 *
	 * @param url
	 * 			地址
	 * @param params
	 * 			参数
	 * @param handler
	 * 			消息对象
	 * @param TAG
	 * 			返回的信息的标示
	 */
	public void getUpLoadImage(String url,final RequestParams params,final Handler handler, final String TAG){

		BaseHttpUtils.get(url, params, new AsyncHttpResponseHandler(){

			/**
			 * 数据请求成功后操作 
			 */
			@Override
			public void onSuccess(String content) {
				/** 回传数据到activity页面 */
				Message msg = new Message();
				msg.what = 1;
				msg.obj = content;
				handler.sendMessage(msg);
			}

			/**
			 * 请求失败
			 */
			@Override
			public void onFailure(Throwable error) {
				Message msg = new Message();
				msg.what = 999;
				msg.obj = error.toString();
				handler.sendMessage(msg);
			}

			/**
			 * 开始
			 */
			public void onStart(){
				Log.v(TAG, params.toString());
			};

			@Override
			public void onFinish(){

			}
		});
	}

	/**
	 * post 上传方法
	 *
	 * @param url
	 * 			地址
	 * @param params
	 * 			参数
	 * @param handler
	 * 			消息对象
	 * @param TAG
	 * 			返回的信息的标示
	 */
	public void postUpLoadImage(String url,final RequestParams params,final Handler handler, final String TAG){

		BaseHttpUtils.post(url, params, new AsyncHttpResponseHandler(){

			/**
			 * 数据请求成功后操作 
			 */
			@Override
			public void onSuccess(String content) {
				/** 回传数据到activity页面 */
				Message msg = new Message();
				msg.what = 1;
				msg.obj = content;
				handler.sendMessage(msg);
				hideDialog();
			}

			/**
			 * 请求失败
			 */
			@Override
			public void onFailure(Throwable error) {
				Message msg = new Message();
				msg.what = 999;
				msg.obj = error.toString();
				handler.sendMessage(msg);
				hideDialog();
			}

			/**
			 * 开始
			 */
			public void onStart(){
				showDialog();
				Log.v(TAG, params.toString());
			};

			@Override
			public void onFinish(){

			}
		});
	}
}
