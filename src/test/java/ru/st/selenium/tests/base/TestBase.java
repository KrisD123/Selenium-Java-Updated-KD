package ru.st.selenium.tests.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import ru.st.selenium.applogic.ApplicationManager;
import ru.st.selenium.model.User;


/**
 * Base class for all the TestNG-based test classes
 */
public class TestBase {
	public static User ADMIN = new User().setLogin("admin").setPassword("admin");
	protected ApplicationManager app;
	protected UserTestBase uBase;
	protected FilmTestBase fBase;
	
	
	@BeforeClass
	public void init() {
		app = new ApplicationManager();
		uBase = new UserTestBase(app);
		fBase = new FilmTestBase(app);
		app.openMainPage(app.getWebDriver());
	}
	
	/**
     * Getter for the Application Manager
     *
     * @return Application Manager
     */
	
    public ApplicationManager getApp() {
        return app;
    }

    /**
     * Setter for the Application manager
     *
     * @param app Application Manager to set
     */
    
    public void setApp(ApplicationManager app) {
        this.app = app;
    }
	@AfterSuite
	public void stop() {
	  app.stop();
	}
}
