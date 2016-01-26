package ru.st.selenium.tests;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.st.selenium.model.Film;
import ru.st.selenium.tests.base.TestBase;

/**
 * Tests for adding and deleting of a film
 */

public class AddDeleteFilmTest extends TestBase {
	@BeforeClass
	public void performLogin() {
	    
	    uBase.loginAs(ADMIN);
	  }


	@Test (priority=0) // Check that new film is successfully created if all mandatory fields are filled in
	public void testAddNewFilmOK() throws Exception {
		String title = "TestMovie" + System.currentTimeMillis();
		Film film = new Film()
		.setTitle(title).setYear("2015");
		
	    fBase.createFilm(film);
		fBase.makeSearch(film.getTitle());
	    assertTrue(fBase.isFilmFound(film));
	   
	  }
	
	@Test (priority=1) //Check that new film is not crested if one of mandatory fields (year) is not filled in
	public void testAddNewFilmFailed() throws Exception {
		String title = "TestMovie" + System.currentTimeMillis();
		Film film = new Film()
		.setTitle(title);
		
		fBase.createFilm(film);
		fBase.makeSearch(film.getTitle());
		assertFalse(fBase.isFilmFound(film));
	}
	
	@Test (priority=3) // Check that film can be successfully deleted
	public void testDeleteFilm() throws Exception {
		String title = "TestMovie" + System.currentTimeMillis();
		Film film = new Film()
				.setTitle(title)
				.setYear("2017");
		fBase.createFilm(film);
		fBase.deleteFilm(film);
		fBase.makeSearch(film.getTitle());
		assertFalse(fBase.isFilmFound(film));
	}
}
