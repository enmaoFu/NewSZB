package com.yy.newszb.fragments;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.yy.newszb.activity.R;
import com.yy.newszb.activity.TwoDetailsActivity;
import com.yy.newszb.adapters.OneAdapter;
import com.yy.newszb.base.BaseFragment;
import com.yy.newszb.entitys.OneEntity;
import com.yy.newszb.https.HttpServer;
import com.yy.newszb.interfaces.HttpUrlDefinition;
import com.yy.newszb.json.OneListJsonEntity;
import com.yy.newszb.json.OneListListJsonEntity;
import com.yy.newszb.utils.NetworkJudge;
import com.yy.newszb.utils.Preference;

import java.util.ArrayList;
import java.util.List;

/**
 * 心电列表
 * @author fuenmao
 */
public class OneFragment extends BaseFragment implements View.OnClickListener,HttpUrlDefinition{

    private ListView mlistview;//listview
    private OneAdapter oneAdapter;//适配器
    private List<OneEntity> oneEntityList = new ArrayList<OneEntity>();//数据源

    private Button add;//新增门诊记录
    private Button query;//查询

    private TextView sfz;
    private String uid;
    private String sfznumber;
    private Intent intent = new Intent();
    private NetworkJudge net;//判断网络工具类
    private Preference yp;//保存数据到本地
    private String docterId;
    /**
     * 初始化视图
     */
    @Override
    protected int bindViews() {
        return R.layout.fragment_one;
    }

    /**
     * 初始化视图组件
     */
    @Override
    protected void initControl() {
        mlistview = (ListView)findViewById(R.id.listview);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        yp = new Preference(getActivity());
        docterId = yp.getString("docterId");
        getListviewData();
    }

    /**
     * 初始化标题栏
     */
    @Override
    protected void initActionBar() {
        // TODO Auto-generated method stub

    }

    /**
     * 初始化listview数据
     */
    /*public void initListviewData(){

        OneEntity oneEntity = null;

        for(int i = 0; i < 20; i++){

            oneEntity = new OneEntity("1","张三","500326499782654500","2016-11-01");

            oneEntityList.add(oneEntity);

        }

        oneAdapter = new OneAdapter(oneEntityList,getActivity());

        mlistview.setAdapter(oneAdapter);

        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();

                intent.setClass(getActivity(), TwoDetailsActivity.class);

                intent.putExtra("key","1");

                startActivity(intent);

            }
        });

    }*/

    /**
     * 事件监听
     * @param v
     */
    @Override
    public void onClick(View v) {

    }

    public void getListviewData(){

        if(net == null){
            net = new NetworkJudge(getActivity());
        }
        boolean flag = net.checkNetworkAvailable();
        if(flag == true){
            HttpServer hs = new HttpServer(getActivity());
            RequestParams rp = new RequestParams();
            rp.put("id",docterId);
            rp.put("type","1");
            hs.postServer(URL_PUBLIC_LISTVIEW, rp, oneHandler, "print");
        }else{
            showToast("查询失败请检查网络");
        }

    }

    /**
     * 登陆Handler消息异步
     */
    Handler oneHandler = new Handler(){

        public void handleMessage(android.os.Message msg){

            switch (msg.what) {
                case 1:
                    String text = msg.obj.toString();
                    Log.v("print", text);
                    if(!text.equals("")){
                        //gson解析
                        OneListJsonEntity olje = new Gson().fromJson(text, OneListJsonEntity.class);
                        int status = olje.getStatus();
                        if(status == 0){
                            List<OneListListJsonEntity> oneListListJsonEntities =  olje.getData();
                            if(oneListListJsonEntities != null && oneListListJsonEntities.size() > 0){

                                oneEntityList.clear();
                                OneEntity oneEntity = null;

                                for(int i = 0; i < oneListListJsonEntities.size(); i++){

                                    oneEntity = new OneEntity(oneListListJsonEntities.get(i).getID(),oneListListJsonEntities.get(i).getNAME(),
                                            oneListListJsonEntities.get(i).getUID(),oneListListJsonEntities.get(i).getTIME().substring(0,10));

                                    oneEntityList.add(oneEntity);

                                }

                                oneAdapter = new OneAdapter(oneEntityList,getActivity());

                                mlistview.setAdapter(oneAdapter);

                                mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        TextView dataId = (TextView)view.findViewById(R.id.idss);
                                        String dataIdNew = dataId.getText().toString().trim();

                                        Intent intent = new Intent();

                                        intent.setClass(getActivity(), TwoDetailsActivity.class);

                                        intent.putExtra("key","1");
                                        intent.putExtra("dataIdNew",dataIdNew);
                                        intent.putExtra("type","1");

                                        startActivity(intent);

                                    }
                                });
                            }else{
                                showToast("查询失败请检查网络");
                            }
                        }else{
                            showToast("查询失败请检查网络");
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

}
