import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ExplorePageHotLabels
{
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy (xpath = "//*[@id='explore-content']//div[@class = 'featured-list__top']/a")
    WebElement showMoreHL;
    @FindBy (xpath = "//*[@id='explore-content']//div[@class = 'featured-list__title']")
    WebElement labelBlockTitle;
    @FindBy (xpath = "//div[@id ='explore-content']//div[contains(@class, 'featured-list__item')]")
    List<WebElement> listLab;
    @FindBy (xpath = "//div[@id ='explore-content']//div[contains(@class, 'featured__list featured-list')]")
    WebElement labMas;

    public ExplorePageHotLabels(WebDriver driver)
    {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);

        PageFactory.initElements(webDriver, this);

    }

    public  void showMoreHotLabels()

    {
        String hotLabels = labelBlockTitle.getText();
        System.out.println("Tested block is  " + hotLabels);
        Assert.assertEquals(hotLabels, "Hot Labels");
        showMoreHL.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/record_labels/global_recommended");
        System.out.println("Link Show More for HOT LABELS on Explore page works correct");
        System.out.println("Featured Labels page was opened");
    }

    public void allLabelsProfiles()
    {
        System.out.println("Количество элементов в списке");
        System.out.println(listLab.size());

        for (int nomer = 0; nomer <listLab.size(); nomer++)
        {
            String exploreTrackTitle = listLab.get(nomer).findElement(By.xpath("./div/a")).getText();
            listLab.get(nomer).findElement(By.xpath("./div/a")).click();
            String trackProfilePagetitle = webDriver.findElement(By.xpath("//div[@class = 'labels-item__name']")).getText();
            Assert.assertEquals(exploreTrackTitle, trackProfilePagetitle);
            System.out.println("Track profile page belong to selected track " + exploreTrackTitle);
            webDriver.navigate().back();
        }

    }






    }



