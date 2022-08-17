package utils;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	private static String mainHandle = null;
	
	public static WebDriver driver;

	public Utilities(WebDriver passedDriver) {
		passedDriver = driver;
	}

	public static void fullscreen() {
		driver.manage().window().fullscreen();
	}

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkIfElementExists_V1(WebDriver driver, By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean checkIfElementExists_V2(WebDriver driver, By locator) {
		List<WebElement> elements = driver.findElements(locator);
		return elements.size() > 0 && elements.get(0).isDisplayed();
	}

	public static void rememberMainWindowHandle(WebDriver driver) {
		mainHandle = driver.getWindowHandle();
	}

	public static void switchOntoNewWindow(WebDriver driver) {
		rememberMainWindowHandle(driver);
		Set<String> handles = driver.getWindowHandles();
		String newHandle = null;
		for (String handle : handles) {
			if (!handle.equals(mainHandle)) {
				newHandle = handle;
			}
		}
		driver.switchTo().window(newHandle);
	}

	public static void closeAndReturnToMainWindow(WebDriver driver) {
		if (driver.getWindowHandles().size() > 1) {
			String currentWindowHandle = driver.getWindowHandle();
			if (!currentWindowHandle.equals(mainHandle)) {
				driver.close();
				driver.switchTo().window(mainHandle);
			}
		}
	}

	public static void dragAndDrop(WebDriver driver, By sourceLocator, By targetLocator) {
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(sourceLocator);
		WebElement target = driver.findElement(targetLocator);
		action.dragAndDrop(source, target).build().perform();
	}

	public static void hover(WebDriverWait wait, Actions action, By locator, boolean shouldClick) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement target = wait.until(ExpectedConditions.elementToBeClickable(locator));
		action.moveToElement(target).build().perform();
		if (shouldClick) {
			target.click();
		}
	}
}
