package com.jd.imitate2jd.appmvps.sort.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.sort.model.bean.InfoBean;

import java.util.List;

public class MyInfoAdapter extends RecyclerView.Adapter<MyInfoAdapter.ViewHolder> {
    List<InfoBean.DataBean> mList;
    Context mContext;

    public MyInfoAdapter(List<InfoBean.DataBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(View.inflate(mContext, R.layout.sort_info_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.title1.setText(mList.get(i).getName());
        viewHolder.text1.setText(mList.get(0).getList().get(i).getName());
        Glide.with(mContext).load(mList.get(0).getList().get(i).getIcon()).into(viewHolder.img1);
        int position = viewHolder.getLayoutPosition();
       viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onItemClickListener.onCLick(mList.get(0).getList().get(i).getPscid());
           }
       });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView text1, title1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title1 = new TextView(mContext, null);
            title1.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            title1.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            title1.setGravity(Gravity.CENTER);
            img1 = itemView.findViewById(R.id.item_info_img);
            text1 = itemView.findViewById(R.id.item_info_text);

        }
    }

    OnItemClickListener onItemClickListener;


    public interface OnItemClickListener {
        void onCLick(String pscid);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
