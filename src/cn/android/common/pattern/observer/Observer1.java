package cn.android.common.pattern.observer;

import cn.android.common.utils.LogUtil;

public class Observer1 implements Observer {
	private Subject subject;

	public Observer1(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void update(String msg) {
		LogUtil.log("observer1 得到 3D 号码  -->" + msg + ", 我要记下来。");
	}

}
