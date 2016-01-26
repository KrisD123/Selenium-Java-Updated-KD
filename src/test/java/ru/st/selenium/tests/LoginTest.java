package ru.st.selenium.tests;

import org.testng.annotations.*;
import static org.junit.Assert.*;

import ru.st.selenium.model.User;
import ru.st.selenium.tests.base.UserTestBase;

/**
 * Tests check login page with valid and invalid user data
 */

public class LoginTest extends UserTestBase {
	

  @BeforeMethod // logout if user is already logged in
  public void mayBeLogout() {
    if (uBase.isNotLoggedIn()) {
      return;
    }
   uBase.logout();
  }
  
  @Test (priority=0) // Check that login is successful if valid username and password are entered
  public void testLoginOK() throws Exception {
    User user = new User().setLogin("admin").setPassword("admin");
    uBase.loginAs(user);
    assertTrue(uBase.isLoggedInAs(user));
  }

  @Test (priority=1) // Check that login is unsuccessful if wrong password is entered
  public void testLoginFailed() throws Exception {
    User user = new User().setLogin("admin").setPassword("wrong");
    uBase.loginAs(user);
    assertTrue(uBase.isNotLoggedIn());
  }

}
