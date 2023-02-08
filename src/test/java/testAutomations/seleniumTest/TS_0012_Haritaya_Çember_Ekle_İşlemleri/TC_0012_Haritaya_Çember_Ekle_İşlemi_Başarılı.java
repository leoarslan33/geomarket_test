package testAutomations.seleniumTest.TS_0012_Haritaya_Çember_Ekle_İşlemleri;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;


public class TC_0012_Haritaya_Çember_Ekle_İşlemi_Başarılı extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#map-canvas > ul.flex-column.mt-4.nav.pb-3.pl-2.pr-2.pt-3.sticky-toolbar.sticky-toolbar-right.map-draw-tool > li:nth-child(3) > a")
    public WebElement haritayaCemberCizButonu;

    @FindBy(xpath = "//div[@id='kt_content']")
    public WebElement Harita;

    @FindBy(css = "#feature_popup_div_width_buttons_demografik > div.card-footer.d-flex.justify-content-between.p-3 > button.btn.btn-sm.btn-light-success")
    public WebElement kaydetButonu;

    @FindBy(xpath = "//span[@id='select2-table-select-container']")
    public WebElement tabloSecimi;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement filtrelemeButonu;

    @FindBy(xpath = "//input[@id='region-name']")
    public WebElement bölgeAdıGirisi;

    @FindBy(xpath = "//input[@id='3605']")
    public WebElement müsteriAdı;

    @FindBy(xpath = "//body/div[@id='DataPanel']/div[4]/button[1]")
    public WebElement bölgeEkleKaydetButonu;


    @Test
    public void testTC_0012_Haritaya_Çember_Ekle_İşlemi_Başarılı() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }


        Actions builder4 = new Actions(driver);
        builder4.moveToElement(Harita).clickAndHold().moveByOffset(100, 100).release().perform();
        builder4.doubleClick().perform();
        Thread.sleep(1000);
        builder4.doubleClick().perform();

        Fwait.until(ExpectedConditions.visibilityOf(haritayaCemberCizButonu));
        haritayaCemberCizButonu.click();

        Actions builder1 = new Actions(driver);
        builder1.moveToElement(Harita).moveByOffset(0, 0).release().perform();
        builder1.click().perform();

        Thread.sleep(1000);

        Actions builder2 = new Actions(driver);
        builder2.moveToElement(Harita).moveByOffset(50, 50).release().perform();
        builder2.click().perform();

        Actions builder3 = new Actions(driver);
        builder3.moveToElement(Harita).moveByOffset(0, 0).release().perform();
        builder3.click().perform();

        Fwait.until(ExpectedConditions.visibilityOf(kaydetButonu));
        kaydetButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(tabloSecimi));
        tabloSecimi.click();
        filtrelemeButonu.sendKeys("test");
        filtrelemeButonu.sendKeys(Keys.ENTER);

        Fwait.until(ExpectedConditions.visibilityOf(bölgeAdıGirisi));
        bölgeAdıGirisi.sendKeys("otomasyontest");

        Fwait.until(ExpectedConditions.visibilityOf(müsteriAdı));
        müsteriAdı.sendKeys("test");

        Fwait.until(ExpectedConditions.visibilityOf(bölgeEkleKaydetButonu));
        bölgeEkleKaydetButonu.click();



        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
