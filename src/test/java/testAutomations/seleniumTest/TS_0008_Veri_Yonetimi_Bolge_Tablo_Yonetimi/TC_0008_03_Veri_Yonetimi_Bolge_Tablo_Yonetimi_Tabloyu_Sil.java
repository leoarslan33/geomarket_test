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


public class TC_0008_03_Veri_Yonetimi_Bolge_Tablo_Yonetimi_Tabloyu_Sil extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(id = "kt_quick_panel_toggle")
    public WebElement panel;
    
    @FindBy(css = "#kt_quick_panel > div.offcanvas-header.offcanvas-header-navs.d-flex.align-items-center.justify-content-between.mb-5 > ul > li:nth-child(4) > a")
    public WebElement veriYonetimi;

    @FindBy(css = "#kt_quick_panel_4 > div.navi.navi-icon-circle.navi-spacer-x-0 > a:nth-child(2) > div")
    public WebElement bolgeTabloYonetim;

    
    @FindBy(css = "#index-region-table > div > div.card-body.pt-5.pb-5 > div > div:nth-child(1) > a.btn.btn-icon.btn-light-danger.btn-sm.mr-2")
    public WebElement delete;


    @Test
       
    public void testTC_0008_03_Veri_Yonetimi_Bolge_Tablo_Yonetimi_Tabloyu_Sil() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

       

        WebElement[] elements = {panel,veriYonetimi,bolgeTabloYonetim,delete};

        for (WebElement element : elements) {
            try {
                     Fwait.until(ExpectedConditions.visibilityOf(element));
                     element.click();
                        
                     System.out.println("test adimi tamamlandi" + element);
                   
                 
                 } catch (Exception e) 
                 {
                     System.out.println("Hata oluştu: " + e.getMessage());
                 }
                 Thread.sleep(1500);     
        }

        
        System.out.println("Test Tamamlandi");
    }



}