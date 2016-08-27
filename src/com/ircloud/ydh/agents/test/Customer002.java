package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Customer002 extends ActivityInstrumentationTestCase2 {
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
    public Customer002() throws ClassNotFoundException {
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
  
	public void testCustomer002() {
		
		solo.waitForActivity("WelcomeActivity", 2000);
		solo.sleep(50000);
	
		assertTrue("CorpMainActivity is not found!", solo.waitForActivity("CorpMainActivity"));
	
		Timeout.setSmallTimeout(3430);

        //客户查询
		solo.clickOnText(java.util.regex.Pattern.quote("客户"));
		solo.sleep(5000);
	
		solo.clickOnView(solo.getView("llSearch", 1));
		
		assertTrue("CorpSearchRetailerActivity is not found!", solo.waitForActivity("CorpSearchRetailerActivity"));

		solo.clickOnText(java.util.regex.Pattern.quote("编码/名称"));
		solo.sleep(5000);
	
		assertTrue("EditTextActivity is not found!", solo.waitForActivity("EditTextActivity"));
	    //输入客户
		solo.clearEditText((android.widget.EditText) solo.getView("content"));
		solo.enterText((android.widget.EditText) solo.getView("content"), "  客户");
		//保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
	    //搜索
		solo.clickOnView(solo.getView("btnSearch"));
		solo.sleep(5000);
	
		assertTrue("CorpRetailerSearchResultActivity is not found!", solo.waitForActivity("CorpRetailerSearchResultActivity"));

		solo.goBack();
		solo.sleep(5000);
	
		solo.goBack();
		solo.sleep(5000);
	
		solo.clickOnView(solo.getView("btnAddRetailer", 1));
		solo.sleep(5000);
	
		assertTrue("CorpAddRetailerActivity is not found!", solo.waitForActivity("CorpAddRetailerActivity"));

		solo.clickOnView(solo.getView("llCompanyName"));
		solo.sleep(5000);
	
		assertTrue("CorpAddRetailerCompanyNameActivity is not found!", solo.waitForActivity("CorpAddRetailerCompanyNameActivity"));
	
		solo.clickOnView(solo.getView("etCompanyName"));
		solo.sleep(1000);

		solo.clearEditText((android.widget.EditText) solo.getView("etCompanyName"));
		solo.enterText((android.widget.EditText) solo.getView("etCompanyName"), "A01");
	
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
	
		solo.clickOnView(solo.getView("llRetailerAttribution"));
		solo.sleep(5000);
	
		assertTrue("CorpAddRetailerAttributionActivity is not found!", solo.waitForActivity("CorpAddRetailerAttributionActivity"));

		solo.clickOnView(solo.getView("action_new_add"));
		solo.sleep(5000);

		assertTrue("CorpAddRetailerChildAreaActivity is not found!", solo.waitForActivity("CorpAddRetailerChildAreaActivity"));

		solo.clickOnView(solo.getView("etAttributionAreaName"));

		solo.clearEditText((android.widget.EditText) solo.getView("etAttributionAreaName"));
		solo.enterText((android.widget.EditText) solo.getView("etAttributionAreaName"), "上海");

		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
	
		solo.clickInList(2, 0);
		solo.sleep(5000);

		solo.clickOnView(solo.getView("llCompanyAddress"));
		solo.sleep(5000);

		assertTrue("CorpAddRetailerCompanyAddressActivity is not found!", solo.waitForActivity("CorpAddRetailerCompanyAddressActivity"));
	
		solo.clickOnView(solo.getView("llChooseArea"));

		solo.waitForDialogToOpen(5000);

		solo.clickInList(1, 0);
	
		solo.clickInList(1, 0);
	
		solo.clickInList(1, 0);

		solo.clickOnView(solo.getView("etDetailAddress"));
		
		solo.clearEditText((android.widget.EditText) solo.getView("etDetailAddress"));
		solo.enterText((android.widget.EditText) solo.getView("etDetailAddress"), "天安门");

		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);

		solo.clickOnView(solo.getView("llRetailerInfo"));
		solo.sleep(5000);

		assertTrue("CorpAddRetailerInformationActivity is not found!", solo.waitForActivity("CorpAddRetailerInformationActivity"));
		
		solo.clickOnView(solo.getView("etLinkName"));

		solo.clearEditText((android.widget.EditText) solo.getView("etLinkName"));
		solo.enterText((android.widget.EditText) solo.getView("etLinkName"), "测试001");

		solo.clickOnView(solo.getView("etPostion"));

		solo.clearEditText((android.widget.EditText) solo.getView("etPostion"));
		solo.enterText((android.widget.EditText) solo.getView("etPostion"), "测试");

		solo.clickOnView(solo.getView("etTelphone"));

		solo.clearEditText((android.widget.EditText) solo.getView("etTelphone"));
		solo.enterText((android.widget.EditText) solo.getView("etTelphone"), "13800138000");
		
		solo.clickOnView(solo.getView("etEmail"));

		solo.clearEditText((android.widget.EditText) solo.getView("etEmail"));
		solo.enterText((android.widget.EditText) solo.getView("etEmail"), "123@163.com");

		solo.clickOnView(solo.getView("etQQ"));

		solo.clearEditText((android.widget.EditText) solo.getView("etQQ"));
		solo.enterText((android.widget.EditText) solo.getView("etQQ"), "123");
	
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);
	
		solo.clickOnView(solo.getView("llRetailerFinanceInfo"));
		solo.sleep(5000);
	
		assertTrue("CorpAddRetailerFinancialActivity is not found!", solo.waitForActivity("CorpAddRetailerFinancialActivity"));

		solo.clickOnView(solo.getView("etAccountName"));
	
		solo.clearEditText((android.widget.EditText) solo.getView("etAccountName"));
		solo.enterText((android.widget.EditText) solo.getView("etAccountName"), "测试");
	
		solo.clickOnView(solo.getView("etAccountBankName"));
	
		solo.clearEditText((android.widget.EditText) solo.getView("etAccountBankName"));
		solo.enterText((android.widget.EditText) solo.getView("etAccountBankName"), "教室银行");

		solo.clickOnView(solo.getView("etBankAccount"));
		
		solo.clearEditText((android.widget.EditText) solo.getView("etBankAccount"));
		solo.enterText((android.widget.EditText) solo.getView("etBankAccount"), "123456");
	
		solo.clickOnView(solo.getView("etTaxNumber"));

		solo.clearEditText((android.widget.EditText) solo.getView("etTaxNumber"));
		solo.enterText((android.widget.EditText) solo.getView("etTaxNumber"), "123456");
	
		solo.clickOnView(solo.getView("etNvoiceStart"));
	
		solo.clearEditText((android.widget.EditText) solo.getView("etNvoiceStart"));
		solo.enterText((android.widget.EditText) solo.getView("etNvoiceStart"), "测试");

		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);

		solo.clickOnView(solo.getView("llAdditionalInfo"));
		solo.sleep(5000);
	
		assertTrue("CorpAddRetailerAdditionalActivity is not found!", solo.waitForActivity("CorpAddRetailerAdditionalActivity"));

		solo.clickOnView(solo.getView("etRetailerCoding"));

		solo.clearEditText((android.widget.EditText) solo.getView("etRetailerCoding"));
		solo.enterText((android.widget.EditText) solo.getView("etRetailerCoding"), "A01");

		solo.clickOnView(solo.getView("etRetailerSignTime1"));

		solo.waitForDialogToOpen(5000);

		solo.clickOnView(solo.getView("done"));
		solo.sleep(5000);

	
		solo.clickOnView(solo.getView("etRetailerCompanyPhone"));

		solo.clearEditText((android.widget.EditText) solo.getView("etRetailerCompanyPhone"));
		solo.enterText((android.widget.EditText) solo.getView("etRetailerCompanyPhone"), "0755123456");

		solo.clickOnView(solo.getView("etRetailerCompanyFax"));

		solo.clearEditText((android.widget.EditText) solo.getView("etRetailerCompanyFax"));
		solo.enterText((android.widget.EditText) solo.getView("etRetailerCompanyFax"), "0755123456");

		solo.clickOnView(solo.getView("etRetailerLogisticsCode"));
	
		solo.clearEditText((android.widget.EditText) solo.getView("etRetailerLogisticsCode"));
		solo.enterText((android.widget.EditText) solo.getView("etRetailerLogisticsCode"), "yyy123456");

		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(5000);

		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(9000);
        //点击客户详情
		solo.clickInList(3, 1);
		solo.sleep(5000);

		assertTrue("CorpCustomerDetailActivity is not found!", solo.waitForActivity("CorpCustomerDetailActivity"));
	
		solo.goBack();
		solo.sleep(5000);
	}
}
