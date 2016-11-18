package com.yy.newszb.fragments;

import android.widget.TextView;

import com.yy.newszb.activity.R;
import com.yy.newszb.base.BaseFragment;
import com.yy.newszb.utils.NetworkJudge;
import com.yy.newszb.utils.UpdateManager;

/**
 * 一键升级页面
 * @author fuenmao
 */
public class FiveFragment extends BaseFragment{

    private NetworkJudge net;//判断网络工具类

    private TextView texts;//提示

    private TextView d;

    private UpdateManager mUpdateManager;

    /**
     * 初始化视图
     */
    @Override
    protected int bindViews() {
        return R.layout.fragment_five;
    }

    /**
     * 初始化视图组件
     */
    @Override
    protected void initControl() {
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 初始化标题栏
     */
    @Override
    protected void initActionBar() {
        // TODO Auto-generated method stub

    }

}
