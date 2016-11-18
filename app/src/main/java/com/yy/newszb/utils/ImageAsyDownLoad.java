package com.yy.newszb.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.yy.newszb.activity.R;

/**
 * 图片异步加载框架类
 * @author fuenmao
 *
 */
public class ImageAsyDownLoad {

	private ImageLoader imageLoader = ImageLoader.getInstance();
	private DisplayImageOptions options;
	public ImageAsyDownLoad(Context content){
		imageLoader.init(ImageLoaderConfiguration.createDefault(content));//初始化图片异步加载  不然会报错
	}
	/**
	 *
	 * @param uri 图片地址
	 * @param imageView 要显示的view
	 */
	public void loadBitmap(String uri, ImageView imageView) {
		if (imageView == null)
			return;
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.mipmap.ic_launcher)// 加载中显示的图片
				.showImageForEmptyUri(R.mipmap.ic_launcher)// 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.mipmap.ic_launcher)// 加载失败时候显示的图片
				.cacheInMemory(true)// 设置下载的图片是否缓存在内存中
				.imageScaleType(ImageScaleType.EXACTLY)
						/**
						 * EXACTLY :图像将完全按比例缩小的目标大小 EXACTLY_STRETCHED:图片会缩放到目标大小完全
						 * IN_SAMPLE_INT:图像将被二次采样的整数倍
						 * IN_SAMPLE_POWER_OF_2:图片将降低2倍，直到下一减少步骤，使图像更小的目标大小 NONE:图片不会调整
						 */
				.bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型 EXACTLY 设置为RGB565比起默认的ARGB_8888要节省大量的内存
				.displayer(new RoundedBitmapDisplayer(0))// 是否设置为圆角，弧度为多少
				.displayer(new FadeInBitmapDisplayer(500))// 是否图片加载好后渐入的动画时间
				.delayBeforeLoading(100)//载入图片前稍做延时可以提高整体滑动的流畅度
				.cacheInMemory(true)  //加载图片时会在内存中加载缓存
				.cacheOnDisc(true)   //加载图片时会在磁盘中加载缓存
				.build();
		imageLoader.displayImage(uri, imageView, options);
	}

	/**
	 * 清除缓存中的图片
	 */
	public void clearImage() {
		imageLoader.clearMemoryCache();// 清除内存中缓存
		imageLoader.clearDiskCache();// 清除SD中缓存
	}

}
