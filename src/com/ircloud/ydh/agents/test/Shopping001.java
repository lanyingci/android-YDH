package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Shopping001 extends ActivityInstrumentationTestCase2 {
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
    public Shopping001() throws ClassNotFoundException {
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
  
	public void testShopping001() {
		
		solo.waitForActivity("WelcomeActivity", 2000);
		
		solo.sleep(100000);
	
		assertTrue("MainActivity is not found!", solo.waitForActivity("MainActivity"));
		
		solo.sleep(5000);
        //点击进入商品详情
		solo.clickInList(2, 0);
		solo.sleep(20000);
	
		assertTrue("CommodityDetailActivity is not found!", solo.waitForActivity("CommodityDetailActivity"));
        solo.clickOnView(solo.getView("btn_add_count"));
		
		solo.clearEditText((android.widget.EditText) solo.getView("etPurchaseNum"));
		solo.enterText((android.widget.EditText) solo.getView("etPurchaseNum"), "1");
		//点击加入购物车
		solo.clickOnView(solo.getView("btnAddToShoppingCart"));
		solo.sleep(7000);
		//返回
		solo.goBack();
		solo.sleep(7000);
	    //点击快速进入购物车按钮
		solo.clickOnView(solo.getView("ctvInShoppingCart2"));
	
		solo.waitForDialogToOpen(15000);
		//点击+按钮
		solo.clickOnView(solo.getView("btn_add_count"));
		
		solo.clearEditText((android.widget.EditText) solo.getView("etPurchaseNum"));
		solo.enterText((android.widget.EditText) solo.getView("etPurchaseNum"), "2");
		//点击加入购物车
		solo.clickOnView(solo.getView("btnAddToShoppingCart"));
		solo.sleep(15000);
		//向下滚动界面
		solo.scrollDown();
		
		solo.clickOnView(solo.getView("ctvInShoppingCart2", 1));
		
		solo.waitForDialogToOpen(15000);
		
		solo.clickOnView(solo.getView("btn_add_count"));
		
		solo.clearEditText((android.widget.EditText) solo.getView("etPurchaseNum"));
		solo.enterText((android.widget.EditText) solo.getView("etPurchaseNum"), "1");
		
		solo.clickOnView(solo.getView("btnAddToShoppingCart"));
		solo.sleep(15000);
		//点击购物车
		solo.clickOnView(solo.getView("action_shopping_cart"));
		solo.sleep(15000);
		
		assertTrue("ShoppingCartActivity is not found!", solo.waitForActivity("ShoppingCartActivity"));
		
		solo.clickOnView(solo.getView("etPurchaseNum"));
		
		solo.waitForDialogToOpen(7000);
		//修改购物车数量为2
		solo.clearEditText((android.widget.EditText) solo.getView("etCount"));
		solo.enterText((android.widget.EditText) solo.getView("etCount"), "3");
	    //确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(9000);

		//删除一件商品
		solo.clickOnView(solo.getView("tvDelete", 1));
		
		solo.waitForDialogToOpen(5000);
	    //确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(15000);

	    //下单
		solo.clickOnView(solo.getView("btnCreateOrder"));
		solo.sleep(15000);

		assertTrue("CreateOrderActivity is not found!", solo.waitForActivity("CreateOrderActivity"));
	    //交货日期
		solo.clickOnView(solo.getView("rlDeliveryDate"));
	
		solo.waitForDialogToOpen(5000);
	
		solo.clickOnView(solo.getView("done"));
	
		solo.waitForDialogToOpen(5000);
	
		solo.clickOnView(solo.getView("done_button"));
		solo.sleep(9000);
	    //提交订单
		solo.clickOnView(solo.getView("btnCreateOrder"));
	
		Timeout.setSmallTimeout(16574);
	    //完成
		solo.clickOnView(solo.getView("btnFinished"));
		solo.sleep(10000);
	    //再次购买
		solo.clickOnView(solo.getView("tvBuyAgain"));
		solo.sleep(15000);
	
		assertTrue("ShoppingCartActivity is not found!", solo.waitForActivity("ShoppingCartActivity"));
	    //下单
		solo.clickOnView(solo.getView("btnCreateOrder"));
		solo.sleep(15000);
	
		assertTrue("CreateOrderActivity is not found!", solo.waitForActivity("CreateOrderActivity"));
	
		solo.clickOnView(solo.getView("rbSalesReturn"));

		solo.clickOnView(solo.getView("etSaleReturnPrice"));
	    //输入退款金额
		solo.clearEditText((android.widget.EditText) solo.getView("etSaleReturnPrice"));
		solo.enterText((android.widget.EditText) solo.getView("etSaleReturnPrice"), "1");
	
		solo.clickOnView(solo.getView("rl_orderReturnRemark"));
	
		solo.waitForDialogToOpen(5000);
	    //备注
		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "yyyyy");
	
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
	    //提交订单
		solo.clickOnView(solo.getView("btnCreateOrder"));
		solo.sleep(15000);
	    //完成
		solo.clickOnView(solo.getView("btnFinished"));
		solo.sleep(8000);
	}
}
