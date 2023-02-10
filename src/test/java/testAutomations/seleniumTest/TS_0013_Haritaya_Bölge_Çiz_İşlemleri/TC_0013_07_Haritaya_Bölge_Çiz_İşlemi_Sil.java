package testAutomations.seleniumTest.TS_0013_Haritaya_Bölge_Çiz_İşlemleri;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;


public class TC_0013_07_Haritaya_Bölge_Çiz_İşlemi_Sil extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(xpath = "//body/div[@id='kt_quick_panel']/div[1]/ul[1]/li[2]/a[1]/i[1]")
    public WebElement aramaİslemleri;

    @FindBy(css = "#kt_quick_panel_2 > div.navi.navi-icon-circle.navi-spacer-x-0 > a:nth-child(2)")
    public WebElement kendiBölgelerim;

    @FindBy(xpath = "//span[@id='select2-region-table-select-container']")
    public WebElement bölgeTabloSecimi;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement bölgeTabloSecimiAramaButonu;

    @FindBy(xpath = "//body/div[@id='SearchingRegionsTablePanel']/div[4]/button[1]")
    public WebElement ListeHazırlaButonu;

    @FindBy(css = "#SearchingRegionsTablePanel > div.jsPanel-hdr.jsPanel-theme-default > div.jsPanel-headerbar > div.jsPanel-controlbar > div.jsPanel-btn.jsPanel-btn-minimize")
    public WebElement sayfaAsagıİndir;

    @FindBy(xpath = "//div[@id='kt_content']")
    public WebElement haritaBölgeCiz;

    @FindBy(css = "#kt_quick_panel_toggle")
    public WebElement sekmeKapama;

    @FindBy(id = "feature-remove")
    public WebElement SilButonu;

    @FindBy(xpath = "//button[contains(text(),'Evet')]")
    public WebElement SilEvetButonu;



    @Test
    public void testTC_0013_07_Haritaya_Bölge_Çiz_İşlemi_Sil() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(aramaİslemleri));
        aramaİslemleri.click();

        Fwait.until(ExpectedConditions.visibilityOf(kendiBölgelerim));
        kendiBölgelerim.click();

        Fwait.until(ExpectedConditions.visibilityOf(bölgeTabloSecimi));
        bölgeTabloSecimi.click();
        bölgeTabloSecimiAramaButonu.sendKeys("BOLGE_TEST_001");
        bölgeTabloSecimiAramaButonu.sendKeys(Keys.ENTER);

        Fwait.until(ExpectedConditions.visibilityOf(ListeHazırlaButonu));
        ListeHazırlaButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(sayfaAsagıİndir));
        sayfaAsagıİndir.click();

        Fwait.until(ExpectedConditions.visibilityOf(sekmeKapama));
        sekmeKapama.click();

        Actions builder1 = new Actions(driver);
        builder1.moveToElement(haritaBölgeCiz).clickAndHold().moveByOffset(-300, -400).release().perform();
        builder1.doubleClick().perform();
        Thread.sleep(1000);
        builder1.doubleClick().perform();

        Actions builder2 = new Actions(driver);
        builder2.moveToElement(haritaBölgeCiz).clickAndHold().moveByOffset(0, 50).release().perform();
        builder2.click().perform();

        Fwait.until(ExpectedConditions.visibilityOf(SilButonu));
        SilButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(SilEvetButonu));
        SilEvetButonu.click();

        Actions builder3 = new Actions(driver);
        builder3.moveToElement(haritaBölgeCiz).clickAndHold().moveByOffset(0, 0).release().perform();
        builder3.click().perform();

        Fwait.until(ExpectedConditions.visibilityOf(SilButonu));
        SilButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(SilEvetButonu));
        SilEvetButonu.click();


        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
