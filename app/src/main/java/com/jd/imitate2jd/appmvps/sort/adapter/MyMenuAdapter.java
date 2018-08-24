package com.jd.imitate2jd.appmvps.sort.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jd.imitate2jd.R;
import com.jd.imitate2jd.appmvps.sort.model.bean.MenuBean;

import java.util.ArrayList;
import java.util.List;

public class MyMenuAdapter extends RecyclerView.Adapter<MyMenuAdapter.ViewHolder> {
    private List<MenuBean.DataBean> mList;
    private Context mContext;
    List<Boolean> mIsCheckedList;

    public MyMenuAdapter(List<MenuBean.DataBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        mIsCheckedList = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            mIsCheckedList.add(i, false);
        }
        mIsCheckedList.set(0, true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.sort_menu_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.text.setText(mList.get(position).getName().trim());
        final int layoutPosition = viewHolder.getLayoutPosition();
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.Click(mList.get(position).getCid());

                for (int i = 0; i < mList.size(); i++) {
                    mIsCheckedList.add(i, false);
                }
                mIsCheckedList.set(layoutPosition, true);
                notifyDataSetChanged();
            }
        });
        if (mIsCheckedList.get(position)) {
            viewHolder.itemView.setBackgroundColor(Color.WHITE);
        } else {
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#eeeeee"));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.item_menu_text);
        }
    }

    private OnItemClickListener listener;
    public interface OnItemClickListener{
        void Click(String cid);
    }
    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
