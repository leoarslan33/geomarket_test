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
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import javax.swing.*;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class TC_0007_07_Veri_Yonetimi_Nokta_Tablo_Yönetimi_Tablo_Seçimli_İmport extends testAutomations.TestBase {
    private String baseUrl;
    
    @FindBy(id = "kt_quick_panel_toggle")
    public WebElement panel;

    @FindBy(css = "#kt_quick_panel > div.offcanvas-header.offcanvas-header-navs.d-flex.align-items-center.justify-content-between.mb-5 > ul > li:nth-child(4) > a")
    public WebElement veriYonetimi;

    @FindBy(css = "#kt_quick_panel_4 > div > a:nth-child(1) > div")
    public WebElement noktaTabloYonetim;

    @FindBy(css = "#index-point-table > div > div.card-body.pt-5.pb-5 > div > div:nth-child(1) > a.btn.btn-icon.btn-light-dark.btn-sm.mr-2")
    public WebElement NoktaTabloImportsecimli ;
                    
    @FindBy(css = "#area-icon-choose-panel > div:nth-child(3) > div.row > div.col-lg-9 > div > label")
    public WebElement dosyaSec ;
    
    @FindBy(css = "#check-file-button")
    public WebElement NoktaTabloImportKontrol ;

    @FindBy(css ="#import-file-button")
    public WebElement importBtn ;
    
    
    @Test

    public void testTC_0007_05_Veri_Yonetimi_Nokta_Tablo_Yonetimi_Export () throws Exception {

        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");

        }
        
        WebElement[] elements = {panel,veriYonetimi,noktaTabloYonetim,NoktaTabloImportsecimli,dosyaSec,NoktaTabloImportKontrol,importBtn};

        for (WebElement element : elements) {
            try {   
               

                     if(element != elements[4]){
                         
                        Fwait.until(ExpectedConditions.visibilityOf(element));
                     element.click();
                        
                    
 

                     }else{
                    
                        String filePath = "C:\\Users\\Basarsoft\\Downloads\\ornek-sablon-133642406.xlsx";
                        Robot robot = new Robot();
                        Fwait.until(ExpectedConditions.visibilityOf(element));
                        element.click();

                        Thread.sleep(1500);
            
                   
                        StringSelection stringSelection = new StringSelection(filePath);
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
            
                       
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                     }

                     
                      
                 
                 } catch (Exception e) 
                 {
                     System.out.println("Hata oluştu: " + e.getMessage());
                 }
                 Thread.sleep(1500);     
        }
        
    }


   


}
