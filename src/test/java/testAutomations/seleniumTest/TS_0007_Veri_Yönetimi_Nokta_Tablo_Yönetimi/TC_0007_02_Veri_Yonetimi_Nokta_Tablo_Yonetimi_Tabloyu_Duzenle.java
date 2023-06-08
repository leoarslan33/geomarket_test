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



public class TC_0007_02_Veri_Yonetimi_Nokta_Tablo_Yonetimi_Tabloyu_Duzenle extends testAutomations.TestBase {
    private String baseUrl;

    
           

    @FindBy(id = "kt_quick_panel_toggle")
    public WebElement panel;

    @FindBy(css = "#kt_quick_panel > div.offcanvas-header.offcanvas-header-navs.d-flex.align-items-center.justify-content-between.mb-5 > ul > li:nth-child(4) > a")
    public WebElement veriYonetimi;

    @FindBy(css = "#kt_quick_panel_4 > div > a:nth-child(1) > div")
    public WebElement noktaTabloYonetim;

    
    @FindBy(css = "#index-point-table > div > div.card-body.pt-5.pb-5 > div > div:nth-child(1) > a.btn.btn-icon.btn-light-success.btn-sm.mr-2")
    public WebElement noktaTabloDüzenle;
    // #index-point-table > div > div.card-body.pt-5.pb-5 > div > div:nth-child(47) > a.btn.btn-icon.btn-light-success.btn-sm.mr-2

    @FindBy(css = "#table_name")
    public WebElement addTableName;

    @FindBy(xpath = "//body/div[@id='TablePanel']/div[2]/div[2]/div[1]/div[2]/button[2]")
    public WebElement addPart;

    
    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div:nth-child(1) > div.col-md-4 > input")
    public WebElement addKolonName;

    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div:nth-child(2) > div.col-md-4 > input")
    public WebElement addKolonName2;
    
    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div:nth-child(1) > div:nth-child(2) > select")
    public WebElement takeLookUp;

    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div:nth-child(2) > div:nth-child(2) > select")
    public WebElement takeLookUp2;
    

    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div.row.show-grid.myrow.mb-5 > div:nth-child(2) > select > option:nth-child(2)")
    public WebElement yesNo;

    @FindBy(css = "#TablePanel > div.jsPanel-content > div:nth-child(2) > div.card-body > div > div:nth-child(2) > div:nth-child(2) > select > option:nth-child(2)")
    public WebElement yesNo2;
    
    
    @FindBy(xpath =  "/html/body/div[18]/div[2]/div[2]/div[1]/div[2]/button[1]")
    public WebElement partIslemleri;

    @FindBy(id =  "part_name")
    public WebElement addPartNameIn;

    
    @FindBy(id =  "order_no")
    public WebElement orderNo;

    @FindBy(css =   "#PartPanel > div.jsPanel-ftr.active > button.btn.btn-light-success")
    public WebElement partSave;


    @FindBy(css =    "#TablePanel > div.jsPanel-ftr.active > button")
    public WebElement save;
    



    @Test
       
    public void testTC_0007_02_Veri_Yonetimi_Nokta_Tablo_Yonetimi_Tabloyu_Duzenle () throws Exception {

        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        // WebElement[] elements = {panel,veriYonetimi,noktaTabloYonetim,noktaTabloDüzenle,addTableName,addPart,addKolonName,addKolonName2,takeLookUp,takeLookUp2,yesNo,yesNo2,partIslemleri,addPartNameIn,orderNo,partSave,save};
        WebElement[] elements = {panel,veriYonetimi,noktaTabloYonetim,noktaTabloDüzenle,addTableName,addKolonName,takeLookUp,yesNo,partIslemleri,addPartNameIn,orderNo,partSave,addPart,addKolonName2,takeLookUp2,yesNo2,save};

        for (WebElement element : elements) {
            try {
                     Fwait.until(ExpectedConditions.visibilityOf(element));
                     element.click();
                        if(element == elements[4] || element == elements[5] || element == elements[9] || element == elements[13])

                        {
                           
                            element.sendKeys("test");
                        }else{
                            
                        }

                        if(element == elements[10]){
                            element.sendKeys("1");
                        }else{

                        }
                 
                 } catch (Exception e) 
                 {
                     System.out.println("Hata oluştu: " + e.getMessage());
                 }
                 Thread.sleep(1000);     
        }

        
        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
        
   
    }

           


}
