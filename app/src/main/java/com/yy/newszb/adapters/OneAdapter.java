package com.yy.newszb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yy.newszb.activity.R;
import com.yy.newszb.entitys.OneEntity;

import java.util.List;

/**
 * 基本诊疗适配器
 * @author fuenmao
 */
public class OneAdapter extends BaseAdapter{

    private List<OneEntity> data;

    private Context content;

    private LayoutInflater inflater;

    public OneAdapter(List<OneEntity> data,Context content) {
        this.data = data;
        this.content = content;

        inflater = LayoutInflater.from(content);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh = null;

        if(convertView == null){

            vh = new ViewHolder();

            convertView = inflater.inflate(R.layout.fragment_one_itme, null);

            vh.idss = (TextView)convertView.findViewById(R.id.idss);
            vh.name = (TextView)convertView.findViewById(R.id.name);
            vh.id = (TextView)convertView.findViewById(R.id.id);
            vh.date = (TextView)convertView.findViewById(R.id.date);

            convertView.setTag(vh);

        }else{

            vh = (ViewHolder)convertView.getTag();

        }

        OneEntity te = data.get(position);

        vh.idss.setText(te.getIdss());
        vh.name.setText(te.getName());
        vh.id.setText(te.getId());
        vh.date.setText(te.getDate());


        return convertView;
    }

    public class ViewHolder{

        TextView idss,name,id,date;

    }

}
