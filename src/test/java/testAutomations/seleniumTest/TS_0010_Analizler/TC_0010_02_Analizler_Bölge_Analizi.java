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


public class TC_0010_02_Analizler_Bölge_Analizi extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_quick_panel > div.quick-panel-toggle > ul:nth-child(2) > li:nth-child(3) > a > i")
    public WebElement analizlerButonu;

    @FindBy(xpath = "//div[contains(text(),'Bölge Analizi')]")
    public WebElement bölgeAnaliziButonu;

    @FindBy(css = "#stateDiv > div:nth-child(1) > span > span.selection > span > ul > li > input")
    public WebElement ilSecimi;

    @FindBy(css = "#stateDiv > div:nth-child(2) > span > span.selection > span > ul > li > input")
    public WebElement ilceSecimi;

    @FindBy(css = "#stateDiv > div:nth-child(3) > span > span.selection > span > ul > li > input")
    public WebElement mahalleSecimi;


    @FindBy(xpath = "//span[@id='select2-region_table_select-container']")
    public WebElement kendiBölgeSecimi;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement tabloGirisi;

    @FindBy(xpath = "//span[@id='select2-analysis_column-container']")
    public WebElement AnalizVerisecimi;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement tabloGirisi2;

    @FindBy(xpath = "//button[contains(text(),'Analiz')]")
    public WebElement analizButonu;

    @Test
    public void testTC_0010_02_Analizler_Bölge_Analizi() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(analizlerButonu));
        analizlerButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(bölgeAnaliziButonu));
        bölgeAnaliziButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(ilSecimi));
        ilSecimi.click();
        ilSecimi.sendKeys("istanbul");
        ilSecimi.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(ilceSecimi));
        Thread.sleep(2000);
        ilceSecimi.click();
        ilceSecimi.sendKeys("atasehir");
        ilceSecimi.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(mahalleSecimi));
        Thread.sleep(2000);
        mahalleSecimi.click();
        mahalleSecimi.sendKeys("asıkveysel");
        mahalleSecimi.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(kendiBölgeSecimi));
        Thread.sleep(2000);
        kendiBölgeSecimi.click();
        tabloGirisi.sendKeys("Boyner");
        tabloGirisi.sendKeys(Keys.ENTER);

        Fwait.until(ExpectedConditions.visibilityOf(AnalizVerisecimi));
        Thread.sleep(2000);
        AnalizVerisecimi.click();
        tabloGirisi2.sendKeys("ciro");
        tabloGirisi2.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(analizButonu));
        analizButonu.click();

        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
