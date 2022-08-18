package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class Practice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions action = new Actions(driver);

		try {
			driver.get("https://jqueryui.com/resizable/");
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

			List<WebElement> boxHandles = driver.findElements(By.xpath("//div[@id='resizable']/div"));
			WebElement rightEdge = boxHandles.get(0);
			WebElement bottomEdge = boxHandles.get(1);
			WebElement corner = boxHandles.get(2);

			action.clickAndHold(rightEdge).moveByOffset(100, 0).release().build().perform();
			action.clickAndHold(bottomEdge).moveByOffset(0, 100).release().build().perform();
			action.clickAndHold(corner).moveByOffset(100, 100).release().build().perform();

			Utilities.wait(5);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
