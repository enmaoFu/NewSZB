package com.yy.newszb.fragments;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.yy.newszb.activity.R;
import com.yy.newszb.activity.TwoDetailsActivity;
import com.yy.newszb.adapters.ThreeAdapter;
import com.yy.newszb.base.BaseFragment;
import com.yy.newszb.entitys.ThreeEntity;
import com.yy.newszb.https.HttpServer;
import com.yy.newszb.json.OneListJsonEntity;
import com.yy.newszb.json.OneListListJsonEntity;
import com.yy.newszb.utils.NetworkJudge;
import com.yy.newszb.utils.Preference;

import java.util.ArrayList;
import java.util.List;

import static com.yy.newszb.interfaces.HttpUrlDefinition.URL_PUBLIC_LISTVIEW;

/**
 * 远程心电
 * @author fuenmao
 */
public class ThreeFragment extends BaseFragment {

    private ListView mlistview;//listview
    private ThreeAdapter threeAdapter;//适配器
    private List<ThreeEntity> threeEntityList = new ArrayList<ThreeEntity>();//数据源
    private NetworkJudge net;//判断网络工具类
    private Preference yp;//保存数据到本地
    private String docterId;

    /**
     * 初始化视图
     */
    @Override
    protected int bindViews() {
        return R.layout.fragment_three;
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
        //initListview();
    }

    /**
     * 初始化标题栏
     */
    @Override
    protected void initActionBar() {
        // TODO Auto-generated method stub

    }

    /**
     * Listview
     */
    /*public void initListview(){

        ThreeEntity threeEntity = null;

        for(int i = 0; i < 20; i++){

            threeEntity = new ThreeEntity("1","张三","500326499782654500","2016-11-01");

            threeEntityList.add(threeEntity);

        }

        threeAdapter = new ThreeAdapter(threeEntityList,getActivity());

        mlistview.setAdapter(threeAdapter);

        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();

                intent.setClass(getActivity(), TwoDetailsActivity.class);

                intent.putExtra("key","3");

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
            rp.put("type","3");
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
                                threeEntityList.clear();
                                ThreeEntity threeEntity = null;

                                for(int i = 0; i < oneListListJsonEntities.size(); i++){
                                    threeEntity = new ThreeEntity(oneListListJsonEntities.get(i).getID(),oneListListJsonEntities.get(i).getNAME(),
                                            oneListListJsonEntities.get(i).getUID(),oneListListJsonEntities.get(i).getTIME().substring(0,10));

                                    threeEntityList.add(threeEntity);

                                }

                                threeAdapter = new ThreeAdapter(threeEntityList,getActivity());

                                mlistview.setAdapter(threeAdapter);

                                mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        TextView dataId = (TextView)view.findViewById(R.id.idss);
                                        String dataIdNew = dataId.getText().toString().trim();

                                        Intent intent = new Intent();

                                        intent.setClass(getActivity(), TwoDetailsActivity.class);

                                        intent.putExtra("dataIdNew",dataIdNew);
                                        intent.putExtra("key","3");
                                        intent.putExtra("type","3");

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

}
