import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExplorePageSSDJ
{
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='explore-content']//div[@class = 'featured__list featured-list featured-list--dj']/div[1]/a")
    WebElement showMoreSSDj;
    @FindBy (xpath = "//*[@id='explore-content']//div[@class = 'featured__list featured-list featured-list--dj']//div[@class = 'featured-list__title']")
    WebElement SSBlockTitle;
    @FindBy (xpath = "//div[@id ='explore-content']//div[contains(@class, 'featured-list__item')]")
    List<WebElement> listLab;
    @FindBy (xpath = "//div[@id ='explore-content']//div[contains(@class, 'featured__list featured-list')]")
    WebElement labMas;

    public ExplorePageSSDJ(WebDriver driver)
    {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }

    public void showMoreSSDj()
    {
        String Labels = SSBlockTitle.getText();
        System.out.println("Tested block is  " + Labels);
        Assert.assertEquals(Labels, "Superstar DJs");
        showMoreSSDj.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/djs/superstar");
        System.out.println("Link Show More for SS Dj on Explore page works correct");
        System.out.println("SS DJs page was opened");
    }

}
