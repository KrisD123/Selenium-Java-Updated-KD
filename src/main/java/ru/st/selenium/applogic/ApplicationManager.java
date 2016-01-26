package ru.st.selenium.applogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.st.selenium.util.Browser;
import ru.st.selenium.util.PropertyLoader;
import ru.st.selenium.webdriver.WebDriverFactory;

public class ApplicationManager {

  private WebDriver driver;
  private String baseUrl;
  protected WebDriverWait wait;
  
  public ApplicationManager() {
    baseUrl = PropertyLoader.loadProperty("site.url");

    Browser browser = new Browser();
    browser.setName(PropertyLoader.loadProperty("browser.name"));
    browser.setVersion(PropertyLoader.loadProperty("browser.version"));
    browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

    String browserName = PropertyLoader.loadProperty("browser.name");
    String username = PropertyLoader.loadProperty("user.username");
    String password = PropertyLoader.loadProperty("user.password");
    
    driver = WebDriverFactory.getInstance(browserName, username, password);
    wait = new WebDriverWait(driver, 10); 

  }

  public void openMainPage(WebDriver driver) {
	    driver.get(baseUrl);
	  }
  
  
  
  public WebDriver getWebDriver() {
    return driver;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  
  public void stop() {
    if (driver != null) {
      driver.quit();
    }
  }

}
