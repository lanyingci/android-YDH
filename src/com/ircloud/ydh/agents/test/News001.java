package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;

import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class News001 extends ActivityInstrumentationTestCase2 {
  	private Solo solo;
  	
  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.ircloud.ydh.agents.WelcomeActivity";

    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
  	
  	@SuppressWarnings("unchecked")
    public News001() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testNews001() {
		
		solo.waitForActivity("WelcomeActivity", 2000);
		
		solo.sleep(100000);
	
		assertTrue("MainActivity is not found!", solo.waitForActivity("MainActivity"));
		
		//消息
		solo.clickOnView(solo.getView(android.widget.RelativeLayout.class, 29));
		solo.sleep(7000);
		// 问题反馈 ，问题反馈在消息列表第一排，不然请修改solo.clickInList(1, 2)到对应的排数
		solo.clickInList(1, 2);
		solo.sleep(15000);
		
		assertTrue("AgentFeedBackActivity is not found!", solo.waitForActivity("AgentFeedBackActivity"));
		//  期待您的意见反馈
		solo.clickOnView(solo.getView("rlNewQuestion"));
		solo.sleep(5000);
		
		assertTrue("AgentFeedbackCreateActivity is not found!", solo.waitForActivity("AgentFeedbackCreateActivity"));
		// 输入反馈内容 '测试测试'
		solo.clearEditText((android.widget.EditText) solo.getView("etContent"));
		solo.enterText((android.widget.EditText) solo.getView("etContent"), "测试测试");
		// 发送
		solo.clickOnView(solo.getView("btnSend"));
		solo.sleep(9000);
	
		solo.goBack();
		solo.sleep(5000);
		//  订单消息 ，订单消息在消息列表第2排，不然请修改solo.clickInList(3, 2)到对应的排数
		solo.clickInList(3, 2);
		solo.sleep(8000);
		
		assertTrue("OrderMessageListActivity is not found!", solo.waitForActivity("OrderMessageListActivity"));
		//点击进入订单详情
		solo.clickInList(2, 0);
		solo.sleep(35000);
		
		assertTrue("OrderDetailActivity is not found!", solo.waitForActivity("OrderDetailActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		
		solo.goBack();
		solo.sleep(5000);
		//公司公告，公司公告在消息列表第5排，不然请修改solo.clickInList(5, 2)到对应的排数
		solo.clickInList(5, 2);
		solo.sleep(5000);
		
		assertTrue("NoticeActivity is not found!", solo.waitForActivity("NoticeActivity"));
		//点击消息进入详情
		solo.clickInList(3, 0);
		solo.sleep(12000);
	
		assertTrue("NoticeDetailActivity is not found!", solo.waitForActivity("NoticeDetailActivity"));
		
		solo.goBack();
		solo.sleep(5000);
	
		solo.goBack();
		solo.sleep(5000);
		//向下滚动界面
		android.widget.ListView listView1 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 1);
		solo.scrollListToLine(listView1, 2);
		solo.sleep(5000);
		// 系统公告
		solo.clickOnText("^系统公告$");
		solo.sleep(15000);
		
		assertTrue("SystemNoticeActivity is not found!", solo.waitForActivity("SystemNoticeActivity"));
		//点击系统公告进入详情
		solo.clickInList(2, 0);
		solo.sleep(9000);
	
		assertTrue("SystemNoticeDetailActivity is not found!", solo.waitForActivity("SystemNoticeDetailActivity"));
		
		solo.goBack();
		solo.sleep(5000);
		
		solo.goBack();
		solo.sleep(5000);
		
	}
}

