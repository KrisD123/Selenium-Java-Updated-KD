package ru.st.selenium.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.st.selenium.applogic.ApplicationManager;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected ApplicationManager app;

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10); 
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
		public Page ensurePageLoaded() {
		  return this;
		}

	  public boolean waitPageLoaded() {
	    try {
	      ensurePageLoaded();
	      return true;
	    } catch (TimeoutException to) {
	      return false;
	    }
	  }

}
