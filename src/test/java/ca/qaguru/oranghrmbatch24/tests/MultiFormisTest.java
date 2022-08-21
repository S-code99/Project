package ca.qaguru.oranghrmbatch24.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MultiFormisTest {

    private String Base_Url = "http://website.multiformis.com/";

    @Test
    public void Task1Test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(Base_Url);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@aria-label='Close']"))));
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        driver.manage().window().fullscreen();
        driver.findElement(By.xpath("//a[contains(text(),'Sort and Tables')]")).click();
        String resultData = driver.findElement(By.xpath("//div[@class='dataTables_info']")).getText();
        String totalRows =  resultData.split(" ")[5];
        if(Integer.parseInt(totalRows)>25){
            driver.findElement(By.xpath("//th[text()='Age']")).click();
            driver.findElement(By.xpath("//th[text()='Age']")).click();
            String ageOfFirstPerson = driver.findElement(By.xpath("//tbody/tr/td[8]")).getText();
            System.out.println("Age of First Person "+ ageOfFirstPerson);
        }

    }
}
