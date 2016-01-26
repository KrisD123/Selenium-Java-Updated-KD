package ru.st.selenium.tests.base;

import ru.st.selenium.applogic.ApplicationManager;
import ru.st.selenium.model.Film;
import ru.st.selenium.pages.AddMoviePage;
import ru.st.selenium.pages.HomePage;
import ru.st.selenium.pages.InternalPage;
import ru.st.selenium.pages.MovieDetailsPage;

/**
 * Class describes main actions with films
 */

 public class FilmTestBase extends TestBase {
public FilmTestBase() {
		
	}
	
	public FilmTestBase(ApplicationManager app) {
		this.setApp(app);
	}
	
	 
	  public AddMoviePage createFilm(Film film) {
	    InternalPage internalPage = new InternalPage(app.getWebDriver()).ensurePageLoaded();
	   return internalPage.clickHomeLink()
	    .clickAddMovieButton()
	    .ensurePageLoaded()
	    .setTitleField(film.getTitle())
	    .setYearField(film.getYear())
	    .clickSubmitButton();
	  }	  
	
	  public HomePage deleteFilm(Film film) {
		  InternalPage internalPage = new InternalPage(app.getWebDriver()).ensurePageLoaded();
		  internalPage.clickHomeLink().ensurePageLoaded();
		  
		  makeSearch(film.getTitle());
		  return goToMovieDetailsPage(film.getTitle()).ensurePageLoaded()
		  .clickRemoveButton();
	  }
	  
	  public MovieDetailsPage goToMovieDetailsPage(String title) {
		return new HomePage(app.getWebDriver()).goToMovieDetailsPage(title);
	}
	  
	 public void makeSearch(String text) {
		 new HomePage(app.getWebDriver()).makeSearch(text);
}
	 
	 public boolean isFilmFound(Film film) {
		 return new HomePage(app.getWebDriver()).isFilmFound(film);
	 }

}
