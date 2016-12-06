package com.dqhl.recycledemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.dqhl.recycledemo.R;
import com.dqhl.recycledemo.adapter.GalleryAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HorizontalRecycleActivity extends AppCompatActivity {

//    private RecyclerView mRecyclerView;
    private GalleryAdapter mGalleryAdapter;
    private List<Integer> mImageMoudleList;
    private int [] images = {R.drawable.divider_bg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_horizontal_recycle);
//        initData();
//        mRecyclerView = (RecyclerView) findViewById(R.id.recyceView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecyclerView.setLayoutManager(linearLayoutManager);
        mGalleryAdapter = new GalleryAdapter(HorizontalRecycleActivity.this,mImageMoudleList);
        mGalleryAdapter.setOnItemClickListener(new GalleryAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(HorizontalRecycleActivity.this, position+"", Toast.LENGTH_SHORT)
                        .show();
            }
        });
//        mRecyclerView.setAdapter(mGalleryAdapter);

    }

    private void initData() {
        mImageMoudleList = new ArrayList<Integer>(Arrays.asList(R.drawable.ic_a,R.drawable.ic_b,
                R.drawable.ic_c,R.drawable.ic_d,R.drawable.ic_e,R.drawable.ic_f,R.drawable.ic_g,R.drawable.ic_h));
    }

}
