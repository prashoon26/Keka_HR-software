package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Helpdesk extends Positivelogin{

	public Helpdesk(String username, String password) {
		super(username,password);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void mh(){
	
		kekapass();
//		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

////		wWebElement invoice = driver.findElement(By.tagName("xhr-old-billing-pending-invoice-notification"));
//		if(driver.findElement(By.tagName("xhr-old-billing-pending-invoice-notification")).isDisplayed()) {
//			
//			driver.findElement(By.xpath("//div/button[@class = \"btn btn-secondary\"]")).click();
//		}
		
		
//		WebElement me = driver.findElement(By.xpath("//span[@class = \"ki-user sidebar-list-icon\"]"));
//		me.click();
//		WebElement hd = driver.findElement(By.cssSelector("li a[routerlink = 'helpdesk']"));
//		hd.click();
		
		
		
		try {
//			driver.findElement(By.tagName("xhr-old-billing-pending-invoice-notification"));
			
			driver.findElement(By.xpath("//div/button[@class = \"btn btn-secondary\"]")).click();
			
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			
		}
		finally {
			WebElement me = driver.findElement(By.xpath("//span[@class = \"ki-user sidebar-list-icon\"]"));
			me.click();
			WebElement hd = driver.findElement(By.cssSelector("li a[routerlink = 'helpdesk']"));
			hd.click();
			
		}
	}
	
	

}
