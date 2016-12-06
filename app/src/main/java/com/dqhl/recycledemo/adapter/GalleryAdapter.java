package com.dqhl.recycledemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dqhl.recycledemo.R;

import java.util.List;

/**
 * Created by guanluocang on 2016/11/25.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private LayoutInflater inflate;
    private List<Integer> mModleList;
    private Context context;

    public GalleryAdapter(Context context,List<Integer> myModleList){
        this.context = context;
        inflate = LayoutInflater.from(context);
        mModleList = myModleList;
    }

    //点击事件和长按事件
    public interface onItemClickListener {
        void onItemClick(View view, int position);

    }

    private onItemClickListener onItemClickListener;

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView iv_img;
        TextView tv_text;
    }


    @Override
    public int getItemCount() {
        return 10;
    }
    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = inflate.inflate(R.layout.linearout_horizon,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.iv_img = (ImageView) view
                .findViewById(R.id.iv_item_image);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final GalleryAdapter.ViewHolder holder, final int position) {
//        holder.iv_img.setImageResource(mModleList.get(position).getImg());
        if(onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView,position);
                    holder.iv_img.setBackgroundResource(R.color.colorAccent);
                }
            });
            notifyDataSetChanged();
        }
    }
}
