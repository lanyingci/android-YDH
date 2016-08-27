package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;

import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Order001 extends ActivityInstrumentationTestCase2 {
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
    public Order001() throws ClassNotFoundException {
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
  
	public void testOrder001() {
		solo.waitForActivity("WelcomeActivity", 2000);
		
		solo.sleep(100000);
	
		assertTrue("MainActivity is not found!", solo.waitForActivity("MainActivity"));
		
		Timeout.setSmallTimeout(5434);
		// 点击订单 
		solo.clickOnView(solo.getView(android.widget.RelativeLayout.class, 27));
		//订单查询
		solo.clickOnView(solo.getView("tvOrderSearch"));
		solo.sleep(7000);
		
		assertTrue("AgentOrderSearchActivity is not found!", solo.waitForActivity("AgentOrderSearchActivity"));
		// 开始时间 
		solo.clickOnView(solo.getView("beginDate"));
	
		solo.waitForDialogToOpen(5000);
		//  完成
		solo.clickOnView(solo.getView("done"));
		solo.sleep(5000);
		//  查询
		solo.clickOnView(solo.getView("btnSearch"));
		solo.sleep(7000);
		
		assertTrue("AgentOrderSearchResultListActivity is not found!", solo.waitForActivity("AgentOrderSearchResultListActivity"));
		// 返回
		solo.goBack();
		solo.sleep(5000);
		// 返回
		solo.goBack();
		solo.sleep(5000);

		//注意，本用例订单列表第1个订单是待退单审核 状态的订单，如果不是第1个订单是待退单审核的，请修改("llOrderItem", 0)到对应的订单列表序号
		solo.clickOnView(solo.getView("llOrderItem", 0));
		solo.sleep(15000);
		
		assertTrue("SalesReturnOrderDetailActivity is not found!", solo.waitForActivity("SalesReturnOrderDetailActivity"));
		// 退单状态 
		solo.clickOnView(solo.getView("orderDetailFragmentOrderReturnStatus"));
		solo.sleep(5000);
	
		assertTrue("OrderReturnStatusDetailActivity is not found!", solo.waitForActivity("OrderReturnStatusDetailActivity"));

		solo.goBack();
		solo.sleep(5000);
		//商品清单 
		solo.clickOnView(solo.getView("rlCommodityList"));
		solo.sleep(5000);
		
		assertTrue("CommodityListDetailVersionActivity is not found!", solo.waitForActivity("CommodityListDetailVersionActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		//附件 
		solo.clickOnView(solo.getView("orderDetailFragmentAttachment"));
		solo.sleep(5000);
		
		assertTrue("OrderAttachmentActivity is not found!", solo.waitForActivity("OrderAttachmentActivity"));
		
		solo.goBack();
		solo.sleep(5000);
		//  备注信息
		solo.clickOnView(solo.getView("remarkListActivity"));
		solo.sleep(5000);
	
		assertTrue("RemarkListActivity is not found!", solo.waitForActivity("RemarkListActivity"));
		// 添加备注
		solo.clickOnView(solo.getView("btnAddRemark"));
		
		solo.waitForDialogToOpen(5000);
		// 输入备注'tttt'
		solo.clearEditText((android.widget.EditText) solo.getView("etContent"));
		solo.enterText((android.widget.EditText) solo.getView("etContent"), "tttt");
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(15000);
		
		solo.goBack();
		solo.sleep(5000);
		// 操作日志
		solo.clickOnView(solo.getView("toLogListActivity"));
		solo.sleep(5000);
		
		assertTrue("LogListActivity is not found!", solo.waitForActivity("LogListActivity"));
		
		solo.goBack();
		solo.sleep(5000);
		// 退单作废
		solo.clickOnView(solo.getView("cancelOrder"));
		
		solo.waitForDialogToOpen(5000);
		//输入作废原因 'pppp'
		solo.clearEditText((android.widget.EditText) solo.getView("etContent"));
		solo.enterText((android.widget.EditText) solo.getView("etContent"), "pppp");
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(18000);
		
		solo.goBack();
		solo.sleep(9000);
	

		
		//注意，本用例订单列表第2个订单是待订单审核 状态的订单，如果不是第2个订单是待订单审核的，请修改("llOrderItem", 1)到对应的订单列表序号
		solo.clickOnView(solo.getView("llOrderItem", 1));
		solo.sleep(15000);
	
		assertTrue("OrderDetailActivity is not found!", solo.waitForActivity("OrderDetailActivity"));
		//订单状态 
		solo.clickOnView(solo.getView("orderDetailFragmentOrderStatus"));
		solo.sleep(5000);
		
		assertTrue("OrderStatusDetailActivity is not found!", solo.waitForActivity("OrderStatusDetailActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		//点击 付款记录 未付款 待付款
		solo.clickOnView(solo.getView("orderDetailFragmentPaymentrecords"));
		solo.sleep(8000);
		
		assertTrue("PaymentrecordsActivity is not found!", solo.waitForActivity("PaymentrecordsActivity"));
		// 付款
		solo.clickOnView(solo.getView("btnAddPaymentrecords"));
		solo.sleep(5000);

		assertTrue("MoneyAccountPaymentActivity is not found!", solo.waitForActivity("MoneyAccountPaymentActivity"));
	    //资金账户付款
		solo.clickOnView(solo.getView("etAccountMoney1"));

		solo.clickOnView(solo.getView("etAccountMoney1"));
		// 输入付款金额 '1'
		solo.clearEditText((android.widget.EditText) solo.getView("etAccountMoney1"));
		solo.enterText((android.widget.EditText) solo.getView("etAccountMoney1"), "1");

		solo.clickOnView(solo.getView("etAccountMoney2"));
	
		solo.clearEditText((android.widget.EditText) solo.getView("etAccountMoney2"));
		solo.enterText((android.widget.EditText) solo.getView("etAccountMoney2"), "1");
		// 付款
		solo.clickOnView(solo.getView("btnSubmit"));
		solo.sleep(15000);
	
		solo.goBack();
		solo.sleep(5000);
		//点击付款
		solo.clickOnView(solo.getView("btnAddPaymentrecords1"));
		solo.sleep(5000);

		assertTrue("MoneyAccountPaymentActivity is not found!", solo.waitForActivity("MoneyAccountPaymentActivity"));
		
		solo.clickOnView(solo.getView("etAccountMoney1"));
	
		solo.clearEditText((android.widget.EditText) solo.getView("etAccountMoney1"));
		solo.enterText((android.widget.EditText) solo.getView("etAccountMoney1"), "10");
	
		solo.clickOnView(solo.getView("etAccountMoney2"));
	
		solo.clearEditText((android.widget.EditText) solo.getView("etAccountMoney2"));
		solo.enterText((android.widget.EditText) solo.getView("etAccountMoney2"), "10");
		// 付款
		solo.clickOnView(solo.getView("btnSubmit"));
		solo.sleep(5000);
		// 点击  出库/发货记录
		solo.clickOnView(solo.getView("orderDetailFragmentOutboundShipmentRecords"));
		solo.sleep(5000);

		assertTrue("LogisticsBillActivity is not found!", solo.waitForActivity("LogisticsBillActivity"));
		// 点击 商品清单 展开
		solo.clickOnView(solo.getView("rlCommodityList"));
		//点击 商品清单 收起
		solo.clickOnView(solo.getView("rlCommodityList"));

		solo.goBack();
		solo.sleep(5000);
		// 备注信息
		solo.clickOnView(solo.getView("orderDetailFragmentRemarkInfo"));

		assertTrue("RemarkListActivity is not found!", solo.waitForActivity("RemarkListActivity"));
		// 添加备注
		solo.clickOnView(solo.getView("btnAddRemark"));
	
		solo.waitForDialogToOpen(5000);
		//输入备注 'yyyyy'
		solo.clearEditText((android.widget.EditText) solo.getView("etContent"));
		solo.enterText((android.widget.EditText) solo.getView("etContent"), "yyyyy");
		//  确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(15000);
	
		solo.goBack();
		solo.sleep(5000);
		//  商品清单 
		solo.clickOnView(solo.getView("orderDetailFragmentCommodityList"));
		solo.sleep(5000);
		
		assertTrue("CommodityListDetailVersionActivity is not found!", solo.waitForActivity("CommodityListDetailVersionActivity"));
		//返回
		solo.goBack();
		solo.sleep(5000);
		// 赠品 
		solo.clickOnView(solo.getView("orderDetailFragmentGift"));
		solo.sleep(5000);
		
		assertTrue("GiftListActivity is not found!", solo.waitForActivity("GiftListActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		//交货日期
		solo.clickOnView(solo.getView("orderDetailFragmentDeliveryDate"));
	
		solo.waitForDialogToOpen(5000);
		// 完成
		solo.clickOnView(solo.getView("done"));
	
		solo.waitForDialogToOpen(5000);
		//完成
		solo.clickOnView(solo.getView("done_button"));
		solo.sleep(15000);
		// 附件 
		solo.clickOnView(solo.getView("orderDetailFragmentAttachment"));
		solo.sleep(7000);
		
		assertTrue("OrderAttachmentActivity is not found!", solo.waitForActivity("OrderAttachmentActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		//  操作日志 
		solo.clickOnView(solo.getView("orderDetailFragmentOperationLog"));
		solo.sleep(5000);
		
		assertTrue("LogListActivity is not found!", solo.waitForActivity("LogListActivity"));
		
		solo.goBack();
		solo.sleep(5000);
		// 订单作废
		solo.clickOnView(solo.getView("cancelOrder"));
		
		solo.waitForDialogToOpen(5000);
		// 输入作废原因'yyyy'
		solo.clearEditText((android.widget.EditText) solo.getView("etContent"));
		solo.enterText((android.widget.EditText) solo.getView("etContent"), "yyyy");
		//确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(15000);
		
		solo.goBack();
		solo.sleep(9000);

		

		
	}
}