package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;

import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Shopping002 extends ActivityInstrumentationTestCase2 {
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
    public Shopping002() throws ClassNotFoundException {
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
  
	public void testShopping002() {
	
		solo.waitForActivity("WelcomeActivity", 2000);
		solo.sleep(50000);
		
		assertTrue("CorpMainActivity is not found!", solo.waitForActivity("CorpMainActivity"));
	
		Timeout.setSmallTimeout(6984);
		// 客户 
		solo.clickOnText(java.util.regex.Pattern.quote("客户"));
		solo.sleep(5000);
		// 代下单
		solo.clickOnView(solo.getView("btnOrderForAgent"));
		solo.sleep(15000);
		
		assertTrue("CorpCommodityPickActivity is not found!", solo.waitForActivity("CorpCommodityPickActivity"));
		// 搜索商品
		solo.clickOnView(solo.getView("action_search"));
		solo.sleep(5000);
		
		assertTrue("OrderForAgentSearchCommodityActivity is not found!", solo.waitForActivity("OrderForAgentSearchCommodityActivity"));
	
		solo.clickOnView(solo.getView("etWord"));
		// 输入商品'1234'
		solo.clearEditText((android.widget.EditText) solo.getView("etWord"));
		solo.enterText((android.widget.EditText) solo.getView("etWord"), "1234");
		// 搜索
		solo.clickOnView(solo.getView("btnSearch"));
		solo.sleep(8000);
		
		assertTrue("OrderForAgentSearchCommodityResultActivity is not found!", solo.waitForActivity("OrderForAgentSearchCommodityResultActivity"));
	
		solo.goBack();
	
		solo.goBack();
		
		solo.clickOnView(solo.getView(android.widget.FrameLayout.class, 17));
		// Click on 全部商品
		solo.clickInList(1, 1);
		solo.sleep(5000);
		
		solo.clickOnView(solo.getView(android.widget.FrameLayout.class, 17));
		// 按分类找商品
		solo.clickInList(2, 1);
		solo.sleep(5000);
		//  通用
		solo.clickInList(6, 0);
		solo.sleep(5000);
		
		assertTrue("OrderForAgentCommodityTypeSearchActivity is not found!", solo.waitForActivity("OrderForAgentCommodityTypeSearchActivity"));
	
		solo.goBack();
		
		solo.clickOnView(solo.getView(android.widget.FrameLayout.class, 11));

		// 退出代下单
		solo.clickOnView(solo.getView("btnExit"));
		solo.sleep(5000);
		// 代下单
		solo.clickOnView(solo.getView("btnOrderForAgent"));
		solo.sleep(15000);
	
		assertTrue("CorpCommodityPickActivity is not found!", solo.waitForActivity("CorpCommodityPickActivity"));
		// 点击快速加入购物车
		solo.clickOnView(solo.getView("ctvInShoppingCart2"));
	
		solo.waitForDialogToOpen(5000);
		// 点击增加
		solo.clickOnView(solo.getView("btn_add_count"));
	
		solo.clearEditText((android.widget.EditText) solo.getView("etPurchaseNum"));
		solo.enterText((android.widget.EditText) solo.getView("etPurchaseNum"), "2");
		//加入购物车
		solo.clickOnView(solo.getView("btnAddToShoppingCart"));
		solo.sleep(7000);
		// 点击购物车
		solo.clickOnView(solo.getView("action_orderforagent_shopping_cart"));
		solo.sleep(8000);
	
		assertTrue("CorpOrderForAgentShoppingCartActivity is not found!", solo.waitForActivity("CorpOrderForAgentShoppingCartActivity"));
		//  下单
		solo.clickOnView(solo.getView("btnCreateOrder"));
		solo.sleep(8000);
	
		assertTrue("GenerationOrderActivity is not found!", solo.waitForActivity("GenerationOrderActivity"));
		//  提交订单
		solo.clickOnView(solo.getView("btnCreateOrder"));
		solo.sleep(8000);
	
		assertTrue("GenerationOfOrderSuccessActivity is not found!", solo.waitForActivity("GenerationOfOrderSuccessActivity"));
		// 完成
		solo.clickOnView(solo.getView("btnFinished"));
		solo.sleep(8000);
		// 客户 
		solo.clickOnText(java.util.regex.Pattern.quote("客户"));
		solo.sleep(5000);
		// 代下单
		solo.clickOnView(solo.getView("btnOrderForAgent"));
		solo.sleep(8000);
	
		assertTrue("CorpCommodityPickActivity is not found!", solo.waitForActivity("CorpCommodityPickActivity"));
	
		solo.clickOnView(solo.getView("ctvInShoppingCart2"));
	
		solo.waitForDialogToOpen(5000);
	
		solo.clickOnView(solo.getView("btn_add_count"));
		
		solo.clearEditText((android.widget.EditText) solo.getView("etPurchaseNum"));
		solo.enterText((android.widget.EditText) solo.getView("etPurchaseNum"), "1");
		// 加入购物车
		solo.clickOnView(solo.getView("btnAddToShoppingCart"));
		solo.sleep(5000);
		
		solo.clickOnView(solo.getView("action_orderforagent_shopping_cart"));
		solo.sleep(8000);
	
		assertTrue("CorpOrderForAgentShoppingCartActivity is not found!", solo.waitForActivity("CorpOrderForAgentShoppingCartActivity"));
		//下单
		solo.clickOnView(solo.getView("btnCreateOrder"));
		solo.sleep(8000);
	
		assertTrue("GenerationOrderActivity is not found!", solo.waitForActivity("GenerationOrderActivity"));
		// 点击退货单
		solo.clickOnText(java.util.regex.Pattern.quote("退货单"));
	
		solo.clickOnView(solo.getView("etSaleReturnPrice"));
        //输入退单金额
		solo.clearEditText((android.widget.EditText) solo.getView("etSaleReturnPrice"));
		solo.enterText((android.widget.EditText) solo.getView("etSaleReturnPrice"), "1");
	
		solo.clickOnView(solo.getView("rl_orderReturnRemark"));
		
		solo.waitForDialogToOpen(5000);
		// 输入备注 'yyyyyy'
		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "yyyyyy");
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		// 提交订单
		solo.clickOnView(solo.getView("btnCreateOrder", 1));
		solo.sleep(8000);
		
		assertTrue("GenerationOfOrderSuccessActivity is not found!", solo.waitForActivity("GenerationOfOrderSuccessActivity"));
		//  完成
		solo.clickOnView(solo.getView("btnFinished"));
		solo.sleep(5000);
	   }
	}
