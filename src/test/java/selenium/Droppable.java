package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Droppable {
	public static WebDriver driver;

	public static void main(String[] args) {
		testDefault();
	}

	public static void testDefault() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		try {
			driver.get("https://jqueryui.com/");
			driver.findElement(By.linkText("Droppable")).click();
			WebElement iFrame = driver.findElement(By.className("demo-frame"));
			driver.switchTo().frame(iFrame);

			WebElement source = driver.findElement(By.id("draggable"));
			WebElement target = driver.findElement(By.id("droppable"));

			Actions action = new Actions(driver);
			action.dragAndDrop(source, target).build().perform();
			driver.switchTo().defaultContent();
			customeWait(3);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	public static void customeWait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}