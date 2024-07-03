package Login;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateTicket extends Helpdesk {

	@Parameters({ "username", "password" })
	public CreateTicket(String username, String password) {
		super(username, password);
	}

	public void category() {
		mh();
		WebDriver driver = getDriver();

		driver.findElement(By.cssSelector("div button[class = 'btn btn-primary' ]")).click();

		List<WebElement> cat = driver.findElements(By.cssSelector("div[class= \"dropdown-item ng-star-inserted\"]"));

		for (WebElement option : cat) {
			driver.findElement(By.cssSelector("div[class = 'd-flex flex-wrap']")).click();
			option.click();
		}
	}

	@BeforeTest
	public void createticket() throws InterruptedException {
		category();
		driver.findElement(By.xpath("//input[@formcontrolname = \"title\"]")).sendKeys("dssdfsdf");
		driver.findElement(By.xpath("//div[@class = \"ql-editor ql-blank\"]")).sendKeys("prashoon");
		driver.findElement(By.xpath("//div/button[@class = 'btn btn-primary' and contains(text(), 'Raise ticket')]"))
				.click();

		String toast = driver
				.findElement(By.xpath(
						"//div[@class = 'message ng-tns-c73-2' and contains(text(), 'Ticket added successfully')]"))
				.getText();
		driver.findElement(By.xpath("//div[@class = 'overflow-auto h-500 pr-8']")).click();

	}

	@Test
	public void allticketaction() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div.ql-editor.ql-blank")).sendKeys("Hii prashoon this side");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div/button[@class = \"btn btn-primary btn-sm mx-8\"]")));

		driver.findElement(By.xpath("//div/button[@class = \"btn btn-primary btn-sm mx-8\"]")).click();
		driver.findElement(By.xpath("//div[@class='app-container']")).click();
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ki ki-arrow-backward ki-xs mr-4 text-link']")).click();

	}

	@Test
	public void openallticket() {
		List<WebElement> tck = driver.findElements(By.cssSelector("helpdesk-me-open-ticket-list .text-link"));

		List<WebElement> element = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.cssSelector("helpdesk-me-open-ticket-list .text-link")));

		int i = 0;
		while (i < 3) {

			try {
				wait.until(ExpectedConditions
						.presenceOfAllElementsLocatedBy(By.cssSelector("helpdesk-me-open-ticket-list .text-link")));

				wait.until(ExpectedConditions.elementToBeClickable(element.get(i)));
				System.out.println(element.get(i).getText());
				element.get(i).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[@class='ki ki-arrow-backward ki-xs mr-4 text-link']")));

				driver.findElement(By.xpath("//span[@class='ki ki-arrow-backward ki-xs mr-4 text-link']")).click();

			} catch (StaleElementReferenceException e) {

			}
			i++;
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ki ki-arrow-backward ki-xs mr-4 text-link']")));
//			
//			driver.findElement(By.xpath("//span[@class='ki ki-arrow-backward ki-xs mr-4 text-link']")).click();

		}
	}
}
