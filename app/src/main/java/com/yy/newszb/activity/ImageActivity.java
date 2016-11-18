package com.yy.newszb.activity;

import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.yy.newszb.base.BaseActivity;
import com.yy.newszb.interfaces.HttpUrlDefinition;
import com.yy.newszb.utils.ImageAsyDownLoad;

import java.util.List;

/**
 * 照片查看详情
 * @author fuenmao
 */
public class ImageActivity extends BaseActivity implements GestureDetector.OnGestureListener,HttpUrlDefinition {

    private ViewFlipper flipper;
    private GestureDetector detector;
    private ImageAsyDownLoad iadl;
    private ImageView left_img,center_img;//标题栏图片

    private String qonimg;
    private List<String> qimglist;

    private final String URL= "http://119.84.8.146:8888/Public/ecg";

    /**
     * 初始化视图
     */
    @Override
    protected void bindViews() {
        setContentView(R.layout.school_person_album_details_activity_xq);
    }

    /**
     * 初始化组件
     */
    @Override
    protected void initControl() {

    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
    //获取传过来的数据
        Intent intent=getIntent();
        qonimg = intent.getStringExtra("qonimg");
        qimglist = (List<String>)getIntent().getSerializableExtra("qimglist");

        iadl = new ImageAsyDownLoad(this);
        detector = new GestureDetector(this);
        flipper = (ViewFlipper) this.findViewById(R.id.ViewFlipper1);

        flipper.addView(addImageView(IMAGE_IP+"/"+qonimg));
        for(int i = 0; i < qimglist.size(); i++){
            flipper.addView(addImageView(IMAGE_IP+"/"+qimglist.get(i)));
        }
    }

    private View addImageView(String image) {
        ImageView iv = new ImageView(this);
        //iv.setImageResource(id);
        iadl.loadBitmap(image, iv);
        return iv;
    }

    /**
     * 初始化标题栏
     */
    @Override
    protected void initActionBar() {

    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX() - e2.getX() > 120) {
            this.flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
            this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
            this.flipper.showNext();
            return true;
        } else if (e1.getX() - e2.getX() < -120) {
            this.flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
            this.flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
            this.flipper.showPrevious();
            return true;
        }

        return false;
    }
}
