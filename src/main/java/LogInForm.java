import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LogInForm {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath = "//div[1]/div/a/span")
    WebElement regButton;

    @FindBy(className = "bottom-link")
    WebElement emailLink;

    @FindBy(id ="user_email" )
    WebElement emailField;

    @FindBy(id ="user_password" )
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;



   public LogInForm(WebDriver driver) {

        webDriver = driver;
        wait = new WebDriverWait(webDriver, 50);
        PageFactory.initElements(webDriver, this);
        }

    public void logInFlow(){
        webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        regButton.click();
        emailLink.click();
        emailField.sendKeys("sergey.shikin@jetruby.com");
        passwordField.sendKeys("as3fc85d");
        loginButton.click();


    }






}