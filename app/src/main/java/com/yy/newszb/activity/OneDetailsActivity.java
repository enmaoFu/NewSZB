package com.yy.newszb.activity;

import android.widget.TextView;

import com.yy.newszb.base.BaseActivity;

/**
 * 门诊记录详情页面
 * @author fuenmao
 */
public class OneDetailsActivity extends BaseActivity{

    private TextView name;
    private TextView sex;
    private TextView dete;
    private TextView age;
    private TextView dh;
    private TextView mz;
    private TextView hj;
    private TextView idnumber;
    private TextView hy;
    private TextView dw;
    private TextView zz;
    private TextView context;
    private TextView context1;


    /**
     * 初始化视图
     */
    @Override
    protected void bindViews() {
        setContentView(R.layout.fragment_one_xq);
    }

    /**
     * 初始化组件
     */
    @Override
    protected void initControl() {
        name = (TextView)findViewById(R.id.name);
        sex = (TextView)findViewById(R.id.sex);
        dete = (TextView)findViewById(R.id.dete);
        age = (TextView)findViewById(R.id.age);
        dh = (TextView)findViewById(R.id.dh);
        mz = (TextView)findViewById(R.id.mz);
        hj = (TextView)findViewById(R.id.hj);
        idnumber = (TextView)findViewById(R.id.idnumber);
        hy = (TextView)findViewById(R.id.hy);
        dw = (TextView)findViewById(R.id.dw);
        zz = (TextView)findViewById(R.id.zz);
        context = (TextView)findViewById(R.id.context);
        context1 = (TextView)findViewById(R.id.context1);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        /*List<OneListXqArrayJsonEntity> txlje = (List<OneListXqArrayJsonEntity>) getIntent().getSerializableExtra("ltllje");
        for(int i = 0; i < txlje.size(); i++){

            name.setText("姓名："+txlje.get(i).getName());
            sex.setText("性别："+txlje.get(i).getSex());
            dete.setText("出生日期："+txlje.get(i).getTimes());
            age.setText("年龄："+txlje.get(i).getAge());
            dh.setText("电话："+txlje.get(i).getPhone());
            mz.setText("民族："+txlje.get(i).getNation());
            hj.setText("户籍："+txlje.get(i).getHousehold());
            dw.setText("单位："+txlje.get(i).getCompany());
            zz.setText("住址："+txlje.get(i).getAddress());
            context.setText(txlje.get(i).getDescribe());
            context1.setText(txlje.get(i).getResult());

        }*/
    }

    /**
     * 初始化标题栏
     */
    @Override
    protected void initActionBar() {

    }
}
