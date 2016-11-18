package com.yy.newszb.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 自定义Gridview 重写其高度
 * @author fuenmao
 *
 */
public class LyGridView extends GridView {
	public LyGridView(Context context) {
		super(context);

	}

	public LyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
