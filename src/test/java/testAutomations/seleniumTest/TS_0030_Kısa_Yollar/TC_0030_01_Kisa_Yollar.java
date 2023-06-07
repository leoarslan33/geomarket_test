package testAutomations.seleniumTest.TS_0030_Kısa_Yollar;

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
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
    
public class TC_0030_01_Kisa_Yollar extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_header > div > div > div.topbar > div:nth-child(6) > div")
    public WebElement shortcuts ;

    @Test

    public void testTC_0030_01_Kisa_Yollar() throws Exception {

        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            Logger.warn("Kullanıcı login olamadı.");

        }
        Fwait.until(ExpectedConditions.visibilityOf(shortcuts));
        shortcuts.click();
        Thread.sleep(1500);
    }

}