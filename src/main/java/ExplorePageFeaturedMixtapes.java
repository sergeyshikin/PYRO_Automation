import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExplorePageFeaturedMixtapes
{
    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy (xpath = "//div[@class='covers-list__top']/a")
    WebElement showMoreMixtapes;
    @FindBy (xpath = "//div[@class='covers-list__title covers-list__title--large']")
    WebElement blockTitle;
    @FindBy (xpath = "//div[@id ='explore-content']//div[contains(@class, 'covers-item--float-wrapper')]")
    List<WebElement> listMix;
    @FindBy (xpath = "//div[@class = 'track-big__info']/a")
    WebElement trackTitle;
    @FindBy (xpath ="//div[@id ='explore-content']//div[contains(@class, 'queueable covers-list__content')]")
    WebElement exploreTrackTitle;
    @FindBy (xpath = "//div[@class = 'profile-item__name']/span")
    WebElement djProfilePageName;
    @FindBy (xpath = "//div[@class = 'labels-item__name']")
    WebElement labelProflePageName;





    public ExplorePageFeaturedMixtapes(WebDriver driver)
    {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);

        PageFactory.initElements(webDriver, this);

    }
     public void showMoreMixtapes ()
     {
         String releasedTrackBlockTitle = blockTitle.getText();
         System.out.println("Tested block is  " + releasedTrackBlockTitle);
         Assert.assertEquals(releasedTrackBlockTitle, "Featured Mixtapes");
         showMoreMixtapes.click();
         Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/mixtapes/global_recommended");
         System.out.println("Link Show More for Featured on Explore works correct");
         System.out.println("Featured Mixtapes page was opened");

     }

    public void allMixtapeProfiles ()
    {
        System.out.println("Количество элементов в списке");
        System.out.println(listMix.size());

        for (int nomer = 1; nomer <= listMix.size(); nomer++)
        {
            String exploreMixtapeTitle = exploreTrackTitle.findElement(By.xpath("./div[" + nomer + "]/a")).getText();
            exploreTrackTitle.findElement(By.xpath("./div[" + nomer + "]/a")).click();
            String trackProfilePagetitle =trackTitle.getText();
            Assert.assertEquals(exploreMixtapeTitle, trackProfilePagetitle);
            System.out.println("Track profile page belong to selected track " + exploreMixtapeTitle);

            webDriver.navigate().back();
        }

    }

    public void allMixtapeDj ()
    {
        System.out.println("Количество элементов в списке");
        System.out.println(listMix.size());

        for (int nomer = 1; nomer <= listMix.size(); nomer++)
        {
            String exploreMixtapeDj = exploreTrackTitle.findElement(By.xpath("./div[" + nomer + "]/div[2]/a")).getText();
            exploreTrackTitle.findElement(By.xpath("./div[" + nomer + "]/div[2]/a")).click();
            String url = webDriver.getCurrentUrl();
            if (url.contains("keyword"))
            {
                System.out.println("DJ" + exploreMixtapeDj + " is not in base");
            }
            else
                {

                if (djProfilePageName.isDisplayed())
                {
                    String trackProfilePagetitle = djProfilePageName.getText();
                    Assert.assertEquals(exploreMixtapeDj, trackProfilePagetitle);
                    System.out.println("Track DJ profile page belong to selected track DJ" + exploreMixtapeDj);
                }
                else
                    {
                    String trackProfilePagetitle = labelProflePageName.getText();
                    Assert.assertEquals(exploreMixtapeDj, trackProfilePagetitle);
                    System.out.println("Track DJ profile page belong to selected track DJ" + exploreMixtapeDj);
                     }


                }
            webDriver.navigate().back();
        }
    }


}
