package com.ircloud.ydh.agents.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class Experience extends ActivityInstrumentationTestCase2 {
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
    public Experience() throws ClassNotFoundException {
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
  
	public void testExperience() {
		solo.waitForActivity("WelcomeActivity", 2000);
		solo.sleep(10000);
	    //点击快速体验
		solo.clickOnView(solo.getView("experience"));
		solo.sleep(5000);
		
		assertTrue("ManyIndustryExperienceActivity is not found!", solo.waitForActivity("ManyIndustryExperienceActivity"));
		// 食品
		solo.clickInList(1, 0);
		solo.sleep(5000);
		
		assertTrue("ChooseRoleActivity is not found!", solo.waitForActivity("ChooseRoleActivity"));
		// 销售商订货系统
		solo.clickOnText(java.util.regex.Pattern.quote("销售商订货系统"));
		solo.sleep(5000);
		
		assertTrue("ExperienceExplainActivity is not found!", solo.waitForActivity("ExperienceExplainActivity"));
		// 立即体验
		solo.clickOnView(solo.getView("experience"));
		solo.sleep(90000);
		
		assertTrue("MainActivity is not found!", solo.waitForActivity("MainActivity"));
		
		//我的
		solo.clickOnView(solo.getView(android.widget.RelativeLayout.class, 30));
		solo.sleep(5000);
		// 切换账号
		solo.clickOnText(java.util.regex.Pattern.quote("切换账号"));
	
		solo.waitForDialogToOpen(5000);
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(9000);
		
		assertTrue("LoginActivity is not found!", solo.waitForActivity("LoginActivity"));
		// 快速体验  
		solo.clickOnView(solo.getView("experience"));
		solo.sleep(5000);
		
		assertTrue("ManyIndustryExperienceActivity is not found!", solo.waitForActivity("ManyIndustryExperienceActivity"));
		// 个护化妆
		solo.clickInList(3, 0);
		solo.sleep(5000);
	
		assertTrue("ChooseRoleActivity is not found!", solo.waitForActivity("ChooseRoleActivity"));
		//公司管理系统
		solo.clickOnText(java.util.regex.Pattern.quote("公司管理系统"));
		solo.sleep(5000);
		
		assertTrue("ExperienceExplainActivity is not found!", solo.waitForActivity("ExperienceExplainActivity"));
		// 立即体验
		solo.clickOnView(solo.getView("experience"));
		solo.sleep(90000);

		assertTrue("CorpMainActivity is not found!", solo.waitForActivity("CorpMainActivity"));
		//点击更多
		solo.clickOnView(solo.getView("action_more"));
		solo.sleep(5000);
	
		assertTrue("CorpSettingActivity is not found!", solo.waitForActivity("CorpSettingActivity"));
		// 切换账号
		solo.clickOnText(java.util.regex.Pattern.quote("切换账号"));
		
		solo.waitForDialogToOpen(5000);
		// 确定
		solo.clickOnView(solo.getView("btnOK"));
		solo.sleep(5000);

		assertTrue("LoginActivity is not found!", solo.waitForActivity("LoginActivity"));
		solo.sleep(5000);
		
	}
	
}