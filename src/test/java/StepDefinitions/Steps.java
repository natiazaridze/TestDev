package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Steps {

    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\chromedriver.exe");
         this.driver = new ChromeDriver();
    }

    @Given("Landing page is opened")
    public void landing_page_is_opened() {
    driver.get("http://www.automationpractice.com");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("the user clicks the sign in button")
    public void the_user_clicks_the_sign_in_button() {
        driver.findElement(By.className("login")).click();
    }

    @Given("the user enters valid email")
    public void the_user_enters_valid_email() {
        driver.findElement(By.id("email_create")).sendKeys("natrulias23@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @When("user enters valid info to register")
    public void user_enters_valid_info_to_register() {
        WebElement home  = driver.findElement(By.className("navigation_page"));
        assertEquals("Authentication",home.getText(),"Authentication");
        WebElement radio = driver.findElement(By.id("id_gender2"));
        radio.click();
        driver.findElement(By.id("customer_firstname")).sendKeys("natia");
        driver.findElement(By.id("customer_lastname")).sendKeys("zaridze");
        driver.findElement(By.id("passwd")).sendKeys("natianatia123");
        Select days = new Select((driver.findElement(By.id("days"))));
        days.selectByValue("17");
        String Birthday = driver.findElement(By.id("days")).getAttribute("value");
        Assert.assertEquals(Birthday,"17");
        Select month = new Select((driver.findElement(By.id("months"))));
        month.selectByValue("6");
        String BirthMonth = driver.findElement(By.id("months")).getAttribute("value");
        Assert.assertEquals(BirthMonth,"6");
        Select year = new Select((driver.findElement(By.id("years"))));
        year.selectByValue("2002");
        String BirthYear = driver.findElement(By.id("years")).getAttribute("value");
        Assert.assertEquals(BirthYear,"2002");
        driver.findElement(By.id("address1")).sendKeys("Todria");
        driver.findElement(By.id("city")).sendKeys("Rustavi");
        Select state = new Select((driver.findElement(By.id("id_state"))));
        state.selectByValue("10");
        String States = driver.findElement(By.id("id_state")).getAttribute("value");
        Assert.assertEquals(States,"10");
        driver.findElement(By.id("postcode")).sendKeys("37000");
        driver.findElement(By.id("phone_mobile")).sendKeys("+995597022666");
        driver.findElement(By.id("submitAccount")).click();

    }

    @Then("succes message shown")
    public void succes_message_shown() {
        WebElement account  = driver.findElement(By.className("page-heading"));
        assertEquals("My account",account.getText(),"MY ACCOUNT");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
