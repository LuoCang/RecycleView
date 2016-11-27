package com.dqhl.recycledemo.activity;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dqhl.recycledemo.R;
import com.dqhl.recycledemo.adapter.MyAdapter;
import com.dqhl.recycledemo.modle.MyModle;
import com.dqhl.recycledemo.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    //    @InjectView(R.id.recyceView) RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private List<MyModle> mModleList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.inject(this);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyceView);

        //设置布局管理器
        //（1）竖屏的listview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //（2）横屏的gridview
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        //（3）瀑布流
        //  数字代表几行
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        //设置Adapter
        mRecyclerView.setAdapter(myAdapter = new MyAdapter(this, mModleList));
        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线

        //竖屏的listview
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //横屏的gridview
        //mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        myAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            //点击每一项增加
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + " click",
                        Toast.LENGTH_SHORT).show();
                myAdapter.addData(1);
            }
            //长按删除
            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
                myAdapter.removeData(1);
            }
        });
    }
    private void initData() {
        mModleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyModle myModle = new MyModle();
            myModle.setId(i + "");
            mModleList.add(myModle);
        }

    }

    //    @OnItemClick(R.id.recyceView)
//    void onItemOnClick() {
//
//    }
    public static abstract class ItemDecoration {
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            onDraw(c, parent, state);
        }


        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            onDrawOver(c, parent, state);
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            getItemOffsets(outRect, ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(),
                    parent);
        }

        @Deprecated
        public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
            outRect.set(0, 0, 0, 0);
        }
    }
}
