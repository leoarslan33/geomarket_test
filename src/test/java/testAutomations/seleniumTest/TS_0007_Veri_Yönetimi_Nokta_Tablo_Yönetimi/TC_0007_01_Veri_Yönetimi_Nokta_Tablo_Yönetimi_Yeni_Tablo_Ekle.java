package testAutomations.seleniumTest.TS_0007_Veri_Yönetimi_Nokta_Tablo_Yönetimi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

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

    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div.row.show-grid.myrow.mb-5 > div.col-md-4 > input")
    public WebElement addKolonName;
    
    @FindBy(id="poi-edit-add-column-button")
    public WebElement takeLookUp;

    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div.row.show-grid.myrow.mb-5 > div:nth-child(2) > select > option:nth-child(2)")
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




