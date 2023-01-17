package testAutomations.TS_0003_İl_İlçe_Mahalle_Sınırlarının_Görüntülenmesi;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;

import java.security.Key;


public class TC_0010_05_Analizler_Hiyerarşik_Tüik_Sorgulama extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_quick_panel > div.quick-panel-toggle > ul:nth-child(2) > li:nth-child(3) > a > i")
    public WebElement analizlerButonu;

    @FindBy(xpath = "//span[@id='select2-city-list-single-container']")
    public WebElement ilSecimiTuik;

    @FindBy(css = "#tuik_panel_form > div > div.townSelectTest.col-12.mt-5 > span > span.selection > span")
    public WebElement ilceSecimiTuik;

    @FindBy(xpath = "//body/div[@id='kt_quick_panel']/div[3]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[4]/span[1]/span[1]/span[1]/ul[1]")
    public WebElement tipSecimiTuik;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement tabloGirisi2;

    @FindBy(xpath = "//button[@id='btn-run-tuik-polygon']")
    public WebElement getirButonu;


    @Test
    public void testTC_0010_05_Analizler_Hiyerarşik_Tüik_Sorgulama() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(analizlerButonu));
        analizlerButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(ilSecimiTuik));
        ilSecimiTuik.click();
        tabloGirisi2.sendKeys("ankara");
        tabloGirisi2.sendKeys(Keys.ENTER);

        Fwait.until(ExpectedConditions.visibilityOf(ilceSecimiTuik));
        Thread.sleep(2000);
        ilceSecimiTuik.sendKeys("cankaya");
        ilceSecimiTuik.click();
        ilceSecimiTuik.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(tipSecimiTuik));
        Thread.sleep(2000);
        tipSecimiTuik.click();
        tipSecimiTuik.sendKeys("Tip");
        tipSecimiTuik.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(getirButonu));
        getirButonu.click();

        System.out.println("Test Tamamlandı!");
        Thread.sleep(30000);
    }
}
