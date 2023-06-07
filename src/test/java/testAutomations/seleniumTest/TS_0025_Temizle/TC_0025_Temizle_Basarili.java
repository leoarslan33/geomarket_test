package testAutomations.seleniumTest.TS_0025_Temizle;

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

public class TC_0025_Temizle_Basarili extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_header > div > div > div.topbar > div:nth-child(9) > div")
    public WebElement clean;


    @Test

    public void testTC_0025_Temizle_Basarili() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            Logger.warn("Kullanıcı login olamadı.");

        }

        try {
            Fwait.until(ExpectedConditions.visibilityOf(clean));
            clean.click();

        } catch (Exception e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }
        Thread.sleep(1000);

        

    }

}
