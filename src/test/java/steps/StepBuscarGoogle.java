package steps;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import herramientas.CapturarPantalla;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepBuscarGoogle {

	   private  WebDriver driver;
	   By localizadorCookies=By.xpath("//button[@id=\"L2AGLb\"]");
	   
	@Before
	public void iniciarNavegador() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver();
	}
	@Given("I am on the Google search page")
	public void i_am_on_the_google_search_page() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		
	    driver.get("https://www.amazon.com");
	    this.driver.findElement(localizadorCookies).click();
	}
	@When("I search for {string}")
	public void i_search_for(String query) {
		  WebElement element = driver.findElement(By.name("q"));
	        // Enter something to search for
	        element.sendKeys(query);
	        // Now submit the form. WebDriver will find the form for us from the element
	        element.submit();
	}
	@Then("the page title should start with {string}")
	public void the_page_title_should_start_with(String titleStartsWith) {
		  new WebDriverWait(driver,Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
	           public Boolean apply(WebDriver d) {
	               return d.getTitle().toLowerCase().startsWith(titleStartsWith);
	           }
	       });
	}
	
	
	  @After()
	   public void closeBrowser() {
	       CapturarPantalla.hacerCapturaPantalla(driver, "error");
	       driver.quit();
	   }
	
	
}
