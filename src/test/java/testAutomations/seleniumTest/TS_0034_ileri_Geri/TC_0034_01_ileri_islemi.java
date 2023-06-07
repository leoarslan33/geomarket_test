package testAutomations.seleniumTest.TS_0034_ileri_Geri;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;

public class TC_0034_01_ileri_islemi extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(xpath = "//div[@id='kt_content']")
    public WebElement zoom;

    @FindBy(css = "#kt_header > div > div > div.topbar > div:nth-child(4) > div")
    public WebElement geriAl;

    @Test
    public void testTC_0034_01_ileri_islemi() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            Logger.warn("Kullanıcı login olamadı.");
        }

        Thread.sleep(1000);

        Actions builder4 = new Actions(driver);
        builder4.moveToElement(zoom).clickAndHold().moveByOffset(0, 0).release().perform();
        builder4.doubleClick().perform();
        Thread.sleep(1000);
        builder4.doubleClick().perform();

        Thread.sleep(1000);

        Fwait.until(ExpectedConditions.visibilityOf(geriAl));
        geriAl.click();

        Thread.sleep(1000);

    }
}
