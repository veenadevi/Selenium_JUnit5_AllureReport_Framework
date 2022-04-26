import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class BaseTestClass {
   public  WebDriver driver=null;

    @BeforeEach
    public void doSetup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.get("https://www.lambdatest.com/selenium-playground/");

    }
    @AfterEach
    public void takeScreenshot(TestInfo info) throws IOException {
        File source = ((ChromeDriver)driver).getScreenshotAs((OutputType.FILE));
        File dest = new File( System.getProperty("user.dir")+"/screenshots/"+info.getDisplayName().toLowerCase()+".jpeg");
        FileHandler.copy(source,dest);
        try {
            // File screenshotAs = ((TakesScreenshot) getSelenideDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("PageView", FileUtils.openInputStream(source));
        } catch (IOException | NoSuchSessionException e) {
            // NO OP
        } finally {
            // WebDriverRunner.getSelenideDriver().getWebDriver().quit();
        }

    }
}
