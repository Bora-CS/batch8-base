import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitPushTest {
	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		 driver = new ChromeDriver();
		try {
			driver.navigate().to("https://jqueryui.com/");
			driver.findElement(By.linkText("Menu")).click();
			driver.switchTo().frame(0);
			driver.findElement(By.id("ui-id-2")).click();
			
			System.out.println("Pass haha, I would like to see pass :)");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.quit();
		}
		
		
		

}}