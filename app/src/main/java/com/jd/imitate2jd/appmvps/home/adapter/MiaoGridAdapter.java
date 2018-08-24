package com.jd.imitate2jd.appmvps.home.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.home.model.bean.BannerBean;

import java.util.List;

public class MiaoGridAdapter extends BaseAdapter {
    private static final String TAG = "MiaoGridAdapter";
    Context mContext;
    List<BannerBean.MiaoshaBean.ListBeanX> list;

    public MiaoGridAdapter(Context mContext, List<BannerBean.MiaoshaBean.ListBeanX> list) {
        this.mContext = mContext;
        this.list = list;
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
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.miao_item, parent,false);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.miao_img);
            holder.text = convertView.findViewById(R.id.miao_text);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(list.get(position).getImages().split("\\|")[0]).into(holder.img);
        holder.text.setText(list.get(position).getTitle());
        return convertView;
    }

    class ViewHolder{
        ImageView img;
        TextView text;
    }
}
