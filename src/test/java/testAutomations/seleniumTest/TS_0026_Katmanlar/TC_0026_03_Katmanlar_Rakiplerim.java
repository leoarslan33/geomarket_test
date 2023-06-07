

package testAutomations.seleniumTest.TS_0026_Katmanlar;

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

public class TC_0026_03_Katmanlar_Rakiplerim extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_quick_panel_toggle")
    public WebElement solMenu;
                    
    @FindBy(xpath =  "//body/div[@id='kt_quick_panel']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[3]/span[1]/span[1]")
    public WebElement rakiplerim;

    @FindBy(xpath =  "//body/div[@id='kt_quick_panel']/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[3]/ul[1]/li[1]/span[1]/span[2]")
    public WebElement rakiplerim2;


    @Test

    public void testTC_0026_03_Katmanlar_Rakiplerim() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            Logger.warn("Kullanıcı login olamadı.");

        }

        WebElement[] elements = { solMenu, rakiplerim, rakiplerim2 };

        for (WebElement element : elements) {
            try {
                Fwait.until(ExpectedConditions.visibilityOf(element));
                element.click();

            } catch (Exception e) {
                System.out.println("Hata oluştu: " + e.getMessage());
                Thread.sleep(1000);

           
            }
           

            Thread.sleep(2000);
        }

    }

}