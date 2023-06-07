package testAutomations.seleniumTest.TS_0005_Harita_Özellikleri_İşlemlerinin_Gösterimi;

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


public class TC_0005_04_Arama_İşlemleri_Hiyerarşik_Sorgulama extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(id = "kt_quick_panel_toggle")
    public WebElement panel;

    @FindBy(css = "#kt_quick_panel > div.offcanvas-header.offcanvas-header-navs.d-flex.align-items-center.justify-content-between.mb-5 > ul > li:nth-child(2) > a")
    public WebElement aramaIslemleri;

    @FindBy(xpath = "//div[contains(text(),'Hiyerarşik Sorgulama')]")
    public WebElement hiyerarsikSorgulama;

    @FindBy(css = "#HierarchicalQuery > div.jsPanel-ftr.active > button")
    public WebElement calistir;

    @FindBy(id = "map-content")
    public WebElement map;

    @FindBy(id = "feature_popup_div_width_buttons_demografik")
    public WebElement small;

    
    @Test
       
    public void testTC_0003_01_İl_Sınırlarının_Gösterilmesi() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(panel));
        panel.click();

        Fwait.until(ExpectedConditions.visibilityOf(aramaIslemleri));
        aramaIslemleri.click();
        Fwait.until(ExpectedConditions.visibilityOf(hiyerarsikSorgulama));
        hiyerarsikSorgulama.click();
        Thread.sleep(3000);

        // Şehir değiştirme
        js.executeScript("$('#hierarchical-city-list').val('6').trigger('change')");
        Thread.sleep(1000);
        //İlçe seçimi
        js.executeScript("$('#hierarchical-town-list').val('1427').trigger('change')");
        Thread.sleep(1000);
        js.executeScript("$('#hierarchical-neighborhood-list').val('14519').trigger('change')");
        Thread.sleep(1000);
        calistir.click();
        Thread.sleep(5000);

        Actions built = new Actions(driver);
        built.moveToElement(map).click().moveByOffset(0, 0).perform();

        Fwait.until(ExpectedConditions.visibilityOf(small));


        String bodyText = driver.findElement(By.cssSelector("#feature_popup_div_width_buttons_demografik")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Kaydet"));
        System.out.println("Ekleme kontrolü yapıldı.");


        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
