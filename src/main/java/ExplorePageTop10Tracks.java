import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExplorePageTop10Tracks
{
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy (xpath = "//*[@id='explore-content']//div[contains(@class,'queueable top featured-list')]/div[1]/div")
    WebElement top10TrackBlockTitle;
    @FindBy (xpath = "//div[@id ='explore-content']//div[contains(@class, 'top__item')]")
    List<WebElement> listLab;


    public ExplorePageTop10Tracks(WebDriver driver)
    {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);
        PageFactory.initElements(webDriver, this);
    }


    public void top10TracksProfileName()
    {
       System.out.println(top10TrackBlockTitle.getText());


        if (listLab.size() ==10) {
            System.out.println("Количество элементов в списке");
            System.out.println(listLab.size());
            for (int nomer = 0; nomer < listLab.size(); nomer++) {
                String exploreTrackTitle = listLab.get(nomer).findElement(By.xpath(".//div[@class='top-track__info']/div[1]/a")).getText();
                listLab.get(nomer).findElement(By.xpath(".//div[@class='top-track__info']/div[1]/a")).click();
                String trackProfilePagetitle = webDriver.findElement(By.xpath("//div[@class = 'track-big__info']/a")).getText();
                Assert.assertEquals(exploreTrackTitle, trackProfilePagetitle);
                System.out.println("Profile page belong to selected top track " + exploreTrackTitle);
                webDriver.navigate().back();
            }
        }
        else {
            System.out.println("Количество элементов в списке");
            System.out.println(listLab.size());System.out.println("Elements amount = " + listLab.size());

        }

    }


    public  void top10TracksDJ()
    {    System.out.println(listLab.size());
        for (int nomer = 0; nomer <listLab.size(); nomer++)
        {
            String exploreTrackTitle = listLab.get(nomer).findElement(By.xpath(".//div[@class='top-track__info']/div[1]/a")).getText();
            listLab.get(nomer).findElement(By.xpath(".//div[@class='top-track__info']/div[1]/div[1]/a")).click();
            String trackProfilePagetitle = webDriver.findElement(By.xpath("//div[@class = 'track-big__info']/a")).getText();
            Assert.assertEquals(exploreTrackTitle, trackProfilePagetitle);
            System.out.println("Profile icon belong to selected  track " + exploreTrackTitle);
            webDriver.navigate().back();
        }
    }


}
