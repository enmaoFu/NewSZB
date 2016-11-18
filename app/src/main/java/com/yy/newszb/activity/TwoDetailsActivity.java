package com.yy.newszb.activity;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.yy.newszb.base.BaseActivity;
import com.yy.newszb.https.HttpServer;
import com.yy.newszb.interfaces.HttpUrlDefinition;
import com.yy.newszb.json.Images;
import com.yy.newszb.json.OneListXqArrayJsonEntity;
import com.yy.newszb.json.OneListXqJsonEntity;
import com.yy.newszb.json.SendYz;
import com.yy.newszb.utils.ImageAsyDownLoad;
import com.yy.newszb.utils.NetworkJudge;
import com.yy.newszb.utils.Preference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 心电记录详情页面
 * @author fuenmao
 */
public class TwoDetailsActivity extends BaseActivity implements HttpUrlDefinition,View.OnClickListener{

    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;

    private TextView context;//心电指标
    private TextView context1;

    private Intent intent = new Intent();

    private String ys;

    private String uid;
    private String dids;
    private String time;
    private String sz_datetime;
    private String rr;
    private String p_r;
    private String qrs;
    private String qt;
    private String qtc;
    private String p_axis;
    private String qrs_axis;
    private String t_axis;
    private String rv5;
    private String sv1;
    private String rv5_sv1;
    private String hr;
    private String analysis_code;

    private ImageView fhimg1;
    private ImageView fhimg2;
    private ImageView fhimg3;
    private ImageView fhimg4;

    private final String URL= "http://119.84.8.146:8888/Public/ecg";

    private ImageAsyDownLoad iadl;

    private NetworkJudge net;//判断网络工具类
    private Preference yp;//保存数据到本地

    private List<String> datas = new ArrayList<String>();

    private Button fxs;
    private Button hq;
    private String id;
    private Button yzbut;
    private TextView yzjg;
    private String dataIdNew;
    private String key;
    private String type;
    //private TextView con;

    /**
     * 初始化视图
     */
    @Override
    protected void bindViews() {
        setContentView(R.layout.fragment_two_xq);
    }

    /**
     * 初始化组件
     */
    @Override
    protected void initControl() {
        context1 = (TextView)findViewById(R.id.context1);
        context = (TextView)findViewById(R.id.context);
        fhimg1 = (ImageView)findViewById(R.id.fhimg1);
        fhimg2 = (ImageView)findViewById(R.id.fhimg2);
        fhimg3 = (ImageView)findViewById(R.id.fhimg3);
        fhimg4 = (ImageView)findViewById(R.id.fhimg4);
        fhimg1.setOnClickListener(this);
        fhimg2.setOnClickListener(this);
        fhimg3.setOnClickListener(this);
        yzbut = (Button)findViewById(R.id.yzbut);
        yzjg = (TextView)findViewById(R.id.yzjg);
        yzbut.setOnClickListener(this);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        iadl = new ImageAsyDownLoad(this);
        Intent getIntent = this.getIntent();
        dataIdNew = getIntent.getExtras().getString("dataIdNew");
        key = getIntent.getExtras().getString("key");
        type = getIntent.getExtras().getString("type");
        getListviewDateils();
        if(key.equals("2")){
            yzbut.setVisibility(View.VISIBLE);
        }else if(key.equals("3")){
            yzjg.setVisibility(View.VISIBLE);
        }else{
            yzbut.setVisibility(View.GONE);
            yzjg.setVisibility(View.GONE);
        }
    }

    /**
     * 初始化标题栏
     */
    @Override
    protected void initActionBar() {

    }

    public void getListviewDateils(){

        if(net == null){
            net = new NetworkJudge(TwoDetailsActivity.this);
        }
        boolean flag = net.checkNetworkAvailable();
        if(flag == true){
            HttpServer hs = new HttpServer(TwoDetailsActivity.this);
            RequestParams rp = new RequestParams();
            rp.put("id",dataIdNew);
            rp.put("type",type);
            hs.postServer(URL_PUBLIC_LISTVIEW_DETAILS, rp, getListviewDateilsHandler, "print");
        }else{
            showToast("查询失败请检查网络");
        }

    }

    /**
     * Handler消息异步
     */
    Handler getListviewDateilsHandler = new Handler(){

        public void handleMessage(android.os.Message msg){

            switch (msg.what) {
                case 1:
                    String text = msg.obj.toString();
                    Log.v("print", text);
                    if(!text.equals("")){
                        OneListXqJsonEntity olje = new Gson().fromJson(text, OneListXqJsonEntity.class);
                        int status = olje.getStatus();
                        if(status == 0){
                            OneListXqArrayJsonEntity oneListXqJsonEntities = olje.getData();
                            Images images = olje.getImg();
                            context.setText("p_r  "+  oneListXqJsonEntities.getP_r()  +"  \n"+"qrs       "+  oneListXqJsonEntities.getQrs() +"\n"+"qt     "+  oneListXqJsonEntities.getQt()  +"\n"+"qtc        "+  oneListXqJsonEntities.getQtc()  +"\n"+"p_axis      "+  oneListXqJsonEntities.getP_axis()  +"\n"+"qrs_axis         "+  oneListXqJsonEntities.getQrs_axis());
                            context1.setText("t_axis       "+  oneListXqJsonEntities.getT_axis() +"            \n"+"rv5             "+oneListXqJsonEntities.getRv5()+"            \n"+"sv1            "+oneListXqJsonEntities.getSv1()+"         \n"+"rv5_sv1             "+oneListXqJsonEntities.getRv5_sv1()+"       \n"+"hr  "+oneListXqJsonEntities.getHr()+"     \n"+"analysis_desc            "+oneListXqJsonEntities.getAnalysis_desc());
                            iadl.loadBitmap(IMAGE_IP+images.getImg1(), fhimg1);
                            iadl.loadBitmap(IMAGE_IP+images.getImg2(), fhimg2);
                            iadl.loadBitmap(IMAGE_IP+images.getImg3(), fhimg3);
                            datas.add(images.getImg1());
                            datas.add(images.getImg2());
                            datas.add(images.getImg3());
                            if(!oneListXqJsonEntities.getResult().equals("")){
                                yzjg.setText(oneListXqJsonEntities.getResult());
                            }else{
                                yzjg.setText("暂时没有预诊的结果");
                            }
                        }
                    }else{
                        showToast("暂时没有心电数据");
                    }
                    break;

                case 999:
                    String text1 = msg.obj.toString();
                    Log.v("print", text1);
                    showToast("查询失败请检查网络");
                    break;
            }

        };

    };

    /**
     * 事件监听
     * @param v
     */
    @Override
    public void onClick(View v) {

        Intent intent = new Intent();

        switch (v.getId()){

            case R.id.fhimg1:
                intent.putExtra("qonimg", datas.get(0));
                intent.putExtra("qimglist", (Serializable)datas);
                intent.setClass(this, ImageActivity.class);
                startActivity(intent);
                break;

            case R.id.fhimg2:
                intent.putExtra("qonimg", datas.get(1));
                intent.putExtra("qimglist", (Serializable)datas);
                intent.setClass(this, ImageActivity.class);
                startActivity(intent);
                break;

            case R.id.fhimg3:
                intent.putExtra("qonimg", datas.get(2));
                intent.putExtra("qimglist", (Serializable)datas);
                intent.setClass(this, ImageActivity.class);
                startActivity(intent);
                break;

            case R.id.yzbut:
                sendYz();
                break;

        }
    }

    /**
     * 发起预诊
     */
    public void sendYz(){

        if(net == null){
            net = new NetworkJudge(TwoDetailsActivity.this);
        }
        boolean flag = net.checkNetworkAvailable();
        if(flag == true){
            HttpServer hs = new HttpServer(TwoDetailsActivity.this);
            RequestParams rp = new RequestParams();
            rp.put("id",dataIdNew);
            hs.postServer(URL_SEND, rp, sendHandler, "print");
        }else{
            showToast("查询失败请检查网络");
        }

    }

    /**
     * 发起预诊异步
     */
    Handler sendHandler = new Handler(){

        public void handleMessage(android.os.Message msg){

            switch (msg.what) {
                case 1:
                    String text = msg.obj.toString();
                    Log.v("print", text);
                    if(!text.equals("")){
                        SendYz olje = new Gson().fromJson(text, SendYz.class);
                        int status = olje.getStatus();
                        if(status == 0){
                            showToast("该心电记录已经发起预诊，不能重复发起");
                        }else if(status == 1){
                            showToast("发起预诊成功");
                        }else if(status == 2){
                            showToast("发起预诊失败");
                        }
                    }else{
                        showToast("发起预诊失败请检查网络");
                    }
                    break;

                case 999:
                    String text1 = msg.obj.toString();
                    Log.v("print", text1);
                    showToast("发起预诊失败请检查网络");
                    break;
            }

        };

    };

}
