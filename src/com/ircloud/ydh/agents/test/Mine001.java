package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Mine001 extends ActivityInstrumentationTestCase2 {
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
    public Mine001() throws ClassNotFoundException {
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
  
	public void testMine001() {
		
		solo.waitForActivity("WelcomeActivity", 2000);
		solo.sleep(100000);
	
		assertTrue("MainActivity is not found!", solo.waitForActivity("MainActivity"));
		//我的 
		solo.clickOnView(solo.getView(android.widget.RelativeLayout.class, 31));
		solo.sleep(6000);
		// 我的账号
		solo.clickOnView(solo.getView("myAccount"));
		solo.sleep(5000);
		
		assertTrue("MyAccountActivity is not found!", solo.waitForActivity("MyAccountActivity"));

		solo.goBack();
		solo.sleep(5000);
		//切换账号
		solo.clickOnText(java.util.regex.Pattern.quote("切换账号"));
	
		solo.waitForDialogToOpen(5000);
		// 取消
		solo.clickOnView(solo.getView("btnCancel"));
		// 收货地址
		solo.clickOnView(solo.getView("receiptInfo"));
		solo.sleep(5000);

		assertTrue("ReceiptInfoActivity is not found!", solo.waitForActivity("ReceiptInfoActivity"));
		// 编辑
		solo.clickOnView(solo.getView("tvEdit"));
		solo.sleep(5000);
		
		assertTrue("EditAddressActivity is not found!", solo.waitForActivity("EditAddressActivity"));
		// 保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(9000);
		//  新建收货地址
		solo.clickOnView(solo.getView("btn_add_receipt"));
		solo.sleep(5000);
		
		assertTrue("AddAddressActivity is not found!", solo.waitForActivity("AddAddressActivity"));
		// 客户名称 
		solo.clickOnText(java.util.regex.Pattern.quote("客户名称"));
		solo.sleep(5000);
		
		assertTrue("EditTextActivity is not found!", solo.waitForActivity("EditTextActivity"));
		// 输入 '客户名'
		solo.clearEditText((android.widget.EditText) solo.getView("content"));
		solo.enterText((android.widget.EditText) solo.getView("content"), "客户名");
		// 保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
		//  收货人 
		solo.clickOnText(java.util.regex.Pattern.quote("收货人"));
		solo.sleep(5000);
		
		assertTrue("EditTextActivity is not found!", solo.waitForActivity("EditTextActivity"));
		// 输入收货人 '客户'
		solo.clearEditText((android.widget.EditText) solo.getView("content"));
		solo.enterText((android.widget.EditText) solo.getView("content"), "客户");
		// 保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
		// 手机 
		solo.clickOnText(java.util.regex.Pattern.quote("手机"));
		solo.sleep(5000);

		assertTrue("EditTextActivityForMobile is not found!", solo.waitForActivity("EditTextActivityForMobile"));
		//  '13800138000'
		solo.clearEditText((android.widget.EditText) solo.getView("content"));
		solo.enterText((android.widget.EditText) solo.getView("content"), "13800138000");
		// 保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
		// 电话 
		solo.clickOnText(java.util.regex.Pattern.quote("电话"));
		solo.sleep(5000);
	
		assertTrue("EditTextActivityForPhone is not found!", solo.waitForActivity("EditTextActivityForPhone"));
		// 输入电话'123456'
		solo.clearEditText((android.widget.EditText) solo.getView("content"));
		solo.enterText((android.widget.EditText) solo.getView("content"), "123456");
		//  保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
		// 所在地区 
		solo.clickOnText(java.util.regex.Pattern.quote("所在地区"));
		
		solo.waitForDialogToOpen(5000);
		
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
		//详细地址 
		solo.clickOnText(java.util.regex.Pattern.quote("详细地址"));
		solo.sleep(5000);
		
		assertTrue("EditTextActivityForAddress is not found!", solo.waitForActivity("EditTextActivityForAddress"));
		// 输入详细地址 '深圳市南山区'
		solo.clearEditText((android.widget.EditText) solo.getView("content"));
		solo.enterText((android.widget.EditText) solo.getView("content"), "深圳市南山区");
		// Click on 保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
		//保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(9000);
		
		solo.goBack();
		solo.sleep(5000);
		//  公司信息
		solo.clickOnView(solo.getView("companyInfo"));
		solo.sleep(5000);
		
		assertTrue("CompanyInfoActivity is not found!", solo.waitForActivity("CompanyInfoActivity"));
		//  保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
		// 快捷支付 
		solo.clickOnView(solo.getView("rl_FasterPaySetting"));
		solo.sleep(5000);
		
		assertTrue("FaseterPaySettingActivity is not found!", solo.waitForActivity("FaseterPaySettingActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		// 分享设置
		solo.clickOnView(solo.getView("shareSetting"));
		solo.sleep(5000);
		
		assertTrue("ShareSettingActivity is not found!", solo.waitForActivity("ShareSettingActivity"));
		//  保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
		
		Timeout.setSmallTimeout(2129);
		// 下载管理 
		solo.clickOnText(java.util.regex.Pattern.quote("下载管理"));
		solo.sleep(5000);
		
		assertTrue("DownloadManagerActivity is not found!", solo.waitForActivity("DownloadManagerActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		// 关于易订货
		solo.clickOnView(solo.getView("aboutYDH"));
		solo.sleep(5000);
		
		assertTrue("AboutYDHActivity is not found!", solo.waitForActivity("AboutYDHActivity"));
		
		solo.goBack();
		solo.sleep(5000);
		// 系统建议与反馈
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
		
		assertTrue("LoginActivity is not found!", solo.waitForActivity("LoginActivity"));
		solo.sleep(7000);
		
	}
}
