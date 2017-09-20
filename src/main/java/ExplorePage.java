import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplorePage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath = "/html/body/header/div[1]/nav/a[2]")
    WebElement exploreHeaderItem;


    public ExplorePage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);

        PageFactory.initElements(webDriver, this);

    }

    public void itemClick() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[2]/div[1]/div[1]/a")));
        exploreHeaderItem.click();
    }

}

