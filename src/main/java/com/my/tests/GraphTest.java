package com.my.tests;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
/**
 * Created by 803100 on 02.12.2016.
 */
public class GraphTest {
    public static WebDriver driver;
    public static WebElement exprField;
    public static WebElement exprField2;
    public static WebElement solveButton;
    public static WebElement cancelButton;
    public static WebElement resultText;
    @BeforeClass
    public static void initT() {
        //File file = new File("C:/Selenium/MicrosoftWebDriver2.exe");
        File file = new File("C:/Selenium/chromedriver.exe");
        //System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        //driver = new InternetExplorerDriver();
        driver=new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://localhost:8080/SampleJSP/sample");
        //driver.get("http://google.com");
    }

    @Test
    public void solveT() throws InterruptedException {
        /**One**/
        //driver.navigate().to("http://www.google.com");
        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));
        exprField.sendKeys("qwerty");

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField2.sendKeys("qwerty");


        cancelButton = driver.findElement(By.xpath("html/body/form/input[4]"));
        cancelButton.click();


        exprField.sendKeys("0");
        exprField2.sendKeys("1");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("1 2", resultText.getText());
        /**EndOne**/

        /**Two**/
        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField.sendKeys("0");
        exprField2.sendKeys("0");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("1", resultText.getText());
        /**EndTwo**/

        /**Three**/
        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));
        exprField.sendKeys("dfk");

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField2.sendKeys("dfkss");


        cancelButton = driver.findElement(By.xpath("html/body/form/input[4]"));
        cancelButton.click();


        exprField.sendKeys("0");
        exprField2.sendKeys("10");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("1 2 4 8 9 5 10 3 6 7 11", resultText.getText());
        /**EndThree**/

        /**Four**/
        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField.sendKeys("0");
        exprField2.sendKeys("3");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("1 2 4", resultText.getText());
        /**EndFour**/

        /**Five**/
        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField.sendKeys("0");
        exprField2.sendKeys("2");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("1 2 4 8 9 5 10 3", resultText.getText());
        /**EndFive**/
    }
    @Test
    public void exT() throws InterruptedException {
        /**One**/
        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField.sendKeys("0");
        exprField2.sendKeys("17");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("Second vertex is wrong", resultText.getText());

        /**EndOne**/

        /**Two**/

        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField.sendKeys("18");
        exprField2.sendKeys("0");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("First vertex is wrong", resultText.getText());

        /**EndTwo**/

        /**Three**/

        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField.sendKeys("gekfe");
        exprField2.sendKeys("2");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("There are wrong symbols at textfields", resultText.getText());

        /**EndThree**/

        /**Four**/

        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField.sendKeys("0");
        exprField2.sendKeys("hello");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("There are wrong symbols at textfields", resultText.getText());

        /**EndFour**/

        /**Five**/

        exprField = driver.findElement(By.xpath("html/body/form/input[1]"));

        exprField2 = driver.findElement(By.xpath("html/body/form/input[2]"));
        exprField.sendKeys("gekfe");
        exprField2.sendKeys("hello");


        solveButton = driver.findElement(By.xpath("html/body/form/input[3]"));
        solveButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resultText = driver.findElement(By.xpath("html/body/h2"));
        Assert.assertEquals("There are wrong symbols at textfields", resultText.getText());

        /**EndFive**/
    }
}
