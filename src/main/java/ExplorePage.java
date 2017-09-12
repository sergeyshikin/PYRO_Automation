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


    @FindBy (xpath = "/html/body/header/div[1]/nav/a[2]")
    WebElement exploreHeaderItem;




    public ExplorePage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait (webDriver, 60);

        PageFactory.initElements(webDriver, this);

    }

    public void itemClick(){

       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[2]/div[1]/div[1]/a")));
       exploreHeaderItem.click();
    }



 /*


 public  void showMoreHotLabels()

    {
        String hotLabels = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[4]/div/div[1]/div[1]/div")).getText();
        System.out.println("Tested block is  " + hotLabels);
        Assert.assertEquals(hotLabels, "Hot Labels");
        showMoreHL.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/record_labels/global_recommended");
        System.out.println("Link Show More for HOT LABELS on Explore page works correct");
        System.out.println("Featured Labels page was opened");
    }

 public void labelsProfilePage()
    {
        exploreHeaderItem.click();
        String exploreLabelTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[4]/div/div[1]/div[2]/div/a")).getText();
        labelTitle.click();
        String labelProfilePageTitle = webDriver.findElement(By.xpath("//*[@id=\"profiles-show\"]/div[2]/div/div[1]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(exploreLabelTitle, labelProfilePageTitle);
        System.out.println("Label profile page belong to selected track " + exploreLabelTitle);
    }

 public void labelsProfilePageIcon()
    {
        exploreHeaderItem.click();
        String exploreLabelTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[4]/div/div[1]/div[2]/div/a")).getText();
        labelIcon.click();
        String labelProfilePageTitle = webDriver.findElement(By.xpath("//*[@id=\"profiles-show\"]/div[2]/div/div[1]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(exploreLabelTitle, labelProfilePageTitle);
        System.out.println("Label profile page belong to selected track " + exploreLabelTitle);
    }




      public  void showMoreSSDjs()
    {
        String ssDjs = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[4]/div/div[2]/div[1]/div")).getText();
        System.out.println("Tested block is  " + ssDjs);
        Assert.assertEquals(ssDjs, "Superstar DJs");
        showMoressDjs.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/djs/superstar");
        System.out.println("Link Show More for SUPERSTAR Djs on Explore page works correct");
        System.out.println("SuperstarDJs page was opened");
    }
*/
     }








