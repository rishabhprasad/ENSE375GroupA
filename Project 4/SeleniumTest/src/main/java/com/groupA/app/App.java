// SELENIUM
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// RUN MAIN TO TEST SELENIUM FUNCTIONALITY
public class App {
    public static void main(String[] args) throws Exception {
        // CREATE A NEW WEBDRIVER AND OPEN TO SAMPLE PAGE
    
        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com/index.php");
    }
}
