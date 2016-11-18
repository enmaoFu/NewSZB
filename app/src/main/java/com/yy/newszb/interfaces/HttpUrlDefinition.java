package com.yy.newszb.interfaces;

/**
 * HTTP网络连接地址接口类
 * @author fuenmao
 *
 */
public interface HttpUrlDefinition {

	String IP = "http://61.54.5.114:8080/index.php/Doctor/Jk/";
	String IMAGE_IP = "http://61.54.5.114:8080/public/ecg/";

	/**
	 * 登录
	 */
	String URL_LOGIN = IP + "Index";

	/**
	 * 通用心电Listview
	 */
	String URL_PUBLIC_LISTVIEW = IP + "list_data";

	/**
	 * 通用心电详情
	 */
	String URL_PUBLIC_LISTVIEW_DETAILS = IP + "data";

	/**
	 * 发起预诊
	 */
	String URL_SEND = IP + "send";

}
