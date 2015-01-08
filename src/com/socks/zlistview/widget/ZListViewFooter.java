/**
 * @file XFooterView.java
 * @create Mar 31, 2012 9:33:43 PM
 * @author Maxwin
 * @description XListView's footer
 */
package com.socks.zlistview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.socks.zlistview.R;

/**
 * footer
 * 
 * @class: com.socks.zlistview.ZListViewFooter
 * @author zhaokaiqiang
 * @date 2015-1-4 下午10:37:42
 * 
 */
public class ZListViewFooter extends LinearLayout {

	public final static String HINT_READ = "松开载入更多";
	public final static String HINT_NORMAL = "查看更多";

	// 正常状态
	public final static int STATE_NORMAL = 0;
	// 准备状态
	public final static int STATE_READY = 1;
	// 加载状态
	public final static int STATE_LOADING = 2;

	private View mContentView;
	private View mProgressBar;
	private TextView mHintView;

	public ZListViewFooter(Context context) {
		super(context);
		initView(context);
	}

	public ZListViewFooter(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	private void initView(Context context) {

		LinearLayout moreView = (LinearLayout) LayoutInflater.from(context)
				.inflate(R.layout.xlistview_footer, null);
		addView(moreView);
		moreView.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		mContentView = moreView.findViewById(R.id.xlistview_footer_content);
		mProgressBar = moreView.findViewById(R.id.xlistview_footer_progressbar);
		mHintView = (TextView) moreView
				.findViewById(R.id.xlistview_footer_hint_textview);
	}

	/**
	 * 设置当前的状态
	 * 
	 * @param state
	 */
	public void setState(int state) {

		mProgressBar.setVisibility(View.INVISIBLE);
		mHintView.setVisibility(View.INVISIBLE);

		switch (state) {
		case STATE_READY:
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(HINT_READ);
			break;

		case STATE_NORMAL:
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(HINT_NORMAL);
			break;

		case STATE_LOADING:
			mProgressBar.setVisibility(View.VISIBLE);
			break;

		}

	}

	public void setBottomMargin(int height) {
		if (height > 0) {

			LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView
					.getLayoutParams();
			lp.bottomMargin = height;
			mContentView.setLayoutParams(lp);
		}
	}

	public int getBottomMargin() {
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView
				.getLayoutParams();
		return lp.bottomMargin;
	}

	public void hide() {
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView
				.getLayoutParams();
		lp.height = 0;
		mContentView.setLayoutParams(lp);
	}

	public void show() {
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView
				.getLayoutParams();
		lp.height = LayoutParams.WRAP_CONTENT;
		mContentView.setLayoutParams(lp);
	}

}
