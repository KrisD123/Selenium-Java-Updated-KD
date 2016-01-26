package ru.st.selenium.tests;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.st.selenium.model.Film;
import ru.st.selenium.tests.base.FilmTestBase;
/**
 * Tests for searching of a film
 */
public class SearchFilmTest extends FilmTestBase {
		@BeforeClass
		public void performLogin() {
		    uBase.loginAs(ADMIN);
		  }
		
		@Test (priority=0) // Check that film can be found if its title is entered into the search field
		public void searchFilmsFound() throws Exception {
			String title = "TestMovie" + System.currentTimeMillis();
			Film film = new Film()
			.setTitle(title)
			.setYear("2015");
			
			fBase.createFilm(film);
			assertTrue(fBase.isFilmFound(film));
			
		}
		
		@Test (priority=1) // Check that film can't be found if title of nonexistent film is entered into the search field
		public void searchFilmsNotFound() throws Exception {
			String title = "TestMovie" + System.currentTimeMillis();
			Film film = new Film()
			.setTitle(title);
			
			fBase.createFilm(film);
			assertFalse(fBase.isFilmFound(film));
			
		}


}
