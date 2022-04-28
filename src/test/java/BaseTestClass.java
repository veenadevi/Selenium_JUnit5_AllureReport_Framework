import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTestClass {
   public  WebDriver driver=null;

    @BeforeEach
    public void doSetup(TestInfo info) throws MalformedURLException {

//        WebDriverManager.chromedriver().setup();
//        driver= new ChromeDriver();


        String username = System.getenv("LT_USERNAME") == null ? "" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "JUnit5_Allure_Repots");
        caps.setCapability("name", info.getDisplayName() + " - " + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "junit5" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
       driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }
    @AfterEach
    public void takeScreenshot(TestInfo info) throws IOException {

        File source = ((RemoteWebDriver)driver).getScreenshotAs((OutputType.FILE));
        File dest = new File( System.getProperty("user.dir")+"/screenshots/"+info.getDisplayName().toLowerCase()+".jpeg");
        FileHandler.copy(source,dest);
        try {
            // File screenshotAs = ((TakesScreenshot) getSelenideDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("PageView", FileUtils.openInputStream(source));
        } catch (IOException | NoSuchSessionException e) {
            // NO OP
        } finally {
            driver.close();

        }



    }

}
