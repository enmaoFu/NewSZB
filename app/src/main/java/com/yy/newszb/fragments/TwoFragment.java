package com.yy.newszb.fragments;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.yy.newszb.activity.R;
import com.yy.newszb.activity.TwoDetailsActivity;
import com.yy.newszb.adapters.TwoAdapter;
import com.yy.newszb.base.BaseFragment;
import com.yy.newszb.entitys.TwoEntity;
import com.yy.newszb.https.HttpServer;
import com.yy.newszb.interfaces.HttpUrlDefinition;
import com.yy.newszb.json.OneListJsonEntity;
import com.yy.newszb.json.OneListListJsonEntity;
import com.yy.newszb.utils.NetworkJudge;
import com.yy.newszb.utils.Preference;

import java.util.ArrayList;
import java.util.List;

/**
 * 心电预诊
 * @author fuenmao
 */
public class TwoFragment extends BaseFragment implements View.OnClickListener,HttpUrlDefinition{

    private ListView mlistview;//listview
    private TwoAdapter twoAdapter;//适配器
    private List<TwoEntity> twoEntityList = new ArrayList<TwoEntity>();//数据源

    private Button add;//新增心电记录
    private EditText sfz;//身份证输入
    private Button query;//查询身份证号

    private String uid;
    private String sfznumber;

    private Intent intent = new Intent();

    private String idsss;

    private NetworkJudge net;//判断网络工具类
    private Preference yp;//保存数据到本地
    private String docterId;

    /**
     * 初始化视图
     */
    @Override
    protected int bindViews() {
        return R.layout.fragment_two;
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
       // initListviewData();
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

        TwoEntity twoEntity = null;

        for(int i = 0; i <20; i++){

            twoEntity = new TwoEntity("1","李斯","500348566978256155","2016-10-03");

            twoEntityList.add(twoEntity);

        }

        twoAdapter = new TwoAdapter(twoEntityList,getActivity());

        mlistview.setAdapter(twoAdapter);

        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();

                intent.setClass(getActivity(), TwoDetailsActivity.class);

                intent.putExtra("key","2");

                startActivity(intent);

            }
        });

    }*/

    public void getListviewData(){

        if(net == null){
            net = new NetworkJudge(getActivity());
        }
        boolean flag = net.checkNetworkAvailable();
        if(flag == true){
            HttpServer hs = new HttpServer(getActivity());
            RequestParams rp = new RequestParams();
            rp.put("id",docterId);
            rp.put("type","2");
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
                                twoEntityList.clear();
                                TwoEntity twoEntity = null;

                                for(int i = 0; i < oneListListJsonEntities.size(); i++){

                                    twoEntity = new TwoEntity(oneListListJsonEntities.get(i).getID(),oneListListJsonEntities.get(i).getNAME(),
                                            oneListListJsonEntities.get(i).getUID(),oneListListJsonEntities.get(i).getTIME().substring(0,10));

                                    twoEntityList.add(twoEntity);

                                }

                                twoAdapter = new TwoAdapter(twoEntityList,getActivity());

                                mlistview.setAdapter(twoAdapter);

                                mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        TextView dataId = (TextView)view.findViewById(R.id.idss);
                                        String dataIdNew = dataId.getText().toString().trim();

                                        Intent intent = new Intent();

                                        intent.setClass(getActivity(), TwoDetailsActivity.class);

                                        intent.putExtra("dataIdNew",dataIdNew);
                                        intent.putExtra("key","2");
                                        intent.putExtra("type","2");

                                        startActivity(intent);

                                    }
                                });
                            }else{
                                showToast("查询失败请检查网络");
                            }
                        }else{
                            showToast("暂时没有心电数据");
                        }
                    }else{
                        showToast("查询失败请检查网络");
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

    @Override
    public void onClick(View v) {

    }
}
