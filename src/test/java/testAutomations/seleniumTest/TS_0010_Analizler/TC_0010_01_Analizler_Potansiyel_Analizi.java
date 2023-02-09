package testAutomations.seleniumTest.TS_0010_Analizler;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;


public class TC_0010_01_Analizler_Potansiyel_Analizi extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_quick_panel > div.quick-panel-toggle > ul:nth-child(2) > li:nth-child(3) > a > i")
    public WebElement analizlerButonu;

    @FindBy(css = "#kt_quick_panel_3 > div.navi.navi-icon-circle.navi-spacer-x-0 > a:nth-child(1) > div > div.navi-text > div")
    public WebElement potansiyelAnalizButonu;

    @FindBy(xpath = "//body/div[@id='PotentialAnalysisWindow']/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/ul[1]/li[1]/input[1]")
    public WebElement ilSecimi;

    @FindBy(css = "#analysis-potential > div:nth-child(2) > div.card-body > div > div:nth-child(2) > span > span.selection > span > ul > li > input")
    public WebElement ilceSecimi;

    @FindBy(xpath = "//body/div[@id='PotentialAnalysisWindow']/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]")
    public WebElement KendiNoktalarımSecimi;


    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement tabloGiris;

    @FindBy(css = "#analysis-potential > div:nth-child(3) > div.card-body > div:nth-child(2) > div > span > span.selection > span > ul > li > input")
    public WebElement markaGirisi;

    @FindBy(css = "#PotentialAnalysisWindow > div.jsPanel-ftr.active > button")
    public WebElement calıstırButonu;


    @Test
    public void testTC_0010_01_Analizler_Potansiyel_Analizi() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(analizlerButonu));
        analizlerButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(potansiyelAnalizButonu));
        potansiyelAnalizButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(ilSecimi));
        ilSecimi.click();
        ilSecimi.sendKeys("ankara");
        ilSecimi.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(ilceSecimi));
        Thread.sleep(2000);
        ilceSecimi.click();
        ilceSecimi.sendKeys("cankaya");
        ilceSecimi.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(KendiNoktalarımSecimi));
        KendiNoktalarımSecimi.click();
        Thread.sleep(2000);
        tabloGiris.sendKeys("müs");
        tabloGiris.sendKeys(Keys.ENTER);

        Fwait.until(ExpectedConditions.visibilityOf(markaGirisi));
        markaGirisi.click();
        Thread.sleep(1000);
        markaGirisi.sendKeys("a-1");
        Thread.sleep(1000);
        markaGirisi.sendKeys(Keys.ENTER);

        Fwait.until(ExpectedConditions.visibilityOf(calıstırButonu));
        calıstırButonu.click();

        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
