package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //1. By locators
    private By emailId          = By.id("email");
    private By password         = By.id("passwd");
    private By buttom           = By.id("SubmitLogin");
    private By forgotPwdLink    = By.linkText("Forgot your password?1");

    //2. Constructor of the page class:
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //3. page actions: feaures(behavior) of the page the form of method:
    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public Boolean isForgotPwdLinkExist(){
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUsername(String usr){
        driver.findElement(emailId).sendKeys(usr);
    }

    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin(){
        driver.findElement(buttom).click();
    }

    //combined the 3 latest methods
    public AccountPage doLogin(String usr, String pwd){
        System.out.println("Login with " + usr + " and " + pwd);
        driver.findElement(emailId).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(buttom).click();

        return new AccountPage(driver);
    }

}
