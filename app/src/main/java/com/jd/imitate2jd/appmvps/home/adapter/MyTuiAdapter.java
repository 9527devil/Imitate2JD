package com.jd.imitate2jd.appmvps.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.home.model.bean.BannerBean;

import java.util.List;

public class MyTuiAdapter extends RecyclerView.Adapter<MyTuiAdapter.ViewHolder> {

    List<BannerBean.TuijianBean.ListBean> mList;
    Context mContext;

    public MyTuiAdapter(List<BannerBean.TuijianBean.ListBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.item_tui_item,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext).load(mList.get(i).getImages().split("\\|")[0]).into(viewHolder.img);
        viewHolder.text.setText(mList.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView text;
        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.tui_img);
            text = itemView.findViewById(R.id.tui_text);
        }
    }
}
