package Task_5;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static driver.SimpleDriver.getWebDriver;


public class Task_5_withStars {
    @BeforeTest
    public void preconditions(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://calc.by/building-calculators/laminate.html");
    }
    @Test
    public void test1(){
        enter("ln_room_id", "820");
        enter("wd_room_id","820");
        enter("ln_lam_id", "1600");
        enter("wd_lam_id", "200");
        enter("n_packing","10");
        Select select = new Select(getWebDriver().findElement(By.id("laying_method_laminate")));
        select.selectByValue("2");
        enter("min_length_segment_id", "300");
        enter("indent_walls_id","5");
        getWebDriver().findElement(By.id("direction-laminate-id1")).click();
        getWebDriver().findElement(By.cssSelector("[class='calc-btn']")).click();

        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<String> expectedResult = Arrays.asList(
                "Требуемое количество досок ламината: 226", "Количество упаковок ламината: 23"
        );
        Assert.assertEquals(expectedResult, getActualResult());
    }
    public void enter(String id, String value) {
        getWebDriver().findElement(By.id(id)).clear();
        getWebDriver().findElement(By.id(id)).sendKeys(value);
    }
    public List<String> getActualResult(){
        String countLaminte = getWebDriver().findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[1]")).getText();
        String countPackage = getWebDriver().findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[2]")).getText();

        List<String> actualResult = Arrays.asList(
                countLaminte, countPackage
        );
        return actualResult;
    }
}
