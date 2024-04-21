import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeleteMessage = "Deleted playlist \"test2.\"";

        provideEmail("joseph.petersen@testpro.io");
        providePassword("QaOneTwo!!!");
        clickSubmitBtn();
        openPlaylist();
        clickDeletePlaylistBtn();
        //clickOkToDelete();
        Assert.assertEquals(getDeletePlaylistMsg(), expectedPlaylistDeleteMessage);
    }

    public void openPlaylist() {
        WebElement playListElement = driver.findElement(By.xpath("//a[@href='#!/playlist/93991']"));
        playListElement.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement clickDeleteBtn = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        clickDeleteBtn.click();
    }

    public void clickOkToDelete(){
        WebElement clickOkToDelete = driver.findElement(By.cssSelector("button[class='ok']"));
        clickOkToDelete.click();
    }

    public String getDeletePlaylistMsg(){
        //WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notificationMsg = driver.findElement(By.cssSelector("div[class='success show']"));
        return notificationMsg.getText();
    }


}