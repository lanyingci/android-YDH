package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Commodity001 extends ActivityInstrumentationTestCase2 {
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
    public Commodity001() throws ClassNotFoundException {
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
  
	public void testCommodity001() {
		
		//等待"WelcomeActivity"，2000毫秒
		solo.waitForActivity("WelcomeActivity", 2000);
		
		solo.sleep(120000);
	
		assertTrue("MainActivity is not found!", solo.waitForActivity("MainActivity"));
		//点击商品分类
		solo.clickOnView(solo.getView("btnCommodityType"));
		solo.sleep(15000);
		
		assertTrue("CommodityTypeActivity is not found!", solo.waitForActivity("CommodityTypeActivity"));
		// 点击全部商品
		solo.clickOnView(solo.getView("rlCurrentType"));
		solo.sleep(15000);
		
		assertTrue("CommodityTypeSubActivity is not found!", solo.waitForActivity("CommodityTypeSubActivity"));
		//点击商品筛选
		solo.clickOnView(solo.getView("tvCommodityChoose")); 
		solo.waitForDialogToOpen(5000);
		//点击确定
		solo.clickOnView(solo.getView("tvCommodityChooseSure"));
		solo.sleep(15000);
	    //点击商品排序
		solo.clickOnView(solo.getView("tvCommoditySort"));

		solo.waitForDialogToOpen(5000);
        
		solo.clickOnView(solo.getView("rlCommoditySortTitle"));
		solo.sleep(7000);
        //点击大小图切换
		solo.clickOnView(solo.getView("btnChangeToList"));
		solo.sleep(7000);
		// 点击返回
		solo.goBack();
		solo.sleep(5000);
		// 点击返回
		solo.goBack();
		solo.sleep(5000);
		// 点击商品搜索
		solo.clickOnView(solo.getView("rlSearchCommodity"));
		solo.sleep(5000);
		
		assertTrue("SearchInputActivity is not found!", solo.waitForActivity("SearchInputActivity"));
		//点击商品输入框
		solo.clickOnView(solo.getView("etWord"));
		// 输入 '123'
		solo.clearEditText((android.widget.EditText) solo.getView("etWord"));
		solo.enterText((android.widget.EditText) solo.getView("etWord"), "123");
		// 点击搜索
		solo.clickOnView(solo.getView("btnSearch"));
		solo.sleep(7000);

		assertTrue("SearchResultActivity is not found!", solo.waitForActivity("SearchResultActivity"));
		// 点击返回
		solo.goBack();
		solo.sleep(5000);
		// 点击返回
		solo.goBack();
		solo.sleep(5000);
		// 点击促销商品
		solo.clickOnView(solo.getView("flPromotionCommodity"));
		solo.sleep(7000);
		
		assertTrue("SalesPromotionCommodityActivity is not found!", solo.waitForActivity("SalesPromotionCommodityActivity"));
		// 点击返回
		solo.goBack();
		solo.sleep(5000);
		//点击收藏商品
		solo.clickOnView(solo.getView("flCollectionCommodity"));
		solo.sleep(7000);
	
		assertTrue("CollectionCommodityActivity is not found!", solo.waitForActivity("CollectionCommodityActivity"));
	    //点击管理收藏夹
		solo.clickOnView(solo.getView("btnManageCollection"));
		solo.sleep(5000);
	    //点击返回
		solo.goBack();
		solo.sleep(5000);
	    //点击最近订购
		solo.clickOnView(solo.getView("flLastOrder"));
		solo.sleep(7000);

		assertTrue("LastOrderActivity is not found!", solo.waitForActivity("LastOrderActivity"));
        //返回
		solo.goBack();
		solo.sleep(5000);
	    //再次购买
		solo.clickOnView(solo.getView("flCopyOrder"));
		solo.sleep(7000);
	
		assertTrue("OrderCopyActivity is not found!", solo.waitForActivity("OrderCopyActivity"));
        //返回
		solo.goBack();
		solo.sleep(5000);
        //商品列表
		android.widget.ListView listView0 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
		solo.scrollListToLine(listView0, 0);
	    //点击快速加入购物车
		solo.clickOnView(solo.getView("ctvInShoppingCart2"));
        //等待快速加入购物车弹框出现
		solo.waitForDialogToOpen(15000);

		solo.clickOnView(solo.getView("btn_add_count"));
		// 输入数量 '1'
		solo.clearEditText((android.widget.EditText) solo.getView("etPurchaseNum"));
		solo.enterText((android.widget.EditText) solo.getView("etPurchaseNum"), "1");
		//点击加入购物车
		solo.clickOnView(solo.getView("btnAddToShoppingCart"));
		solo.sleep(9000);
	    //点击商品进入详情
		solo.clickInList(2, 0);
		solo.sleep(15000);

		assertTrue("CommodityDetailActivity is not found!", solo.waitForActivity("CommodityDetailActivity"));
        //收藏商品
		solo.clickOnView(solo.getView("btnCollect"));
        //取消收藏
		solo.clickOnView(solo.getView("cancelCollect"));
		
		solo.goBack();
		solo.sleep(7000);
	}
}
