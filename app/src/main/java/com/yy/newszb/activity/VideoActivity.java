package com.yy.newszb.activity;

import android.net.Uri;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

import com.yy.newszb.base.BaseActivity;

/**
 * 视频播放页面
 * @author fuenmao
 */
public class VideoActivity extends BaseActivity{

    private VideoView videoView;

    /**
     * 初始化视图
     */
    @Override
    protected void bindViews() {
        setContentView(R.layout.activity_video);
    }

    /**
     * 初始化组件
     */
    @Override
    protected void initControl() {
        videoView = (VideoView) findViewById(R.id.videoView);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        videoView.setMediaController(new MediaController(this));
        Uri videoUri = Uri.parse(Environment.getExternalStorageDirectory()
                .getPath() + "/DCIM/Camera/VID_20160616_101845.3gp");
       // Log.v("print", Uri.parse(Environment.getExternalStorageDirectory().getPath()) + "/DCIM/Camera/VID_20160616_101845.3gp");
        videoView.setVideoURI(videoUri);
        videoView.start();
    }

    /**
     * 初始化标题栏
     */
    @Override
    protected void initActionBar() {

    }
}
