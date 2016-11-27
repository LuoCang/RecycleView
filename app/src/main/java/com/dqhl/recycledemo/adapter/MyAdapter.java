package com.dqhl.recycledemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dqhl.recycledemo.R;
import com.dqhl.recycledemo.modle.MyModle;

import java.util.List;

/**
 * Created by guanluocang on 2016/11/24.
 * RecycleView Adapter
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<MyModle> mModleList;
    private Context context;

    public MyAdapter(Context context, List<MyModle> myModleList) {
        this.context = context;
        this.mModleList = myModleList;
    }

    //点击事件和长按事件
    public interface onItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private onItemClickListener onItemClickListener;

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.linearout_item, parent, false));
        return myViewHolder;
    }

    public void addData(int position){
        MyModle myModle = new MyModle();
        myModle.setId("2");
        mModleList.add(position,myModle);
        notifyItemInserted(position);
    }
    public void removeData(int position){
        mModleList.remove(position);
        notifyItemRemoved(position);

    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv.setText(mModleList.get(position).getId());

        //如果设置了回调，则设置点击事件
        if(onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView,position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView,position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mModleList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_id);
        }
    }
}
