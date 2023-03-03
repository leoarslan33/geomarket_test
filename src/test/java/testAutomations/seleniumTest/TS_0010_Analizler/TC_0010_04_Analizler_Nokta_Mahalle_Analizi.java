package testAutomations.seleniumTest.TS_0010_Analizler;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;


public class TC_0010_04_Analizler_Nokta_Mahalle_Analizi extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_quick_panel > div.quick-panel-toggle > ul:nth-child(2) > li:nth-child(3) > a > i")
    public WebElement analizlerButonu;

    @FindBy(xpath = "//div[contains(text(),'Nokta & Mahalle Analizi')]")
    public WebElement noktaMahalleAnalizi;

    @FindBy(xpath = "//span[@id='select2-neighbourhood-analysis-city-list-container']")
    public WebElement ilSecimi;

    @FindBy(xpath = "//body/div[@id='NeighbourHoodAnalysisWindow']/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/span[1]/span[1]/span[1]/ul[1]/li[1]/input[1]")
    public WebElement ilceSecimi;

    @FindBy(xpath = "//body/div[@id='NeighbourHoodAnalysisWindow']/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/span[1]/span[1]/span[1]/ul[1]/li[1]/input[1]")
    public WebElement mahalleSecimi;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement tabloGirisi2;

    @FindBy(xpath = "//span[@id='select2-neighbourhoud-point-table-select-container']")
    public WebElement kendiTablolarım;

    @FindBy(xpath = "//body/div[@id='NeighbourHoodAnalysisWindow']/div[4]/button[1]")
    public WebElement görüntüleButonu;

    @Test
    public void testTC_0010_04_Analizler_Nokta_Mahalle_Analizi() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(analizlerButonu));
        analizlerButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(noktaMahalleAnalizi));
        noktaMahalleAnalizi.click();

        Fwait.until(ExpectedConditions.visibilityOf(ilSecimi));
        ilSecimi.click();
        Thread.sleep(2000);
        tabloGirisi2.sendKeys("ankara");
        tabloGirisi2.sendKeys(Keys.ENTER);


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


        Fwait.until(ExpectedConditions.visibilityOf(kendiTablolarım));
        Thread.sleep(2000);
        kendiTablolarım.click();
        tabloGirisi2.sendKeys("muster");
        tabloGirisi2.sendKeys(Keys.ENTER);


        Fwait.until(ExpectedConditions.visibilityOf(görüntüleButonu));
        görüntüleButonu.click();

        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
