package com.jd.imitate2jd.appmvps.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.home.model.bean.PagerBean;

import java.util.List;

public class MyGridViewAdapter extends BaseAdapter {
    List<PagerBean.DataBean> list;
    Context mContext;

    public MyGridViewAdapter(List<PagerBean.DataBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = View.inflate(mContext,R.layout.pager_gridview_item,null);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.grid_img);
            holder.text = convertView.findViewById(R.id.grid_text);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(list.get(position).getIcon()).into(holder.img);
        holder.text.setText(list.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        ImageView img;
        TextView text;
    }
}
