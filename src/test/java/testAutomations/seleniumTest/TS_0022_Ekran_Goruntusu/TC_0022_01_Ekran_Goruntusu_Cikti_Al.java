package testAutomations.seleniumTest.TS_0022_Ekran_Goruntusu;

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

public class TC_0022_01_Ekran_Goruntusu_Cikti_Al extends testAutomations.TestBase {
    private String baseUrl;
    
    @FindBy(css = "#kt_header > div > div > div.topbar > div:nth-child(11) > div")
    public WebElement SSscreen;

    @FindBy(css = "#kt_body > div.bootbox.modal.fade.show > div > div > div.modal-footer > button.btn.btn-light-danger")
    public WebElement ciktiAl ;

    @FindBy(css = "#PrintScreen > div.jsPanel-ftr.active > button")
    public WebElement ciktiAl2;

     
    @Test

    public void testTC_0022_01_Ekran_Goruntusu_Cikti_Al() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            Logger.warn("Kullanıcı login olamadı.");

        }

        WebElement[] elements = {SSscreen,ciktiAl,ciktiAl2};

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


