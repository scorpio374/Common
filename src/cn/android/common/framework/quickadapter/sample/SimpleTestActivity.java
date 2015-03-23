package cn.android.common.framework.quickadapter.sample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import cn.android.common.R;
import cn.android.common.framework.quickadapter.library.BaseAdapterHelper;
import cn.android.common.framework.quickadapter.library.QuickAdapter;

public class SimpleTestActivity extends Activity
{

	private ListView mListView;
	private List<Bean> mDatas = new ArrayList<Bean>();

	private QuickAdapter<Bean> mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initDatas();

		mListView = (ListView) findViewById(R.id.id_lv_main);
		mAdapter = new QuickAdapter<Bean>(
				SimpleTestActivity.this, R.layout.item_list, mDatas)
		{

			@Override
			protected void convert(BaseAdapterHelper helper, Bean item)
			{
				helper.setText(R.id.tv_title, item.getTitle());
				helper.setText(R.id.tv_describe, item.getDesc());
				helper.setText(R.id.tv_phone, item.getPhone());
				helper.setText(R.id.tv_time, item.getTime());
				// // helper.getView(R.id.tv_title).setOnClickListener(l)
			}
		};
//		mAdapter.showIndeterminateProgress(true);
		// 设置适配器
		mListView.setAdapter(mAdapter);

	}

	private void initDatas()
	{
		Bean bean = null;
		bean = new Bean("美女一只", "周三早上捡到妹子一只，在食堂二楼", "10086", "20130240122");
		mDatas.add(bean);
		bean = new Bean("美女一捆", "周三早上捡到妹子一捆，在食堂三楼", "10086", "20130240122");
		mDatas.add(bean);
		bean = new Bean("比卡丘一个", "周三早上捡到比卡丘一个，在食堂一楼", "10086", "20130240122");
		mDatas.add(bean);
		bean = new Bean("汉子一火车", "周三早上捡到xxxxxxxxxx，在xxx", "10086",
				"20130240122");
		mDatas.add(bean);
	}

}
