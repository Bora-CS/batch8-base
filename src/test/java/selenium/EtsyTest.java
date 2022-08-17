package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Utilities;

public class EtsyTest {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		try {
			driver = new ChromeDriver();
			driver.get("https://www.etsy.com/");
			Utilities.wait(1);
			Utilities.rememberMainWindowHandle(driver);
			driver.findElement(By.xpath(
					"(//p[@class=\"wt-text-title-01 wt-text-center-xs wt-text-truncate--multi-line wt-text-black query-with-image-text wt-mb-xs-1 wt-hide-xs wt-show-lg\"])[2]"))
					.click();
			Utilities.wait(2);
//			Utilities.switchOntoNewWindow(driver);
			driver.findElement(By.xpath("//*[@class=\"wt-btn wt-btn--outline wt-pl-xs-7 wt-pr-xs-7 wt-mt-xs-4\"]"))
					.click();
			WebElement dropbox = driver.findElement(By.id("variation-selector-0"));
			dropbox.click();
			Select drop = new Select(dropbox);
			drop.selectByIndex(3);
			Utilities.wait(5);
			driver.findElement(By.xpath("(//*[@class=\"wt-btn wt-btn--filled wt-width-full\"])[1]")).click();
			Utilities.wait(3);
			driver.navigate().refresh();
			Utilities.wait(2);
			driver.navigate().back();
			Utilities.wait(3);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}
}
