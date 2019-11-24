package seleniumgluecode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class test {
    public static WebDriver driver;
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {     
    	System.setProperty("webdriver.chrome.driver","C:/Users/Sri/eclipse-workspace/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.sixty.no/");
        driver.manage().window().maximize();
    }
    
    @When("^user clicks Ease Live Page$")
    public void user_navigates_to_Easelive_Page() throws Throwable {
    	driver.findElement(By.xpath("//*[@id=\"hs-eu-confirmation-button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"main-header-content\"]/nav/ul/li[1]/a")).click();
    }
    
    @Then("^verify url$")
    public void assert_url() throws Throwable {
    	String exp_message = "https://www.sixty.no/ease-live/";
    	String url1 = driver.getCurrentUrl();
        Assert.assertEquals(exp_message, url1);
        driver.quit(); 
          
    }      
    //************************Contact tab********************************//
    @When("^I provide details on contact tab$")
    public void user_navigates_to_contact_Page() throws Throwable {
    	driver.findElement(By.xpath("//*[@id=\"hs-eu-confirmation-button\"]")).click();
    	driver.findElement(By.xpath("//*[@id=\"main-header-content\"]/nav/ul/li[7]/a")).click();
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("Test@test.com");
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Testing");
    }
    
    @And("^click subscribe$")
    public void success_message_is_displayed() throws Throwable {
    	driver.findElement(By.xpath("//*[@type='checkbox']")).click();
    	driver.findElement(By.xpath("//*[@type='submit']")).submit();
         
    }      
    
    @Then("^A mail is sent$")
    public void mail_sent() throws Throwable {
    	driver.findElement(By.xpath("//*[@type='submit']")).submit();
        driver.quit(); 
        //javascript validation for text can be added here 
          
    }  
}

