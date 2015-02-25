package cn.android.common;

import cn.android.common.pattern.decorator.ArmEquip;
import cn.android.common.pattern.decorator.BlueGemDecorator;
import cn.android.common.pattern.decorator.IEquip;
import cn.android.common.pattern.decorator.RedGemDecorator;
import cn.android.common.pattern.decorator.ShoeEquip;
import cn.android.common.pattern.decorator.YellowGemDecorator;
import cn.android.common.pattern.observer.ObjectFor3D;
import cn.android.common.pattern.observer.Observer;
import cn.android.common.pattern.observer.Observer1;
import cn.android.common.pattern.observer.Observer2;
import cn.android.common.pattern.strategy.Role;
import cn.android.common.pattern.strategy.RoleA;
import cn.android.common.pattern.strategy.impl.AttackXL;
import cn.android.common.pattern.strategy.impl.DefendTBS;
import cn.android.common.pattern.strategy.impl.DisplayA;
import cn.android.common.pattern.strategy.impl.RunJCTQ;
import cn.android.common.utils.LogUtil;

/**
 * 功能测试类
 * @author tq
 *
 */
public class TestUtil {

	/**
	 * 测试入口
	 */
	public static void test() {
		// testPatternStrategy();
		// testPatternObserver();
		testPatternDecorator();
	}

	/**
	 * 设计模式--策略</br>
	 * 
	 * 定义了算法族，分别封装起来，让它们之间可相互替换，此模式让算法的变化独立于使用算法的客户。
	 * <ul>
	 * <li>1、封装变化（把可能变化的代码封装起来）
	 * <li>2、多用组合，少用继承（我们使用组合的方式，为客户设置了算法）
	 * <li>3、针对接口编程，不针对实现（对于Role类的设计完全的针对角色，和技能的实现没有关系）
	 * </ul>
	 */
	public static void testPatternStrategy() {
		Role roleA = new RoleA("A");

		roleA.setAttackBehavior(new AttackXL())//
				.setDefendBehavior(new DefendTBS())//
				.setDisplayBehavior(new DisplayA())//
				.setRunBehavior(new RunJCTQ());
		LogUtil.log(roleA.name + ":");
		roleA.run();
		roleA.attack();
		roleA.defend();
		roleA.display();
	}

	/**
	 * 设计模式--观察者<br>
	 * 定义了对象之间的一对多的依赖，这样一来，当一个对象改变时，它的所有的依赖者都会收到通知并自动更新。
	 */
	public static void testPatternObserver() {
		// 模拟一个3D的服务号
		ObjectFor3D subjectFor3d = new ObjectFor3D();
		// 客户1
		Observer observer1 = new Observer1(subjectFor3d);
		Observer observer2 = new Observer2(subjectFor3d);

		subjectFor3d.setMsg("20140420的3D号码是：127");
		subjectFor3d.setMsg("20140421的3D号码是：333");
	}

	public static void testPatternDecorator() {
		// 一个镶嵌2颗红宝石，1颗蓝宝石的靴子
		LogUtil.log(" 一个镶嵌2颗红宝石，1颗蓝宝石的靴子");
		IEquip equip = new RedGemDecorator(new RedGemDecorator(
				new BlueGemDecorator(new ShoeEquip())));
		LogUtil.log("攻击力  : " + equip.caculateAttack());
		LogUtil.log("描述 :" + equip.description());
		LogUtil.log("-------");
		
		// 一个镶嵌1颗红宝石，1颗蓝宝石的武器
		LogUtil.log(" 一个镶嵌1颗红宝石，1颗蓝宝石,1颗黄宝石的武器");
		equip = new RedGemDecorator(new BlueGemDecorator(
				new YellowGemDecorator(new ArmEquip())));
		LogUtil.log("攻击力  : " + equip.caculateAttack());
		LogUtil.log("描述 :" + equip.description());
		LogUtil.log("-------");
	}
}
