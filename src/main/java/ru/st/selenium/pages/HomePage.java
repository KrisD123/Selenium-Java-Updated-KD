package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ru.st.selenium.model.Film;


	/**
	 * Class describing Home page
	 * Created by Kristina Dodonova
	 * Date: 15.12.2015
	 */

	public class HomePage extends InternalPage{
		public HomePage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
			
	@FindBy(css = "nav a[href $= '?go=add']")
	private WebElement addMovieButton;

	@FindBy(id = "q")
	private WebElement searchField; 

	@FindBy(id = "results")
	private WebElement resultsForm;

	@FindBy(css = ".title")
	private List<WebElement> filmTitles;

	@FindBy(xpath = "//div[@class='content'][text()='No movies where found.']")
	private WebElement noMoviesFound;


	private WebElement filmLink(String text) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='title'][text()='" + text + "']")));
				
	}


	public HomePage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.id("results")));
	    return this;
	  }


	public AddMoviePage clickAddMovieButton() {
		addMovieButton.click();
		return new AddMoviePage(driver);
		}

	public String getSearchField() {
		return searchField.getAttribute("value");
	}

	  public void setSearchField(String text) {
		searchField.clear();
	    searchField.sendKeys(text);
	    searchField.sendKeys(Keys.RETURN);
	  }
	  

	  /**
	   * Method to get all films that are currently displayed
	   * Created by Kristina Dododnova 
	   * 16.12.2015
	   */
	 /* 
	  public List<String> getAllFilmTitles() {
		  List<String> allFilmTitles = new ArrayList<String>();
		  for (WebElement filmTitle : filmTitles) {
			  allFilmTitles.add(filmTitle.getText());
		  }
		return allFilmTitles;
		  
	  }*/
	  
	  public MovieDetailsPage goToMovieDetailsPage(String filmTitle) {
		  
		  filmLink(filmTitle).click();
		 return new MovieDetailsPage(driver);
	  }
	  

	public void makeSearch(String text) {
		InternalPage internalPage = new InternalPage(driver).ensurePageLoaded();
		internalPage.clickHomeLink().ensurePageLoaded();
		 if (filmTitles.isEmpty()) {
	         setSearchField(text);
	     } else {
	         WebElement film = filmTitles.get(0);
	         setSearchField(text);
	         wait.until(ExpectedConditions.stalenessOf(film));
	     }
	     wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".title, .content")));
	 }

	public void deleteSearch() {
		InternalPage internalPage = new InternalPage(driver).ensurePageLoaded();
		internalPage.clickHomeLink()
		.ensurePageLoaded()
		.makeSearch("");
	}

	public boolean isFilmFound(Film film) {
		makeSearch(film.getTitle());
		try {
			driver.findElement(By.xpath("//div[@class='title'][text()='" + film.getTitle() + "']"));
			return true;
		}
		catch (Exception e) {
			return false;
		}
	
	}
}
