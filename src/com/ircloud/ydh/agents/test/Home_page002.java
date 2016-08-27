package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Home_page002 extends ActivityInstrumentationTestCase2 {
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
    public Home_page002() throws ClassNotFoundException {
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
  
	public void testHome_page002() {
		
		solo.waitForActivity("WelcomeActivity", 2000);
		solo.sleep(50000);

		
		assertTrue("CorpMainActivity is not found!", solo.waitForActivity("CorpMainActivity"));
	
		Timeout.setSmallTimeout(3362);
		// 今天 
		solo.clickOnView(solo.getView("rlToday"));
		solo.sleep(5000);
		
		assertTrue("CorpOrderSearchResultListWithTitleActivity is not found!", solo.waitForActivity("CorpOrderSearchResultListWithTitleActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		// 昨天 
		solo.clickOnView(solo.getView("rlYesterday"));
		solo.sleep(5000);

		assertTrue("CorpOrderSearchResultListWithTitleActivity is not found!", solo.waitForActivity("CorpOrderSearchResultListWithTitleActivity"));
		solo.sleep(5000);

		solo.goBack();
		solo.sleep(5000);
		
		// 本月
		solo.clickOnView(solo.getView("rlThisMonth"));
		solo.sleep(5000);
	
		assertTrue("CorpOrderSearchResultListWithTitleActivity is not found!", solo.waitForActivity("CorpOrderSearchResultListWithTitleActivity"));
	
		solo.goBack();
		solo.sleep(5000);
		// 月度 销售看板
		solo.clickOnView(solo.getView("llSellMonthlyBoard"));
		solo.sleep(5000);
		
		assertTrue("CorpSellMonthlyBoardActivity is not found!", solo.waitForActivity("CorpSellMonthlyBoardActivity"));

		solo.goBack();
		solo.sleep(5000);
		//  商品 销售看板
		solo.clickOnView(solo.getView("llGoodsSellBoard"));
		solo.sleep(5000);
	
		assertTrue("CorpGoodsSellBoardActivity is not found!", solo.waitForActivity("CorpGoodsSellBoardActivity"));
		// 看板设置
		solo.clickOnView(solo.getView("action_boardsetting"));
		solo.sleep(5000);

		assertTrue("CorpGoodsSellBoardSettingActivity is not found!", solo.waitForActivity("CorpGoodsSellBoardSettingActivity"));
		// 查询
		solo.clickOnView(solo.getView("btnSearch"));
		solo.sleep(5000);
	
		solo.goBack();
		solo.sleep(5000);
		//  地区 销售看板
		solo.clickOnView(solo.getView("llAreaSellBoard"));
		solo.sleep(5000);
	
		assertTrue("CorpAreaSellBoardActivity is not found!", solo.waitForActivity("CorpAreaSellBoardActivity"));
		// 看板设置
		solo.clickOnView(solo.getView("action_boardsetting"));
		solo.sleep(5000);
	
		assertTrue("CorpAreaSellBoardSettingActivity is not found!", solo.waitForActivity("CorpAreaSellBoardSettingActivity"));
		// 查询
		solo.clickOnView(solo.getView("btnSearch"));
		solo.sleep(5000);

		solo.goBack();
		//  客户 订货看板
		solo.clickOnView(solo.getView("llRetailerOrderBoard"));
		solo.sleep(5000);
		
		assertTrue("CorpRetailerOrderBoardActivity is not found!", solo.waitForActivity("CorpRetailerOrderBoardActivity"));
		//  看板设置
		solo.clickOnView(solo.getView("action_boardsetting"));
		solo.sleep(5000);
		
		assertTrue("CorpRetailerOrderBoardSettingActivity is not found!", solo.waitForActivity("CorpRetailerOrderBoardSettingActivity"));
		//  查询
		solo.clickOnView(solo.getView("btnSearch"));
		solo.sleep(5000);
		
		solo.goBack();
		solo.sleep(5000);
	}
}
