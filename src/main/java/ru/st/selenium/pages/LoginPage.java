package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for Login page 
 */

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "username")
	private WebElement usernameField;

  @FindBy(name = "password")
  private WebElement passwordField;

  @FindBy(name = "submit")
  private WebElement submitButton;
  
  public LoginPage setUsernameField(String text) {
    usernameField.sendKeys(text);
    return this;
  }

  public LoginPage setPasswordField(String text) {
    passwordField.sendKeys(text);
    return this;
  }

  public void clickSubmitButton() {
    submitButton.click();
  }

  public LoginPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.id("loginform")));
    return this;
  }

 
  
  
}
