package testAutomations.seleniumTest.TS_0007_Veri_Yönetimi_Nokta_Tablo_Yönetimi;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;

public class TC_0007_01_Veri_Yönetimi_Nokta_Tablo_Yönetimi_Yeni_Tablo_Ekle extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(id = "kt_quick_panel_toggle")
    public WebElement panel;

    @FindBy(css = "#kt_quick_panel > div.offcanvas-header.offcanvas-header-navs.d-flex.align-items-center.justify-content-between.mb-5 > ul > li:nth-child(4) > a")
    public WebElement veriYonetimi;

    @FindBy(css = "#kt_quick_panel_4 > div > a:nth-child(1) > div")
    public WebElement noktaTabloYonetim;

    @FindBy(css = "#IndexTablePanel > div.jsPanel-ftr.active > button.btn.btn-light-success.pull-right")
    public WebElement yeniTabloEkle;

    @FindBy(css = "#table_name")
    public WebElement addTableName;

    @FindBy(xpath =  "//body/div[@id='TablePanel']/div[2]/div[2]/div[1]/div[2]/button[2]")
    public WebElement addPart;

    @FindBy(xpath = "//body/div[@id='TablePanel']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement addKolonName;
    
    @FindBy(xpath="//body/div[@id='TablePanel']/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/select[1]")
    public WebElement takeLookUp;

    @FindBy(xpath = "//option[contains(text(),'Evet / Hayır')]")
    public WebElement yesNo;
   

    @FindBy(css = "#TablePanel > div.jsPanel-ftr.active > button")
    public WebElement saveBtn;
    
    @Test
       
    public void testTC_0007_01_Veri_Yönetimi_Nokta_Tablo_Yönetimi_Yeni_Tablo_Ekle () throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(panel));
        panel.click();
        
        Fwait.until(ExpectedConditions.visibilityOf(veriYonetimi));
        veriYonetimi.click();

        Fwait.until(ExpectedConditions.visibilityOf(noktaTabloYonetim));
        noktaTabloYonetim.click();

        Fwait.until(ExpectedConditions.visibilityOf(yeniTabloEkle));
        yeniTabloEkle.click();

        Fwait.until(ExpectedConditions.visibilityOf(addTableName));
        addTableName.click();
        
        addTableName.sendKeys("1 A_Test_oto");

        Thread.sleep(2000);

        Fwait.until(ExpectedConditions.visibilityOf(addPart));
        addPart.click();

        Fwait.until(ExpectedConditions.visibilityOf(addKolonName));
        addKolonName.click();

        addKolonName.sendKeys("test_oto");

        Fwait.until(ExpectedConditions.visibilityOf(takeLookUp));
        takeLookUp.click();

        Fwait.until(ExpectedConditions.visibilityOf(yesNo));
        yesNo.click();

        Fwait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();


        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}




