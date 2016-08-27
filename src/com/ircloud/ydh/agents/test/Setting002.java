package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;

import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Setting002 extends ActivityInstrumentationTestCase2 {
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
    public Setting002() throws ClassNotFoundException {
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
  
	public void testSetting002() {
		solo.waitForActivity("WelcomeActivity", 2000);
		solo.sleep(90000);
	
		assertTrue("CorpMainActivity is not found!", solo.waitForActivity("CorpMainActivity"));
		
		Timeout.setSmallTimeout(3251);
		// 设置
		solo.clickOnView(solo.getView("action_more"));
		solo.sleep(15000);
	
		assertTrue("CorpSettingActivity is not found!", solo.waitForActivity("CorpSettingActivity"));
		//  我的账号
		solo.clickOnView(solo.getView("myAccount"));
		solo.sleep(5000);
		
		assertTrue("MyAccountActivity is not found!", solo.waitForActivity("MyAccountActivity"));

		solo.goBack();
		solo.sleep(5000);
		// 银行账号
		solo.clickOnView(solo.getView("llFinanceInfo"));
		solo.sleep(5000);
	
		assertTrue("CorpAccountInfoActivity is not found!", solo.waitForActivity("CorpAccountInfoActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		// 公司信息
		solo.clickOnView(solo.getView("companyInfo"));
		solo.sleep(5000);
	
		assertTrue("CorpCompanyInfoActivity is not found!", solo.waitForActivity("CorpCompanyInfoActivity"));
		// 邮编 
		solo.clickOnText(java.util.regex.Pattern.quote("邮编"));

		solo.goBack();
		solo.sleep(5000);
	
		// 下载地址
		solo.clickOnView(solo.getView("notifysound"));

		assertTrue("'下载地址' is not shown!", solo.waitForText(java.util.regex.Pattern.quote("下载地址"), 1, 20000, true, true));
		// 系统通知
		solo.clickOnView(solo.getView("llSystemNotice"));
		solo.sleep(5000);

		assertTrue("SystemNoticeActivity is not found!", solo.waitForActivity("SystemNoticeActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		// 客户反馈管理
		solo.clickOnView(solo.getView("llRetailerFeedBackManager"));
		solo.sleep(5000);

		assertTrue("RetailerFeedBackManagerActivity is not found!", solo.waitForActivity("RetailerFeedBackManagerActivity"));
	
		solo.clickInList(2, 0);
		solo.sleep(5000);

		assertTrue("RetailerFeedBackManagerDetailActivity is not found!", solo.waitForActivity("RetailerFeedBackManagerDetailActivity"));

		solo.clickOnView(solo.getView("etRetailerContent"));
		//输入回复反馈内容: '啊啊啊'
		solo.clearEditText((android.widget.EditText) solo.getView("etRetailerContent"));
		solo.enterText((android.widget.EditText) solo.getView("etRetailerContent"), "啊啊啊");
		// 发送
		solo.clickOnView(solo.getView("btnRetailerSend"));
	
		solo.goBack();
		solo.sleep(5000);
	
		solo.goBack();
		solo.sleep(5000);
		//关于易订货
		solo.clickOnView(solo.getView("aboutYDH"));
		solo.sleep(5000);

		assertTrue("AboutYDHActivity is not found!", solo.waitForActivity("AboutYDHActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		//系统建议与反馈
		solo.clickOnView(solo.getView("feedback"));
		solo.sleep(5000);

		assertTrue("FeedbackActivity is not found!", solo.waitForActivity("FeedbackActivity"));

		solo.goBack();
		solo.sleep(5000);
		solo.scrollToTop();
		solo.sleep(5000);
		// 切换账号
		solo.clickOnText(java.util.regex.Pattern.quote("切换账号"));

		solo.waitForDialogToOpen(5000);
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(15000);
	
		assertTrue("LoginActivity is not found!", solo.waitForActivity("LoginActivity"));
		// 清空账号
		solo.clickOnView(solo.getView("ibClear"));
		solo.sleep(5000);
	}
}

