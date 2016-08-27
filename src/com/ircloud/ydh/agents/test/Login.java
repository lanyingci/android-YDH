package com.ircloud.ydh.agents.test;

//导入需要的包
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;

//
@SuppressWarnings("rawtypes")
public class Login extends ActivityInstrumentationTestCase2 {
  	//声明一个Solo对象
	private Solo solo;
  	
	//第二是被测程序的入口类
  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.ircloud.ydh.agents.WelcomeActivity";

    //静态加载auncherActivityClass也就是被测程序主类
    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
    
    
    //构造函数，传入launcherActivityClass
  	@SuppressWarnings("unchecked")  //忽略unchecked的warning
    public Login() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

    //初始化被测程序
  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
  	
    //在测试用例执行完毕执行，关掉应用程序，清除垃圾
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testLogin() {
		// 等待一个匹配指定名称的'com.ircloud.ydh.agents.WelcomeActivity'，超时2000毫秒
		solo.waitForActivity("WelcomeActivity", 2000);
		// 判断当前是否是指定的 'com.ircloud.ydh.agents.GuideActivity'Activity
		assertTrue("GuideActivity is not found!", solo.waitForActivity("GuideActivity"));
		//设置默认的最短超时为5000毫秒 
		Timeout.setSmallTimeout(5000);
		// 右滑动界面
		solo.scrollViewToSide(solo.getView("vpPager"), Solo.RIGHT);
		
		solo.scrollViewToSide(solo.getView("vpPager"), Solo.RIGHT);
	
		solo.scrollViewToSide(solo.getView("vpPager"), Solo.RIGHT);
	
		solo.scrollViewToSide(solo.getView("vpPager"), Solo.RIGHT);
	
		solo.scrollViewToSide(solo.getView("vpPager"), Solo.RIGHT);
		// 获取“ 立即使用”，进行点击
		solo.clickOnView(solo.getView("btnBegin", 1));
		
		assertTrue("LoginActivity is not found!", solo.waitForActivity("LoginActivity"));
		// 点击用户名输入框
		solo.clickOnView(solo.getView("etUsername"));
		// 清空用户名输入框
		solo.clearEditText((android.widget.EditText) solo.getView("etUsername"));
		//输入用户名
		solo.enterText((android.widget.EditText) solo.getView("etUsername"), "lanyc");
	
		solo.clickOnView(solo.getView("etPassword"));
		// 输入密码
		solo.clearEditText((android.widget.EditText) solo.getView("etPassword"));
		solo.enterText((android.widget.EditText) solo.getView("etPassword"), "123456");
		// 点击登录
		solo.clickOnView(solo.getView("btnLogin"));
		solo.sleep(100000);
		// 判断当前是否是指定的 'CorpMainActivity'Activity
		assertTrue("CorpMainActivity is not found!", solo.waitForActivity("CorpMainActivity"));
		
		Timeout.setSmallTimeout(8362);
	}
}