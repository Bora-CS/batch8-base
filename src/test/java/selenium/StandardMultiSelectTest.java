package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StandardMultiSelectTest {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		try {
			driver.get("https://demoqa.com/select-menu");
			driver.manage().window().maximize();

			WebElement standardMultiSelectBase = driver.findElement(By.id("cars"));
			Select standardMultiSelect = new Select(standardMultiSelectBase);

			// select all the options
			List<WebElement> options = standardMultiSelect.getOptions();
			for (int i = 0; i < options.size(); i++) {
				standardMultiSelect.selectByIndex(i);
			}

			// print all the selected options
			List<WebElement> selectedOptions = standardMultiSelect.getAllSelectedOptions();
			for (int i = 0; i < selectedOptions.size(); i++) {
				System.out.println("Selected Option " + (i + 1) + ": " + selectedOptions.get(i).getText());
			}

			// deselet by visible text
			standardMultiSelect.deselectByVisibleText("Audi");
			// deselect all

			System.out.println("---------AFTER DESELECT---------");

			// get all the selected options
			selectedOptions = standardMultiSelect.getAllSelectedOptions();
			if (selectedOptions.size() == 0) {
				System.out.println("There is no option selected");
			} else {
				for (int i = 0; i < selectedOptions.size(); i++) {
					System.out.println("Selected Option " + (i + 1) + ": " + selectedOptions.get(i).getText());
				}
			}

			System.out.println("[Passed]");
		} catch (Exception e) {
			System.out.println("[Failed- " + e.getMessage() + "]");
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}