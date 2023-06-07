package testAutomations.seleniumTest.TS_0020_Adres_Arama;

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

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

public class TC_0020_02_Adres_Arama_Arama_Gecmisi_Temizle extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(id = "geoAddresInput")
    public WebElement adresInput;

    @FindBy(id = "clear_pass")
    public WebElement clearPass; 

    
    @FindBy(css = "#kt_body > div.bootbox.modal.fade.show > div > div > div.modal-footer > button.btn.btn-light-success")
    public WebElement confirmButton ; 

    
    
    
    @Test

    public void testTC_0020_01_Adres_Arama_Basarili() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            Logger.warn("Kullanıcı login olamadı.");

        }

        WebElement[] elements = {adresInput,clearPass,confirmButton};

        for (WebElement element : elements) {
            try {
                     Fwait.until(ExpectedConditions.visibilityOf(element));
                     element.click();
                      
                 
                 } catch (Exception e) 
                 {
                     System.out.println("Hata oluştu: " + e.getMessage());
                 }
                 Thread.sleep(1000);     

 
        

        Thread.sleep(2000);  
    }
    
    }




}