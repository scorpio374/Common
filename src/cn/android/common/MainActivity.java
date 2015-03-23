package cn.android.common;

import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import cn.android.common.framework.customview.CustomViewActivity;
import cn.android.common.framework.quickadapter.sample.QuickAdapterActivity;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getListView().setAdapter(
				new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, Arrays.asList(
								"Quick Adapter","CustomView")));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = null;
		switch (position) {
		case 0:
			intent = new Intent(this, QuickAdapterActivity.class);
			break;
			
		case 1:
			intent = new Intent(this, CustomViewActivity.class);
			break;
		}
		if (intent != null)
			startActivity(intent);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		// TestUtil.test();
		super.onDestroy();
	}

}
