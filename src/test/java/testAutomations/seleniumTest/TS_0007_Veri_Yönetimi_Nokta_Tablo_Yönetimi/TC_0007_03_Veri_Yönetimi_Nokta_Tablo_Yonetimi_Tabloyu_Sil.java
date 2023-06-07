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

public class TC_0007_03_Veri_Yönetimi_Nokta_Tablo_Yonetimi_Tabloyu_Sil extends testAutomations.TestBase {
    private String baseUrl;
    
    @FindBy(id = "kt_quick_panel_toggle")
    public WebElement panel;

    @FindBy(css = "#kt_quick_panel > div.offcanvas-header.offcanvas-header-navs.d-flex.align-items-center.justify-content-between.mb-5 > ul > li:nth-child(4) > a")
    public WebElement veriYonetimi;

    @FindBy(css = "#kt_quick_panel_4 > div > a:nth-child(1) > div")
    public WebElement noktaTabloYonetim;

    @FindBy(css = "#index-point-table > div > div.card-body.pt-5.pb-5 > div > div:nth-child(1) > a.btn.btn-icon.btn-light-danger.btn-sm.mr-2")
    public WebElement tabloSil;

    @FindBy(css = "#kt_body > div.bootbox.modal.fade.show > div > div > div.modal-footer > button.btn.btn-light-success.mt-1")
    public WebElement tabloSilOnay;


    

    
    @Test
       
    public void testTC_0007_03_Veri_Yönetimi_Nokta_Tablo_Yonetimi_Tabloyu_Sil () throws Exception {

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

        Fwait.until(ExpectedConditions.visibilityOf(tabloSil));
        tabloSil.click();

        Fwait.until(ExpectedConditions.visibilityOf(tabloSilOnay));
        tabloSilOnay.click();

        

    }






}
