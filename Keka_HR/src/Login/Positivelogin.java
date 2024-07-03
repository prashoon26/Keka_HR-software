package Login;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Positivelogin {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	private String email;
	private String password;
	
	public Positivelogin(String username, String password) {
	
		this.email = username;
		this.password = password;

	    driver = new ChromeDriver();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	

	public void init() {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://login.kekastage.com/Account/Login?ReturnUrl=%2F";
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id= \"email\"]")).sendKeys(this.email);
		driver.findElement(By.xpath("//button[@class = \"btn btn-primary mt-10 border-0\"]")).click();
		
	}
	
	
	public void kekapass() {
		init();
		driver.findElement(By.xpath("//div[@class = 'login-option'][3]")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys("wqe");
		driver.findElement(By.xpath("//button[@class='btn btn-primary mt-10 border-0']")).click();

	}

}
