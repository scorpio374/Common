package cn.android.common.pattern.strategy.impl;

import cn.android.common.pattern.strategy.IDisplayBehavior;
import cn.android.common.utils.LogUtil;

public class DisplayA implements IDisplayBehavior{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		LogUtil.log("样子A");
	}

}
