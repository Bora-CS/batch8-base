package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomTest {
	public static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			try {
				driver.get("https://www.saucedemo.com/");
				
				driver.findElement(By.id("user-name")).sendKeys("standard_user" + Keys.ENTER);
				driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER);
				
				driver.findElement(By.id("login-button")).click();
				
				 List<WebElement> items = driver.findElements(By.xpath("//*[@class=\"btn btn_primary btn_small btn_inventory\"]"));
				 
				 
				 
				for (WebElement item : items) {
					item.click();
					
				}
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				driver.quit();
			}
		
	}

}
