package testAutomations.TS_0003_İl_İlçe_Mahalle_Sınırlarının_Görüntülenmesi;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;


public class TC_0003_02_İlçe_Sınırlarının_Gösterilmesi_Zoom_11e_Eşit_ve_Büyükse extends testAutomations.TestBase {
    private String baseUrl;


    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/canvas[1]")
    public WebElement harita;

    @FindBy(xpath = "//a[@id='kt_quick_panel_toggle']")
    public WebElement acılırMenu;

    @FindBy(xpath = "//label[contains(text(),'Adres')]")
    public WebElement adresAcılırMenu;

    @FindBy(xpath = "//body/div[@id='kt_quick_panel']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[2]/a[1]/div[1]")
    public WebElement ilceAcılırMenu;

    @Test
    public void testTC_0003_02_İlçe_Sınırlarının_Gösterilmesi_Zoom_11e_Eşit_ve_Büyükse() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }




        Fwait.until(ExpectedConditions.visibilityOf(acılırMenu));
        acılırMenu.click();

        Fwait.until(ExpectedConditions.visibilityOf(adresAcılırMenu));
        adresAcılırMenu.click();

        Fwait.until(ExpectedConditions.visibilityOf(ilceAcılırMenu));
        ilceAcılırMenu.click();

        Actions builder = new Actions(driver);
        builder.moveToElement(harita).perform();
        builder.doubleClick().perform();

        Actions builder1 = new Actions(driver);
        builder1.moveToElement(harita).perform();
        builder1.doubleClick().perform();

        Actions builder2 = new Actions(driver);
        builder2.moveToElement(harita).perform();
        builder2.doubleClick().perform();

        Actions builder3 = new Actions(driver);
        builder3.moveToElement(harita).perform();
        builder3.doubleClick().perform();

        Actions builder4 = new Actions(driver);
        builder4.moveToElement(harita).perform();
        builder4.doubleClick().perform();

        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
