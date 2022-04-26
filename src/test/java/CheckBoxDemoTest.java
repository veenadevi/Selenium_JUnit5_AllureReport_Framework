import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CheckBoxDemoTest extends BaseTestClass{

    @Test
    public void validateCheckBox(TestInfo info) throws IOException {

        driver.findElement(By.linkText("Checkbox Demo")).click();


        WebElement ageCheckBox=driver.findElement(By.id("isAgeSelected"));
        Assertions.assertFalse(ageCheckBox.isSelected());
        ageCheckBox.click();
        Assertions.assertTrue(ageCheckBox.isSelected());


    }
}
