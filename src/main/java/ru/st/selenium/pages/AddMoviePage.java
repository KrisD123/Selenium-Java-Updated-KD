package ru.st.selenium.pages;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for AddMovie page
 */

public class AddMoviePage extends InternalPage {

	public AddMoviePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "name")
	private WebElement titleField;

	@FindBy(name = "year")
	private WebElement yearField;

	@FindBy(name = "submit")
	private WebElement submitButton;

	public String getTitleField() {
		return titleField.getAttribute("value");
	}

	public AddMoviePage setTitleField(String text) {
	    titleField.sendKeys(text);
	    return this;
	   
	  } 

	public String getYearField() {
		return yearField.getAttribute("value");
	}

	public AddMoviePage setYearField(String text) {
	    yearField.sendKeys(text);
	    return this;
	  } 

	public AddMoviePage clickSubmitButton() {
		submitButton.click();
		return this;
		
	}

	public AddMoviePage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.name("imdbid")));
	    return this;
	  }

	}
