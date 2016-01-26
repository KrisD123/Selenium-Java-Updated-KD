package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InternalPage extends Page{

	/**
	 * Class for Internal page 
	 * that is base for Home page, AddMovie page, MovieDetails page, UserManagement page and UserProfile page
	 * Created by Kristina Dodonova
	 */
	
	public InternalPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	  
	  @FindBy(linkText = "Home")
	  private WebElement homeLink;
	  
	  @FindBy(css = "nav a[href $= '?go=profile']")
	  private WebElement userProfileLink;

	  @FindBy(css = "nav a[href $= '?go=users']")
	  private WebElement userManagementLink;

	  @FindBy(css = "nav a[href $= '?logout']")
	  private WebElement logoutLink;
	  
	  public HomePage clickHomeLink() {
		    homeLink.click();
		    return new HomePage(driver);
		  }
	  
	  public UserProfilePage clickUserProfilePage() {
	    userProfileLink.click();
	    return new UserProfilePage(driver);
	  }

	  public UserManagementPage clickUserManagementLink() {
	    userManagementLink.click();
	    return new UserManagementPage(driver);
	  }
	  
	  public LoginPage clickLogoutLink() {
	    logoutLink.click();
	    wait.until(alertIsPresent()).accept();
	    return new LoginPage(driver);
	  }
	  
	  public InternalPage ensurePageLoaded() {
		    super.ensurePageLoaded();
		    wait.until(presenceOfElementLocated(By.cssSelector("nav")));
		    return this;
		  }
	  
	  
}
