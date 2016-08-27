package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;

import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Order002 extends ActivityInstrumentationTestCase2 {
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
    public Order002() throws ClassNotFoundException {
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
  
	public void testOrder002() {
		
		solo.waitForActivity("WelcomeActivity", 2000);
		solo.sleep(50000);
		
		assertTrue("CorpMainActivity is not found!", solo.waitForActivity("CorpMainActivity"));
	
		Timeout.setSmallTimeout(3984);
		//点击订单
		solo.clickOnText(java.util.regex.Pattern.quote("订单"));
		// 订单消息 
		solo.clickOnView(solo.getView("llOrderMsg"));
		solo.sleep(35000);
	
		assertTrue("CorpOrderMessageListActivity is not found!", solo.waitForActivity("CorpOrderMessageListActivity"));
		// 点击列表订单消息 
		solo.clickInList(2, 0);
		solo.sleep(8000);
	
		assertTrue("CorpSalesReturnOrderDetailActivity is not found!", solo.waitForActivity("CorpSalesReturnOrderDetailActivity"));
		
		solo.goBack();

		solo.goBack();
		solo.sleep(8000);
		//订单查询
		solo.clickOnView(solo.getView("llSearchOrder"));
		solo.sleep(5000);

		assertTrue("CorpOrderSearchActivity is not found!", solo.waitForActivity("CorpOrderSearchActivity"));
	
		solo.clickOnView(solo.getView("etKeyword"));
		// 输入'客户'
		solo.clearEditText((android.widget.EditText) solo.getView("etKeyword"));
		solo.enterText((android.widget.EditText) solo.getView("etKeyword"), "客户");
	
		solo.pressSoftKeyboardNextButton();
		//  查询
		solo.clickOnView(solo.getView("btnSearch"));
		solo.sleep(5000);
	
		assertTrue("CorpOrderSearchResultListActivity is not found!", solo.waitForActivity("CorpOrderSearchResultListActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		//退货单
		solo.clickOnView(solo.getView("rbSalesReturn"));
		//查询
		solo.clickOnView(solo.getView("btnSearch"));
		solo.sleep(5000);
	
		assertTrue("CorpOrderSearchResultListActivity is not found!", solo.waitForActivity("CorpOrderSearchResultListActivity"));
	
		solo.goBack();
		
		solo.goBack();
		solo.sleep(15000);
		
		//下面是对退单和订单进行全流程审核，所以需要订退单是全流程的设置
		//注意，本用例订单列表第1个订单是待退单审核 状态的订单，如果不是第1个订单是待退单审核的，请修改solo.clickInList(3, 0);到对应的订单列表序号
		solo.clickInList(3, 0);
		solo.sleep(15000);

		assertTrue("CorpSalesReturnOrderDetailActivity is not found!", solo.waitForActivity("CorpSalesReturnOrderDetailActivity"));
		//商品清单 
		solo.clickOnView(solo.getView("rlCommodityList"));
		solo.sleep(35000);
	
		assertTrue("CommodityListDetailVersionActivity is not found!", solo.waitForActivity("CommodityListDetailVersionActivity"));
		
		solo.goBack();
		solo.sleep(5000);
		//订单附件
		solo.clickOnView(solo.getView("rlCorpAttachment"));
		solo.sleep(5000);
	
		assertTrue("OrderAttachmentActivity is not found!", solo.waitForActivity("OrderAttachmentActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		// 退单审核
		solo.clickOnView(solo.getView("btnAudit"));
	
		solo.waitForDialogToOpen(5000);
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(10000);
		// 收货确认
		solo.clickOnView(solo.getView("btnAudit"));
	
		solo.waitForDialogToOpen(5000);
		//确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(10000);
		//退款确认
		solo.clickOnView(solo.getView("btnAudit"));
		
		solo.waitForDialogToOpen(5000);
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(15000);
	
		solo.goBack();
		solo.sleep(15000);
		
		
		//注意，本用例订单列表第2个订单是待订单审核 状态的订单，如果不是第2个订单是待订单审核的，请修改solo.clickInList(4, 0)到对应的订单列表序号
		solo.clickInList(4, 0);
		solo.sleep(35000);
	
		assertTrue("CorpOrderDetailActivity is not found!", solo.waitForActivity("CorpOrderDetailActivity"));
		//  交货日期
		solo.clickOnView(solo.getView("icDeliveryDateLayout"));
	
		solo.waitForDialogToOpen(5000);
		//完成
		solo.clickOnView(solo.getView("done"));
		
		solo.waitForDialogToOpen(5000);
		// Click on 完成
		solo.clickOnView(solo.getView("done_button"));
		solo.sleep(55000);
		
		// 订单审核
		solo.clickOnView(solo.getView("btnAudit"));
		
		solo.waitForDialogToOpen(5000);
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(10000);
		// 财务审核
		solo.clickOnView(solo.getView("btnAudit"));
		
		solo.waitForDialogToOpen(5000);
		//  确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(10000);
		// 出库审核
		solo.clickOnView(solo.getView("btnAudit"));
		solo.sleep(15000);
	
		assertTrue("CorpLogisticsBillActivity is not found!", solo.waitForActivity("CorpLogisticsBillActivity"));
		// 出库审核
		solo.clickOnView(solo.getView("btnOutStorageAudit"));
	
		assertTrue("CorpOutStorageAuditActivity is not found!", solo.waitForActivity("CorpOutStorageAuditActivity"));
		// 出库
		solo.clickOnView(solo.getView("btnOK"));

		solo.waitForDialogToOpen(5000);
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(10000);
		// 确认发货
		solo.clickOnView(solo.getView("btnConfirmDeliver"));
	
		assertTrue("CorpConfirmDeliverActivity is not found!", solo.waitForActivity("CorpConfirmDeliverActivity"));
		//点击确认发货
		solo.clickOnView(solo.getView("btnConfirmDeliver"));
		solo.sleep(10000);
		
		solo.goBack();
		solo.sleep(15000);
		
	
		solo.goBack();
		solo.sleep(5000);
	}
}
