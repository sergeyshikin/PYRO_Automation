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
    @FindBy (xpath = "//div[@id ='explore-content']//div[contains(@class, 'featured-dj__item')]")
    List<WebElement> listLab;


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

    public void ssDjProfilename()
    {
        System.out.println("Количество элементов в списке");
        System.out.println(listLab.size());

        for (int nomer = 0; nomer <listLab.size(); nomer++)
        {
            String exploreTrackTitle = listLab.get(nomer).findElement(By.xpath("./div/a/span[1]")).getText();
            listLab.get(nomer).findElement(By.xpath("./div/a/span[1]")).click();
            String trackProfilePagetitle = webDriver.findElement(By.xpath("//div[@class = 'profile-item__name']/span[1]")).getText();
            Assert.assertEquals(exploreTrackTitle, trackProfilePagetitle);
            System.out.println("Profile page belong to selected SS Dj " + exploreTrackTitle);
            webDriver.navigate().back();
        }
    }
    public  void ssDjProfileIcons()
    {    System.out.println(listLab.size());
        for (int nomer = 0; nomer <listLab.size(); nomer++)
        {
            String exploreTrackTitle = listLab.get(nomer).findElement(By.xpath("./div/a/span[1]")).getText();
            listLab.get(nomer).findElement(By.xpath(".//div[@class ='featured-dj__img']")).click();
            String trackProfilePagetitle = webDriver.findElement(By.xpath("//div[@class = 'profile-item__name']/span[1]")).getText();
            Assert.assertEquals(exploreTrackTitle, trackProfilePagetitle);
            System.out.println("Profile icon belong to selected SS Dj " + exploreTrackTitle);
            webDriver.navigate().back();
        }
    }


}
