import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableDataCheckTest extends  BaseTestClass {


    @Test
    public void checkTableData()
    {
        driver.findElement(By.linkText("Table Filter")).click();

        driver.findElement(By.cssSelector(".btn-success")).click();
        int resultCount=driver.findElements(By.cssSelector("tr[data-status=\"pagado\"]")).size();
        Assert.assertEquals(2,resultCount);
    }
}
