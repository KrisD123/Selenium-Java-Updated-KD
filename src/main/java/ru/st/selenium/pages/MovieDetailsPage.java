package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for MovieDetails page
 */

public class MovieDetailsPage extends InternalPage {

	public MovieDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "img[alt=\"Remove\"]")
	private WebElement removeButton;

	public HomePage clickRemoveButton() {
		removeButton.click();
		wait.until(alertIsPresent()).accept();
		return new HomePage(driver);
	}


	public MovieDetailsPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.id("movie")));
	    return this;
	  }
}
