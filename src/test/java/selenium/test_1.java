package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://jqueryui.com/");
			driver.findElement(By.linkText("Accordion")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.id("ui-id-1")).click();
			String Text = driver.findElement(By.id("ui-id-2")).getText();
			System.out.println(Text);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();

		}

	}

}
