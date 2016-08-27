package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Commodity002 extends ActivityInstrumentationTestCase2 {
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
    public Commodity002() throws ClassNotFoundException {
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
  
	public void testCommodity002() {
		
		solo.waitForActivity("WelcomeActivity", 2000);
		solo.sleep(90000);
	
		assertTrue("CorpMainActivity is not found!", solo.waitForActivity("CorpMainActivity"));
		
		Timeout.setSmallTimeout(3251);
	    //点击商品
		solo.clickOnText(java.util.regex.Pattern.quote("商品"));
		solo.sleep(15000);
		
	    //商品查询
		solo.clickOnView(solo.getView("llSearchProduct"));
		solo.sleep(5000);

		assertTrue("CorpSearchActivity is not found!", solo.waitForActivity("CorpSearchActivity"));

		solo.clickOnView(solo.getView("content"));
        //输入商品123
		solo.clearEditText((android.widget.EditText) solo.getView("content"));
		solo.enterText((android.widget.EditText) solo.getView("content"), "123");
	    //点击查询
		solo.sendKey(solo.ENTER);
		
		solo.sleep(10000);
	
		solo.goBack();
		solo.sleep(5000);
		
	    //点击促销商品
		solo.clickOnView(solo.getView("llSalesPromotionCommodity"));
		solo.sleep(10000);

		assertTrue("CorpSalesPromotionCommodityActivity is not found!", solo.waitForActivity("CorpSalesPromotionCommodityActivity"));
	
		solo.goBack();
		solo.sleep(5000);
	    //商品分类
		solo.clickOnView(solo.getView("llCommodityType"));
		solo.sleep(10000);

		assertTrue("CorpCommodityTypeActivity is not found!", solo.waitForActivity("CorpCommodityTypeActivity"));
      
		solo.clickInList(9, 0);
		solo.sleep(10000);

		assertTrue("CorpCommodityTypeSubActivity is not found!", solo.waitForActivity("CorpCommodityTypeSubActivity"));

		solo.goBack();
		solo.sleep(3000);

		solo.goBack();
		solo.sleep(5000);
        //新建商品
		solo.clickOnView(solo.getView("btn_append_product"));
		solo.sleep(10000);

		assertTrue("CropAppendCommodityActivity is not found!", solo.waitForActivity("CropAppendCommodityActivity"));
        //商品名称
		solo.clickOnView(solo.getView("rl_product_name"));

		solo.waitForDialogToOpen(5000);

		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "aaa001");

		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
	    //商品分类
		solo.clickOnView(solo.getView("rl_product_classify_setting"));
		solo.sleep(5000);

		assertTrue("CorpAppendCommodityTypeActivity is not found!", solo.waitForActivity("CorpAppendCommodityTypeActivity"));

		solo.clickInList(8, 0);
		solo.sleep(5000);
        //品牌
		solo.clickOnView(solo.getView("rl_product_brand"));
		solo.sleep(5000);

		assertTrue("CorpProductBrandActivity is not found!", solo.waitForActivity("CorpProductBrandActivity"));

		solo.clickOnView(solo.getView("btn_add_standard"));
	
		solo.waitForDialogToOpen(5000);

		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "aaa");

		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(8000);
	
		solo.clickInList(2, 0);
		solo.sleep(5000);
         //商品介绍
		solo.clickOnView(solo.getView("rl_product_present"));

		solo.waitForDialogToOpen(5000);

		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "aaa001");

		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
       
		
		//价格设置
		solo.clickOnView(solo.getView("rl_product_price_setting"));
		solo.sleep(5000);

		assertTrue("CorpPriceSettingActivity is not found!", solo.waitForActivity("CorpPriceSettingActivity"));
	
		solo.clickOnView(solo.getView("rlMarketPrice"));

		solo.waitForDialogToOpen(5000);

		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "100");

		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);

		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
        //规格属性
		solo.clickOnView(solo.getView("rl_product_standard_property"));
		solo.sleep(7000);
	
		assertTrue("CorpProductStandardPropertyActivity is not found!", solo.waitForActivity("CorpProductStandardPropertyActivity"));
		
        //规格名称
		solo.clickOnText("^规格名称$");

		solo.waitForDialogToOpen(5000);
	
		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "颜色");

		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
        //规格值
		solo.clickOnView(solo.getView("rl_product_standard_value"));

		solo.waitForDialogToOpen(5000);

		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "红");

		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);

		solo.clickOnView(solo.getView("action_make_sure"));

		solo.waitForDialogToOpen(5000);

		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
	     //商品编码/条形码
		solo.clickOnView(solo.getView("rl_product_code"));
		solo.sleep(5000);

		assertTrue("CorpCommodityCodeAndBarCodeActivity is not found!", solo.waitForActivity("CorpCommodityCodeAndBarCodeActivity"));

		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
        //单位
		solo.clickOnView(solo.getView("rl_product_unit"));

		solo.waitForDialogToOpen(5000);

		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "个");
	
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
        //重量
		solo.clickOnView(solo.getView("rl_product_weight"));

		solo.waitForDialogToOpen(5000);

		solo.clearEditText((android.widget.EditText) solo.getView("fetContent"));
		solo.enterText((android.widget.EditText) solo.getView("fetContent"), "10");
	
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);
        //保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(35000);
	
		Timeout.setSmallTimeout(5631);
         //点击商品列表进入详情
		solo.clickInList(3, 2);
		solo.sleep(35000);

		assertTrue("CorpCommodityDetailActivity is not found!", solo.waitForActivity("CorpCommodityDetailActivity"));
	    //点击更多操作
		solo.clickOnView(solo.getView("commodity_detail_more_button"));
		solo.sleep(5000);
		//点击修改商品
		solo.clickOnView(solo.getView("corp_commodity_modify"));
		solo.sleep(5000);
	
		assertTrue("CropModityCommodityActivity is not found!", solo.waitForActivity("CropModityCommodityActivity"));
	    //点击保存
		solo.clickOnView(solo.getView("action_save"));
		solo.sleep(35000);
	
		solo.goBack();
		solo.sleep(5000);
	}
}
