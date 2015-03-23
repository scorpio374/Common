package cn.android.common.framework.quickadapter.sample;

import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class QuickAdapterActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		// TestUtil.test();

		getListView().setAdapter(
				new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, Arrays.asList(
								"Simple Adapter Text", "MultiItemStyleText")));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = null;
		switch (position) {
		case 0:
			intent = new Intent(this, SimpleTestActivity.class);
			break;
		case 1:
			intent = new Intent(this, ChatActivity.class);
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
