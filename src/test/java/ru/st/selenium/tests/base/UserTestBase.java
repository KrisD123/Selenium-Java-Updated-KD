package ru.st.selenium.tests.base;

import ru.st.selenium.applogic.ApplicationManager;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.InternalPage;
import ru.st.selenium.pages.LoginPage;
import ru.st.selenium.pages.UserProfilePage;
/**
 * Class describes main actions with users
 */
public class UserTestBase extends TestBase {
	public UserTestBase() {
		
	}
	
	public UserTestBase(ApplicationManager app) {
		this.setApp(app);
		
	}

	public boolean isLoggedInAs(User user) {
	    return isLoggedIn()
	        && getLoggedUser().getLogin().equals(user.getLogin());
	  }
  
  public boolean isLoggedIn() {
	    return new InternalPage(app.getWebDriver()).waitPageLoaded();
	  }
  
  private User getLoggedUser() {
	    UserProfilePage userProfile = new InternalPage(app.getWebDriver()).ensurePageLoaded()
	      .clickUserProfilePage()
	      .ensurePageLoaded();
	    return new User()
	      .setLogin(userProfile.getUsername())
	      .setEmail(userProfile.getEmail())
	      .setRole(userProfile.getRole());
	  }
 
 public boolean isNotLoggedIn() {
		    return new LoginPage(app.getWebDriver()).waitPageLoaded();
		  }
 
 
 public LoginPage logout() {
	   InternalPage internalPage = new InternalPage(app.getWebDriver());
	   internalPage.ensurePageLoaded();
	   return internalPage.clickLogoutLink();
	  }
 
 public void loginAs(User user) {
     LoginPage loginPage = new LoginPage(app.getWebDriver());
     loginPage.ensurePageLoaded();
     loginPage.setUsernameField(user.getLogin())
     .setPasswordField(user.getPassword())
     .clickSubmitButton();
 }
	
 public void createUser(User user) {
	 InternalPage internalPage = new InternalPage(app.getWebDriver());
		internalPage.clickUserManagementLink().ensurePageLoaded()
		.setUsernameField(user.getLogin())
		.setEmailField(user.getEmail())
		.setPassword(user.getPassword())
		.setPassword2(user.getPassword())
		.clickSubmitButton();
	}
	

}
