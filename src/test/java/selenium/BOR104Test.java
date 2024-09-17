package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BOR104Test {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver");

		driver = new ChromeDriver();

		try {

			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.xpath("//input[@data-test = 'username']")).sendKeys("standard_user");
			driver.findElement(By.xpath("//input[@data-test = 'password']")).sendKeys("secret_sauce");
			driver.findElement(By.xpath("//input[@data-test = 'login-button']")).click();
			driver.findElement(By.xpath("//button[@data-test ='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
			driver.findElement(By.xpath("//button[@data-test ='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
			driver.findElement(By.xpath("//button[@data-test ='add-to-cart-sauce-labs-backpack']")).click();
			driver.findElement(By.xpath("//button[@data-test ='add-to-cart-sauce-labs-bike-light']")).click();

			driver.findElement(By.xpath("//a[@class ='shopping_cart_link']")).click();
			driver.findElement(By.xpath("//button[@data-test = 'checkout']")).click();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}