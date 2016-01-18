package ru.st.selenium.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import ru.st.selenium.applogic.ApplicationManager;

/**
 * Base class for all the TestNG-based test classes
 */
public class TestBase {
	//public static User ADMIN = new User().setLogin("admin").setPassword("admin");
	protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager();
	}
	
	@AfterSuite
	public void stop() {
	  app.stop();
	}
}
