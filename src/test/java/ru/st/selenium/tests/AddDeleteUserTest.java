package ru.st.selenium.tests;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.st.selenium.model.User;
import ru.st.selenium.tests.base.TestBase;

/**
 * Tests for creation of a user
 */

	public class AddDeleteUserTest extends TestBase {

		 @BeforeMethod // logout if user is already logged in
		  public void mayBeLogout() {
		    if (uBase.isNotLoggedIn()) {
		      return;
		    }
		   uBase.logout();
		  }
		 
		@Test (priority=0) // Check that new user is successfully created if all mandatory fields are filled in
		public void addNewUserOK() {
			String username = "user" + System.currentTimeMillis();
			User user = new User()
					.setLogin(username)
					.setPassword("password")
					.setEmail(username + "@test.com");
			
			uBase.loginAs(ADMIN);
			uBase.createUser(user);
			uBase.logout();
			uBase.loginAs(user);
			assertTrue(uBase.isLoggedInAs(user));
		}
		
		@Test (priority=1) // Check that new user is not created if one of mandatory fields (e-mail address) is not filled in
		public void addNewUserFailed() {
			String username = "user" + System.currentTimeMillis();
			User user = new User()
					.setLogin(username)
					.setPassword("password");
			uBase.loginAs(ADMIN);
			uBase.createUser(user);
			uBase.logout();
			uBase.loginAs(user);
			assertTrue(uBase.isNotLoggedIn());
		}
		
}
