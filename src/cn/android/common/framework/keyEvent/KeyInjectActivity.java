package cn.android.common.framework.keyEvent;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.IWindowManager;
import android.view.KeyEvent;
import cn.android.common.R;
import cn.android.common.utils.LogUtil;

public class KeyInjectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_common);
		LogUtil.log("onCreate");
		IBinder wmbinder = ServiceManager.getService("window");
		IWindowManager m_WndManager = IWindowManager.Stub.asInterface(wmbinder);

		try {
			// key down
			m_WndManager.injectKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,
					KeyEvent.KEYCODE_A), true);

			// key up
			m_WndManager.injectKeyEvent(new KeyEvent(KeyEvent.ACTION_UP,
					KeyEvent.KEYCODE_A), true);
			super.onCreate(savedInstanceState);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		LogUtil.log("onKeyDown:" + keyCode);
		return super.onKeyDown(keyCode, event);
	}
}
