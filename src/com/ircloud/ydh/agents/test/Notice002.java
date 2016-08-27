package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;

import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Notice002 extends ActivityInstrumentationTestCase2 {
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
    public Notice002() throws ClassNotFoundException {
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
  
	public void testNotice002() {
		solo.waitForActivity("WelcomeActivity", 2000);
		solo.sleep(90000);
	
		assertTrue("CorpMainActivity is not found!", solo.waitForActivity("CorpMainActivity"));
		
		Timeout.setSmallTimeout(3251);
		// Click on 通知 99
		solo.clickOnText(java.util.regex.Pattern.quote("通知"));
		solo.sleep(5000);
		// Click on 通知分类
		solo.clickOnView(solo.getView("llCorpNoticeType"));
		solo.sleep(5000);
		// Wait for activity: 'com.ircloud.ydh.corp.CorpAddNoticeTypeActivity'
		assertTrue("CorpAddNoticeTypeActivity is not found!", solo.waitForActivity("CorpAddNoticeTypeActivity"));
		// Click on 新增分类
		solo.clickOnView(solo.getView("tvAddNoticeType"));
		// Wait for dialog
		solo.waitForDialogToOpen(5000);
		// Enter the text: '啊啊啊'
		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "啊啊啊");
		// Click on 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(15000);
		// Click on HomeView 通知分类 
		solo.goBack();
		solo.sleep(5000);
		// Click on 新增通知
		solo.clickOnView(solo.getView("btnAddCorpNotice"));
		solo.sleep(5000);
		// Wait for activity: 'com.ircloud.ydh.corp.CorpAddNoticeActivity'
		assertTrue("CorpAddNoticeActivity is not found!", solo.waitForActivity("CorpAddNoticeActivity"));
		// Click on Empty Text View
		solo.clickOnView(solo.getView("etNoticeTitle"));
		// Enter the text: '测试测试'
		solo.clearEditText((android.widget.EditText) solo.getView("etNoticeTitle"));
		solo.enterText((android.widget.EditText) solo.getView("etNoticeTitle"), "测试测试");
		// Click on Empty Text View
		solo.clickOnView(solo.getView("etNoticeDetail"));
		// Enter the text: '啊啊啊测试测试测试测试测试测试'
		solo.clearEditText((android.widget.EditText) solo.getView("etNoticeDetail"));
		solo.enterText((android.widget.EditText) solo.getView("etNoticeDetail"), "啊啊啊测试测试测试测试测试测试");
		// Click on Empty Text View
		solo.clickOnView(solo.getView("cbAddNoticeTo1"));
		// Click on Empty Text View
		solo.clickOnView(solo.getView("cbAddNoticeTo2"));
		// Click on 保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(15000);
		// Click on 2015-12 测试测试 啊啊啊 12-11
		solo.clickInList(3, 3);
		solo.sleep(5000);
		// Wait for activity: 'com.ircloud.ydh.agents.NoticeDetailActivity'
		assertTrue("NoticeDetailActivity is not found!", solo.waitForActivity("NoticeDetailActivity"));
		// Click on HomeView 通知详情 
		solo.goBack();
		solo.sleep(5000);
	}
}
