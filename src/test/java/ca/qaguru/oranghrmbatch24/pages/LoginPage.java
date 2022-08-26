package ca.qaguru.oranghrmbatch24.pages;


import ca.qaguru.oranghrmbatch24.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends PageBase {
    //changing id into name and class

    private String idUsername = "username";
    private String idPassword = "password";
    private String idLogin = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button";
    private String idErrMsg = "oxd-alert-content.oxd-alert-content--error";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password, boolean validCredentials, String expErrMsg){
        setText(By.name(idUsername), username);
        setText(By.name(idPassword),password);
        click(By.xpath(idLogin));

        HeaderPage headerPage = new HeaderPage(driver);
        if(validCredentials){
            Assert.assertTrue(headerPage.isMenuVisible());
        }else {
            Assert.assertFalse(headerPage.isMenuVisible());
            Assert.assertEquals(getText(By.className(idErrMsg)),expErrMsg, "Incorrect Error Message");
        }
    }

}
