package org.seleniumhq.selenium.Maven3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tatocngTest  {
	
		ActionClass ac=new ActionClass();
	
		@Test(priority=0)
		public void  Testing_Test_1_tatoc_page_1() {
			ac.Test_1_tatoc_page_1();
			Assert.assertTrue(ac.driver.getCurrentUrl().contains("http://10.0.1.86/tatoc"));
	}
		@Test(priority=1)
	public void Testing_Test_3_GreenBox() {
			ac.Test_3_GreenBox();
			//Assert.assertTrue(ac.driver.getCurrentUrl().contains("frame/dungeon"));
		
		}@Test(priority=2)
		public void Testing_Test_4_check_color() {
		ac.Test_4_check_color();	
		Assert.assertTrue(ac.driver.getCurrentUrl().contains("drag"));
		}
		@Test(priority=3)
		public void Testing_Test_5_check_dragdrop() {
			ac.Test_5_check_dragdrop();
			Assert.assertTrue(ac.driver.getCurrentUrl().contains("/windows"));
		}
		@Test(priority=4)
		public void Testing_Test_6__popup() {
			ac.Test_6_popup();
			Assert.assertTrue(ac.driver.getCurrentUrl().contains("/cookie"));
		}@Test(priority=5)
		public void Testing_Test_7generateToken(){
			ac.Test_7generateToken();
			Assert.assertTrue(ac.driver.getCurrentUrl().contains("/end"));
		}
}