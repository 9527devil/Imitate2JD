package com.jd.imitate2jd.detail.mvp.model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jd.imitate2jd.R;
import com.jd.imitate2jd.detail.mvp.model.bean.DetailBean;

public class MyRecycAdapter extends RecyclerView.Adapter<MyRecycAdapter.ViewHolder>{
    DetailBean bean;
    Context mContext;

    public MyRecycAdapter(DetailBean bean, Context mContext) {
        this.bean = bean;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.detail_item,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(mContext).load(bean.getData().get(i).getImages().split("\\|")[0]).into(viewHolder.img);
        viewHolder.text.setText(bean.getData().get(i).getSubhead());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemCLickListener.Click(bean.getData().get(i).getPid());
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView text;
        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.detail_img);
            text = itemView.findViewById(R.id.detail_text);
        }
    }
    OnItemCLickListener onItemCLickListener;

    public void setOnItemCLickListener(OnItemCLickListener onItemCLickListener) {
        this.onItemCLickListener = onItemCLickListener;
    }

    public interface OnItemCLickListener{
        void Click(String pid);
    }
}
