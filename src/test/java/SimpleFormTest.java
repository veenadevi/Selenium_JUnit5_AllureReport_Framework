
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;


public class SimpleFormTest  extends  BaseTestClass{


    @Test
    public void CheckSimpleForm(TestInfo info) throws IOException {

        driver.findElement(By.linkText("Simple Form Demo")).click();

        driver.findElement(By.id("user-message")).sendKeys("Welcome To LambdaTest");
        driver.findElement(By.id("showInput")).click();



       String textSent= driver.findElement(By.id("message")).getText();

        Assertions.assertEquals("Welcome To LambdaTest",textSent);



   }
}
