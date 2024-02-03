package com.serachengine.proxydriver;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProxyDriver implements WebDriver{
	
	public WebDriver driver;
	
	public ProxyDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void get(String url) {
		ProxyDriver.this.driver.get(url);

	}

	public String getCurrentUrl() {
		return ProxyDriver.this.driver.getCurrentUrl();
	}

	public String getTitle() {
		return ProxyDriver.this.driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		return ProxyDriver.this.driver.findElements(by);
	}

	public WebElement findElement(By by) {
		return ProxyDriver.this.driver.findElement(by);
	}

	public String getPageSource() {
		return ProxyDriver.this.driver.getPageSource();
	}

	public void close() {
		ProxyDriver.this.driver.close();

	}

	public void quit() {
		ProxyDriver.this.driver.quit();

	}

	public Set<String> getWindowHandles() {
		return ProxyDriver.this.driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return ProxyDriver.this.driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation navigate() {
		new Navigation() {

			@Override
			public void to(URL url) {

			}

			@Override
			public void to(String url) {
				ProxyDriver.this.driver.get(url);

			}

			@Override
			public void refresh() {
				ProxyDriver.this.driver.navigate().refresh();

			}

			@Override
			public void forward() {
				ProxyDriver.this.driver.navigate().forward();

			}

			@Override
			public void back() {
				ProxyDriver.this.driver.navigate().back();

			}
		};

		return null;
	}

	@Override
	public Options manage() {
		return driver.manage();
	}


	public WebElement waitForElementToBeClickable(By locator, Duration timeOutInSeconds) {
		return new WebDriverWait(this, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(locator));
	}
	

	public WebElement waitForElementToBeVisible(By Locator, Duration timeOutInSeconds) {
		return new WebDriverWait(this, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}

	public WebElement waitForElementToBePresent(By Locator, Duration timeOutInSeconds) {
		return new WebDriverWait(this, timeOutInSeconds).until(ExpectedConditions.presenceOfElementLocated(Locator));
	}

	public void waitForElementToBeSelectable(WebElement element, Duration timeOutInSeconds) {
		new WebDriverWait(this, timeOutInSeconds).until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

	public void click(By by) {
		WebElement element = waitForElementToBeClickable(by, Duration.ofSeconds(10));
		element.click();
	}

	public void selectItemFromDropDown(By by, String text) {
		WebElement element = waitForElementToBeClickable(by, Duration.ofSeconds(10));
		Select sc = new Select(element);
		try {
			sc.selectByVisibleText(text);
		} catch (Exception e) {
			sc.selectByValue(text);
		}
	}

	public void submit(By by) {
		WebElement element = waitForElementToBeClickable(by, Duration.ofSeconds(10));
		element.submit();
	}

	public void sendKeys(By by, String text) {
		WebElement element = waitForElementToBeVisible(by, Duration.ofSeconds(10));
		element.sendKeys(text);
	}

	public String getText(By by) {
		WebElement element = waitForElementToBeVisible(by, Duration.ofSeconds(10));
		return element.getText();
	}

	public boolean isDisplayed(By by) {
		WebElement element = waitForElementToBePresent(by, Duration.ofSeconds(10));
		return element.isDisplayed();
	}

	public boolean isEnabled(By by) {
		WebElement element = waitForElementToBeVisible(by, Duration.ofSeconds(10));
		return element.isEnabled();
	}

	public void acceptAlert() {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).accept();
	}

	public void dismissAlert() {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public void clear(By by) {
		WebElement element = waitForElementToBeVisible(by, Duration.ofSeconds(10));
		element.clear();
	}
	
	public void click(WebElement element) {
		new WebDriverWait(this, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element)).click();
	}

}
