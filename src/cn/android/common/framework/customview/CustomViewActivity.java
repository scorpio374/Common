package cn.android.common.framework.customview;

import android.app.Activity;
import android.os.Bundle;
import cn.android.common.R;

public class CustomViewActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customtext);
	}


}
