import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public String url = "https://qa.koel.app/";
    public String homePageUrl = "https://qa.koel.app/#!/home";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
       // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();
    }

        public void closeBrowser() {
            driver.quit();
        }
        public void clickSubmitBtn() {
            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            submit.click();
        }
        public void providePassword(String password) {
            WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
            passwordField.clear();
            passwordField.sendKeys(password);
        }
        public void provideEmail(String email) {
            WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            emailField.clear();
            emailField.sendKeys(email);
        }

        public void navigateToPage() {
                driver.get(url);
            }
}