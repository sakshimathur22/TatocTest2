package org.seleniumhq.selenium.Maven3;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionClass {
	WebDriver driver; 
	

	
	public void  Test_1_tatoc_page_1() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sakshimathur\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
	}
	

	
	
	public void Test_3_GreenBox() {
		driver.findElement(By.className("greenbox")).click();
	} 
	
	public void Test_4_check_color() {
		driver.switchTo().frame(driver.findElement(By.id("main")));
		String Box1 = driver.findElement(By.id("answer")).getAttribute("class");
		String Box2 = null;
		do {
			driver.switchTo().frame(driver.findElement(By.cssSelector("iFrame#child")));
			Box2 = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			if(Box1.equals(Box2)){
				driver.findElement(By.linkText("Proceed")).click();
				break;
			}
			else driver.findElement(By.linkText("Repaint Box 2")).click();
		}
		while(!Box1.equals(Box2));
	
}	
	public void Test_5_check_dragdrop() {
	WebElement Drag=driver.findElement(By.id("dragbox"));
	WebElement Drop=driver.findElement(By.id("dropbox"));
	Actions builder=new Actions(driver);
	builder.dragAndDrop(Drag, Drop).build().perform();
	driver.findElement(By.linkText("Proceed")).click();
}

	public void Test_6_popup() {
	
	String parentWindow = driver.getWindowHandle();
	driver.findElement(By.linkText("Launch Popup Window")).click();


	String childWindow = null;


	for (String handle1 : driver.getWindowHandles()) {
		childWindow = handle1;
		System.out.println(handle1);
		driver.switchTo().window(handle1);
	}
	driver.switchTo().window(childWindow);
	driver.findElement(By.id("name")).sendKeys("hello");
	driver.findElement(By.id("submit")).click();
	driver.switchTo().window(parentWindow);
	driver.findElement(By.linkText("Proceed")).click();
}
public void  Test_7generateToken(){
	
	driver.findElement(By.linkText("Generate Token")).click();
    String token1 = driver.findElement(By.id("token")).getText();
    String token = token1.substring(token1.indexOf(":")+2);
    Cookie cookie = new Cookie("Token",token);
    driver.manage().addCookie(cookie);
    driver.findElement(By.linkText("Proceed")).click();
}

}
