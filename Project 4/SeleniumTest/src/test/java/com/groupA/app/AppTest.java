// SELENIUM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.junit.jupiter.api.AfterAll;
// JUNIT
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest {
    private static  WebDriver driver;

    @BeforeAll
    public static  void setup(){ 
        // CREATE A NEW WEBDRIVER AND OPEN TO SAMPLE PAGE

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox") ;
        chromeOptions.addArguments("--disable-setuid-sandbox") ;
        chromeOptions.addArguments("--remote-debugging-port=9515");
        chromeOptions.addArguments("--disable-dev-shm-using"); 
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("start-maximized"); 
        chromeOptions.addArguments("disable-infobars");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://blazedemo.com/index.php");
    }

    @Test
    @Order(1)
    public void Selenium_ValidTitle_True()
     {
        // TEST THAT THE TITLE IS CORRECT
        String actualTitle = driver.getTitle();
        String expectedTitle = "BlazeDemo";
        Assertions.assertEquals(expectedTitle, actualTitle);
    }   
    @Test
    @Order(2)
    public void Selenium_SelectDepartureCity_True()
     {
        // CHOOSE DEPARTURE CITY
        Select departureCity = new Select(driver.findElement(By.name("fromPort")));
        departureCity.selectByVisibleText("Boston");
        String actualDepartureCity = driver.findElement(By.name("fromPort")).getAttribute("value");
        String expectedDepartureCity = "Boston";
        Assertions.assertEquals(expectedDepartureCity, actualDepartureCity);
    }   
    @Test
    @Order(3)
    public void Selenium_SelectDestinationCity_True()
     {
        // CHOOSE DESTINATION CITY
        Select departureCity = new Select(driver.findElement(By.name("toPort")));
        departureCity.selectByVisibleText("Rome");
        String actualDestinationCity = driver.findElement(By.name("toPort")).getAttribute("value");
        String expectedDestinationCity = "Rome";
        Assertions.assertEquals(expectedDestinationCity, actualDestinationCity);
    }   

    @Test
    @Order(4)
    public void Selenium_SubmitReservationsRedirect_True()
     {
        // SUBMIT AND REDIRECT TO NEW PAGE
        WebElement submitButton = driver.findElement(By.cssSelector("input[value = 'Find Flights']"));
        submitButton.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://blazedemo.com/reserve.php";
        Assertions.assertEquals(expectedURL, actualURL);
    }  
    @Test
    @Order(5)
    public void Selenium_ConfirmDepartureCity_True()
     {
        // CONFIRM CITIES ON RESERVATIONS PAGE
        // DEPARTURE CITY
        WebElement departureCityElement = driver.findElement(By.cssSelector("input[name= 'fromPort']"));
        String actualDepartureCity = departureCityElement.getAttribute("value");
        String expectedDepartureCity = "Boston";
        Assertions.assertEquals(expectedDepartureCity, actualDepartureCity);
    }  
    @Test
    @Order(6)
    public void Selenium_ConfirmDestinationCity_True()
     {
        // CONFIRM CITIES ON RESERVATIONS PAGE
        // DESTINATION CITY
        WebElement departureCityElement = driver.findElement(By.cssSelector("input[name= 'toPort']"));
        String actualDestinationCity = departureCityElement.getAttribute("value");
        String expectedDestinationCity = "Rome";
        Assertions.assertEquals(expectedDestinationCity, actualDestinationCity);
    }  
    @Test
    @Order(7)
    public void Selenium_SubmitFlightSelectionRedirect_True()
     {
        // SUBMIT AND REDIRECT TO PURCHASE
        WebElement submitButton = driver.findElement(By.cssSelector("input[value = 'Choose This Flight']"));
        submitButton.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://blazedemo.com/purchase.php";
        Assertions.assertEquals(expectedURL, actualURL);
    }  
    @Test
    @Order(8)
    public void Selenium_ValidTextInputs_True()
     {
        // ENTER FIRST NAME IN TEXT BOX
        WebElement firstName = driver.findElement(By.id("inputName"));
        firstName.sendKeys("Test Name");
        // GET INPUT AND CHECK THAT IT CHANGED
        String actualFirstName = driver.findElement(By.id("inputName")).getAttribute("value");
        String expectedFirstName = "Test Name";
        Assertions.assertEquals(expectedFirstName, actualFirstName);
    }   
    @Test
    @Order(9)
    public void Selenium_SubmitPurchaseRedirect_True()
     {
        // SUBMIT AND REDIRECT TO FLIGHT CONFIRMATION
        WebElement submitButton = driver.findElement(By.cssSelector("input[value = 'Purchase Flight']"));
        submitButton.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://blazedemo.com/confirmation.php";
        Assertions.assertEquals(expectedURL, actualURL);
    }  
    @AfterAll
    public static void tearDown(){
        // CLOSE DRIVER
        driver.close();
    }
}