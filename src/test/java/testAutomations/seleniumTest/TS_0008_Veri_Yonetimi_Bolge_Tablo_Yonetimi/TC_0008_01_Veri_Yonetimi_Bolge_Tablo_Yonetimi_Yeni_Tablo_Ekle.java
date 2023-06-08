package testAutomations.seleniumTest.TS_0008_Veri_Yonetimi_Bolge_Tablo_Yonetimi;

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


public class TC_0008_01_Veri_Yonetimi_Bolge_Tablo_Yonetimi_Yeni_Tablo_Ekle extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(id = "kt_quick_panel_toggle")
    public WebElement panel;
    
    @FindBy(css = "#kt_quick_panel > div.offcanvas-header.offcanvas-header-navs.d-flex.align-items-center.justify-content-between.mb-5 > ul > li:nth-child(4) > a")
    public WebElement veriYonetimi;

    @FindBy(css = "#kt_quick_panel_4 > div.navi.navi-icon-circle.navi-spacer-x-0 > a:nth-child(2) > div")
    public WebElement bolgeTabloYonetim;

    @FindBy(css = "#IndexTablePanel > div.jsPanel-ftr.active > button.btn.btn-light-success.pull-right")
    public WebElement yeniTabloEkle;

    @FindBy(css = "#table_name")
    public WebElement tabloAdi;

    @FindBy(xpath =  "//body/div[@id='TablePanel']/div[2]/div[2]/div[1]/div[2]/button[2]")
    public WebElement addPart ;

    @FindBy(css =  "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div.row.show-grid.myrow.mb-5 > div.col-md-4 > input")
    public WebElement addPartName ;

    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div.row.show-grid.myrow.mb-5 > div:nth-child(2) > select")
    public WebElement lookUP ;
    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div.row.show-grid.myrow.mb-5 > div:nth-child(2) > select > option:nth-child(2)")
    public WebElement yesNo;
    
    @FindBy(css = "#btn_region_table_add")
    public WebElement save; 

    @Test
       
    public void testTC_0008_01_Veri_Yonetimi_Bolge_Tablo_Yonetimi_Yeni_Tablo_Ekle() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

       

        WebElement[] elements = {panel,veriYonetimi,bolgeTabloYonetim,yeniTabloEkle,tabloAdi,addPart,addPartName,lookUP,yesNo,save};

        for (WebElement element : elements) {
            try {
                     Fwait.until(ExpectedConditions.visibilityOf(element));
                     element.click();
                        
                     if(element == elements[6])

                        {
                           
                            element.sendKeys("test");
                        }else{
                            
                        }

                        if(element == elements[4]){
                            element.sendKeys("1  A_test_oto_bolge");
                        }else{

                        }
                 
                 } catch (Exception e) 
                 {
                     System.out.println("Hata oluştu: " + e.getMessage());
                 }
                 Thread.sleep(3000);     
        }



    }









}
