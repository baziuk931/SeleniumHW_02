package HomeWork7;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHW2 {

	public static void main(String[] args) {

		buttons();
		waitToDisappear();
		waitForTextChange();
		radioButtons();
		checkboxes();
	}

	public static void buttons() {

		String testUrl = "http://www.leafground.com/pages/Button.html";

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to(testUrl);
		// task 1
		System.out.println("Page 'Button'. Task 1");

		driver.findElement(By.id("home")).click();
		driver.navigate().back();

		// task 2
		System.out.println("Page 'Button'. Task 2");

		Actions action2 = new Actions(driver);
		action2.keyDown(Keys.CONTROL).perform();
		WebElement element = driver.findElement(By.id("position"));
		element.click();
		System.out.println(element.getLocation());

		// task 3
		System.out.println("Page 'Button'. Task 3");

		WebElement element3 = driver.findElement(By.id("color"));
		System.out.println(element3.getAttribute("style"));

		// task 4
		System.out.println("Page 'Button'. Task 4");

		WebElement element4 = driver.findElement(By.id("size"));
		System.out.println(element4.getSize());

		System.out.println("=====================================");
	}

	public static void waitToDisappear() {

		ChromeDriver driver = new ChromeDriver();
		By buttonSelector = By.id("btn");
		String expectedText = "I know you can do it! Button is disappeared!";
		String actualText = "";

		driver.navigate().to("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();

		System.out.println("Page 'Wait To Disappear'");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(buttonSelector));

		WebElement element;
		element = driver.findElement(By.xpath("//*[@id=\"show\"]/p/strong"));
		actualText = element.getText();

		if (expectedText.contentEquals(actualText)) {
			System.out.println("pass");
		} else {
			System.out.println("failed");
		}

		System.out.println("=====================================");
	}

	public static void waitForTextChange() {

		ChromeDriver driver = new ChromeDriver();
		By Selector = By.xpath("//*[@id=\"btn\"]");
		String expectedText = "Click ME!";
		String actualText = "";

		driver.navigate().to("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();

		System.out.println("Page 'Wait For Text Change'");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(Selector, expectedText));

		WebElement el1;
		el1 = driver.findElement(By.xpath("//*[@id=\"btn\"]"));
		actualText = el1.getText();

		if (expectedText.contentEquals(actualText)) {
			WebElement el2 = driver.findElement(By.xpath("//*[@id=\"btn\"]"));
			el2.click();
		} else {
			System.out.println("Button has wrong text");
		}

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String text = alert.getText();
		System.out.println(text);

		System.out.println("=====================================");

	}

	public static void radioButtons() {

		ChromeDriver driver = new ChromeDriver();
		String url = "http://www.leafground.com/pages/radio.html";

		driver.navigate().to(url);
		driver.manage().window().maximize();

		// 1st task
		System.out.println("Page 'Radio buttons'. Task 1");

		WebElement rb1;
		rb1 = driver.findElement(By.id("yes"));
		rb1.click();

		// 2nd task
		System.out.println("Page 'Radio buttons'. Task 2");

		WebElement rb2 = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/label[2]/input"));
		WebElement rb3 = driver
				.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/label[3]/input"));

		if (rb2.isSelected()) {
			System.out.println("The button 'Unchecked' is selected");
		} else {

			if (rb3.isSelected()) {
				System.out.println("The button 'Checked' is selected");
			} else {
				System.out.println("Something went wrong!!!");
			}

		}

		// 3nd task
		System.out.println("Page 'Radio buttons'. Task 3");

		WebElement rb4 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/input[2]"));

		if (rb4.isSelected()) {
			System.out.println("The age value is already selected");
		} else {
			rb4.click();
			System.out.println("Your age is added");
		}
		System.out.println("=====================================");
	}

	public static void checkboxes() {

		ChromeDriver driver = new ChromeDriver();
		String url = "http://www.leafground.com/pages/checkbox.html";

		driver.navigate().to(url);
		driver.manage().window().maximize();

		// 1st task 'Select the languages that you know?'

		System.out.println("Page 'Checkboxes'. Task 1");

		WebElement cbel1 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[1]"));
		cbel1.click();
		WebElement cbel2 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[3]"));
		cbel2.click();

		// 2nd task
		System.out.println("Page 'Checkboxes'. Task 2");

		WebElement cbel3 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/input"));
		if (cbel3.isSelected()) {
			System.out.println("The 'Selenium' is checked");
		} else {
			System.out.println("The 'Selenium' is NOT checked");
		}

		// 3d task
		System.out.println("Page 'Checkboxes'. Task 3");

		WebElement cbel4 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[2]"));

		for (int i = 0; i < 2; i++) {
			cbel4.click();
			if (cbel4.isSelected()) {
				System.out.println("Checkbox is Toggled On");

			} else {
				System.out.println("Checkbox is Toggled Off");
			}
		}

		// 4th task
		System.out.println("Page 'Checkboxes'. Task 4");

		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='example'][4]/child::input"));

		System.out.println("There are " + (Integer.toString(elements.size())) + " checkbox elements");
		for (WebElement el : elements) {
			el.click();
		}

	}

}
