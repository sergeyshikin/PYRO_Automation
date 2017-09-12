import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExplorePageFeaturedPlaylists {


        private WebDriver webDriver;
        private WebDriverWait wait;


        @FindBy(xpath = "//*[@id='explore-content']/div[3]/div[1]/a")
        WebElement showMorePlaylist;

        public ExplorePageFeaturedPlaylists(WebDriver driver) {
            webDriver = driver;
            wait = new WebDriverWait(webDriver, 60);

            PageFactory.initElements(webDriver, this);

        }

        public void showMorePlaylist() {
            String releasedTrackBlockTitle = webDriver.findElement(By.xpath("//div[@class='covers-list covers-list--margin']//div[@class='covers-list__title covers-list__title--large']")).getText();
            System.out.println("Tested block is  " + releasedTrackBlockTitle);
            Assert.assertEquals(releasedTrackBlockTitle, "Featured Playlists");
            showMorePlaylist.click();
            Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/playlists/global_recommended");
            System.out.println("Link Show More for Featured on Explore works correct");
            System.out.println("Featured Mixtapes page was opened");

        }

        public void allPlaylistsProfiles ()
        {
            List<WebElement> listMix;
            listMix = webDriver.findElements(By.xpath("//div[@id ='explore-content']//div[contains(@class, 'paginatable-item')]"));
            System.out.println("Количество элементов в списке");
            System.out.println(listMix.size());

            for (int nomer = 1; nomer <= listMix.size(); nomer++) {
                String exploreMixtapeTitle = webDriver.findElement(By.xpath("//div[@id ='explore-content']//div[contains(@class, 'covers-list--margin')]/div[2]/div[" + nomer + "]/a"))
                        .getText();
                webDriver.findElement(By.xpath("//div[@id ='explore-content']//div[contains(@class, 'covers-list--margin')]/div[2]/div[" + nomer + "]/a"))
                        .click();
                String trackProfilePagetitle = webDriver.findElement(By.xpath("//div[@class = 'labels-item__name']"))
                        .getText();
                Assert.assertEquals(exploreMixtapeTitle, trackProfilePagetitle);
                System.out.println("Track profile page belong to selected track " + exploreMixtapeTitle);
                webDriver.navigate().back();
            }

        }

        public  void allPlaylistsAuthor ()
        {
            List<WebElement> listMix;
            listMix = webDriver.findElements(By.xpath("//div[@id ='explore-content']//div[contains(@class, 'paginatable-item')]"));
            System.out.println("Количество элементов в списке");
            System.out.println(listMix.size());

            for (int nomer = 1; nomer <= listMix.size(); nomer++) {
                String exploreMixtapeDj = webDriver.findElement(By.xpath("//div[@id ='explore-content']//div[contains(@class, 'covers-list--margin')]/div[2]/div[" + nomer + "]/div[2]/a"))
                        .getText();
                webDriver.findElement(By.xpath("//div[@id ='explore-content']//div[contains(@class, 'covers-list--margin')]/div[2]/div[" + nomer + "]/div[2]/a")).click();
                String url = webDriver.getCurrentUrl();
                if (url.contains("keyword")) {
                    System.out.println("DJ" + exploreMixtapeDj + " is not in base");
                } else {


                    String trackProfilePagetitle = webDriver.findElement(By.xpath("//div[@class = 'profile-item__name']/span"))
                            .getText();
                    Assert.assertEquals(exploreMixtapeDj, trackProfilePagetitle);
                    System.out.println("Track DJ profile page belong to selected track DJ" + exploreMixtapeDj);
                }
                webDriver.navigate().back();
            }



        }


}
