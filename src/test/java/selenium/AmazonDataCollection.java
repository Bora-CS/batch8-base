package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pojo.SearchResult;
import utils.ExcelUtilities;
import utils.Utilities;

public class AmazonDataCollection {
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static String searchTerm = "iPhone 13 Case";
	public static int pageNumber = 1;
	public static int count = 1;
	public static ArrayList<SearchResult> searchResults;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		searchResults = new ArrayList<SearchResult>();

		try {
			driver.get("https://www.amazon.com/");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchTerm + Keys.ENTER);
			System.out.println("==> Searching for - " + searchTerm);

			while (count < 100) {
				// start collection
				String resultParentsXpath = "(//div[@data-component-type='s-search-result'])";
				List<WebElement> results = driver.findElements(By.xpath(resultParentsXpath));

				for (int index = 1; index <= results.size(); index++) {
					String titleXpath = resultParentsXpath + "[" + index + "]"
							+ "//div[contains(@class, 's-title-instructions-style')]//h2";
					String priceXpath = resultParentsXpath + "[" + index + "]" + "//span[@class='a-price']";
					String title = driver.findElement(By.xpath(titleXpath)).getText();
					String priceText = null;
					try {
						priceText = driver.findElement(By.xpath(priceXpath)).getText();
					} catch (NoSuchElementException e) {
						continue;
					}
					priceText = priceText.replace("\n", ".").replace("$", "");
					double price = Double.valueOf(priceText);
					searchResults.add(new SearchResult(count++, price, title));
					if (count == 101) {
						break;
					}
				}

				if (count < 100) {
					driver.findElement(By.cssSelector("a.s-pagination-next")).click();
					pageNumber++;
					Utilities.wait(5);
				}
			}

			ExcelUtilities.writeResultToExcel(searchTerm, searchResults);

		} catch (Exception e) {
			System.out.println("[FAILED] - " + e.getMessage());
		} finally {
			driver.quit();
		}

	}
}
