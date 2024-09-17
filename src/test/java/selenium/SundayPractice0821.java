package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SundayPractice0821 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Actions action = new Actions(driver);

		try {

			driver.get("https://jqueryui.com/");

			driver.findElement(By.linkText("Resizable")).click();

			driver.switchTo().frame(0);

			Actions boraAction = new Actions(driver);

			WebElement movePoint = driver.findElement(By.xpath("//*[@id='resizable']//*[contains(@class,'ui-icon')]"));

			boraAction.moveToElement(movePoint).clickAndHold().moveByOffset(100, 0).release().build().perform();

			wait(1);

			boraAction.dragAndDropBy(movePoint, -100, 100);

			wait(1);

			boraAction.clickAndHold(movePoint).moveByOffset(200, 100).build().perform();

			wait(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
