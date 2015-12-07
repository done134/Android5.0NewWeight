package com.luzhuo.android5widget.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;

import com.luzhuo.android5widget.R;
import com.luzhuo.android5widget.adapter.RecycleAdapter;
import com.luzhuo.android5widget.adapter.RecycleAdapter.OnItemClickListener;
import com.luzhuo.android5widget.adapter.RecycleAdapter.RecyclerHolder;
import com.luzhuo.android5widget.utils.Utils;

/**
 * =================================================
 * 
 * 作者:卢卓
 * 
 * 版本:1.0
 * 
 * 创建日期:2015-12-6 下午8:11:26
 * 
 * 描述:回收VIew的案例
 * 
 * 修订历史:
 * 
 * 
 * =================================================
 **/
public class RecyclerViewDemo extends Activity {
	private RecyclerView recycle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycleview);
		initView();
		initData();
	}
	
	private void initView() {
		recycle = (RecyclerView) findViewById(R.id.recycle);
	}

	private void initData() {
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		recycle.setLayoutManager(layoutManager);
		RecycleAdapter adapter = new RecycleAdapter(this);
		recycle.setAdapter(adapter);
		
		adapter.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(RecyclerHolder recyclerHolder, int position) {
				Utils.showQuickToast(RecyclerViewDemo.this, "position:"+position+";text:"+recyclerHolder.content.getText());
			}
		});
	}
}
