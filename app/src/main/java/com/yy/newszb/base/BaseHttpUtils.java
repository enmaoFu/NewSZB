package com.yy.newszb.base;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * 封装网络请求
 * @author fuenmao
 *
 */
public class BaseHttpUtils {

	private static AsyncHttpClient client = new AsyncHttpClient();// 实例化对象

	/**
	 * 配置参数
	 */
	static {
		client.setTimeout(10000);// 设置超时时间,默认为10S
	}

	/**
	 * 用一个完整url获取一个string对象
	 *
	 * @param urlString
	 * @param res
	 */
	public static void post(String urlString, AsyncHttpResponseHandler res) {
		client.post(urlString, res);
	}

	/**
	 * 带参数的获取String对象
	 *
	 * @param urlString
	 *            地址
	 * @param params
	 *            参数
	 * @param res
	 *            处理的消息对象
	 */
	public static void post(String urlString, RequestParams params,AsyncHttpResponseHandler res) {
		client.post(urlString, params, res);
	}

	/**
	 * 不带参数的 获取json对象或者数组
	 *
	 * @param urlString
	 * @param res
	 */
	public static void post(String urlString, JsonHttpResponseHandler res) {
		client.post(urlString, res);
	}

	/**
	 * 带参数的 获取json对象或者数组
	 *
	 * @param urlString
	 * @param params
	 * @param res
	 */
	public static void post(String urlString, RequestParams params,
							JsonHttpResponseHandler res) // 带参数，获取json对象或者数组
	{
		client.post(urlString, params, res);
	}

	/**
	 * 下载数据使用
	 *
	 * @param url
	 * @param bHandler
	 *            下载数据使用，会返回byte数据
	 */
	public static void post(String url, BinaryHttpResponseHandler bHandler) {
		client.post(url, bHandler);
	}

	/**
	 * 下载数据使用
	 *
	 * @param url
	 * @param bHandler
	 * 			下载数据使用，会返回byte数据
	 */
	public static void get(String url, BinaryHttpResponseHandler bHandler) {
		client.get(url, bHandler);
	}

	/**
	 * 返回网络请求对象
	 *
	 * @return
	 */
	public static AsyncHttpClient getClient() {

		return client;

	}

	/**
	 * GET请求带参数，String返回类型
	 *
	 * @param urlString
	 * @param params
	 * @param res
	 */
	public static void get(String urlString, RequestParams params,
						   AsyncHttpResponseHandler res) {

		client.get(urlString, params, res);

	}

	public static void get(String strUrl, AsyncHttpResponseHandler handler) {

		client.get(strUrl, handler);

	}
}
