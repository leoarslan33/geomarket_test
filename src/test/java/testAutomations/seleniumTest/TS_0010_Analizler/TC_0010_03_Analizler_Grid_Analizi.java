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


public class TC_0010_03_Analizler_Grid_Analizi extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_quick_panel > div.quick-panel-toggle > ul:nth-child(2) > li:nth-child(3) > a > i")
    public WebElement analizlerButonu;

    @FindBy(xpath = "//div[contains(text(),'Grid Analizi')]")
    public WebElement gridAnalizButonu;

    @FindBy(css = "#state-div > div:nth-child(1) > span > span.selection > span > ul > li > input")
    public WebElement ilSecimi;

    @FindBy(css = "#state-town-list > span > span.selection > span > ul > li > input")
    public WebElement ilceSecimi;

    @FindBy(css = "#state-neighborhood-list > span > span.selection > span > ul > li > input")
    public WebElement mahalleSecimi;

    @FindBy(xpath = "//span[@id='select2-analysis-area-container']")
    public WebElement analizYüzeyi;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement analizYüzeyiarama;

    @FindBy(xpath = "//input[@id='grid-size']")
    public WebElement GridBoyutu;

    @FindBy(xpath = "//span[@id='select2-grid-type-container']")
    public WebElement GridTürü;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement tabloGirisi2;

    @FindBy(xpath = "//span[@id='select2-grid-point-table-select-container']")
    public WebElement kendiTablolarım;

    @FindBy(xpath = "//span[@id='select2-grid_analysis_column-container']")
    public WebElement analizKolonuSecimi;

    @FindBy(css = "#drop-down-color-button")
    public WebElement renkSeciniz;

    @FindBy(css =  "#drop-down-color > a:nth-child(1) > div:nth-child(2)")
    public WebElement renkSecimi;

    @FindBy(css = "#DynamicGridPanel > div.jsPanel-ftr.active > button")
    public WebElement analizButonu;

    @Test
    public void testTC_0010_03_Analizler_Grid_Analizi() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(analizlerButonu));
        analizlerButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(gridAnalizButonu));
        gridAnalizButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(ilSecimi));
        ilSecimi.click();
        ilSecimi.sendKeys("ankara");
        ilSecimi.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(ilceSecimi));
        Thread.sleep(2000);
        ilceSecimi.click();
        ilceSecimi.sendKeys("cankaya");
        ilceSecimi.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(mahalleSecimi));
        Thread.sleep(2000);
        mahalleSecimi.click();
        mahalleSecimi.sendKeys("100");
        mahalleSecimi.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(analizYüzeyi));
        Thread.sleep(2000);
        analizYüzeyi.click();
        analizYüzeyiarama.sendKeys("grid");
        analizYüzeyiarama.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(GridBoyutu));
        GridBoyutu.sendKeys("1000");


        Fwait.until(ExpectedConditions.visibilityOf(GridTürü));
        Thread.sleep(2000);
        GridTürü.click();
        tabloGirisi2.sendKeys("square");
        tabloGirisi2.sendKeys(Keys.ENTER);

        Fwait.until(ExpectedConditions.visibilityOf(kendiTablolarım));
        Thread.sleep(2000);
        kendiTablolarım.click();
        tabloGirisi2.sendKeys("muster");
        tabloGirisi2.sendKeys(Keys.ENTER);

        Fwait.until(ExpectedConditions.visibilityOf(analizKolonuSecimi));
        Thread.sleep(2000);
        analizKolonuSecimi.click();
        tabloGirisi2.sendKeys("sıra");
        tabloGirisi2.sendKeys(Keys.ENTER);

        Fwait.until(ExpectedConditions.visibilityOf(renkSeciniz));
        renkSeciniz.click();

        Fwait.until(ExpectedConditions.visibilityOf(renkSecimi));
        renkSecimi.click();

        Fwait.until(ExpectedConditions.visibilityOf(analizButonu));
        analizButonu.click();

        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
