package cn.android.common.pattern.observer;

import cn.android.common.utils.LogUtil;

public class Observer2 implements Observer {
	private Subject subject;

	public Observer2(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void update(String msg) {
		LogUtil.log("observer2 得到 3D 号码 -->" + msg + "我要告诉舍友们。");
	}

}
