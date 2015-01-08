package com.socks.zlistview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Toast;

import com.socks.zlistview.widget.ZListView;
import com.socks.zlistview.widget.ZListView.IXListViewListener;

public class MainActivity extends Activity {

	protected static final String TAG = "MainActivity";

	private ZListView listView;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ZListView) findViewById(R.id.listview);
		listView.setXListViewListener(new IXListViewListener() {

			@Override
			public void onRefresh() {

				handler.postDelayed(new Runnable() {

					@Override
					public void run() {
						listView.stopRefresh();
					}
				}, 1000);
			}

			@Override
			public void onLoadMore() {

				handler.postDelayed(new Runnable() {

					@Override
					public void run() {
						listView.stopLoadMore();
					}
				}, 1000);

			}
		});

		listView.setPullLoadEnable(true);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Toast.makeText(MainActivity.this, "onItemClick=" + position,
						Toast.LENGTH_SHORT).show();

			}

		});

		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this,
						"onItemLongClick=" + position, Toast.LENGTH_SHORT)
						.show();
				return true;
			}
		});

		listView.setAdapter(new ListViewAdapter(this));

	}

}
