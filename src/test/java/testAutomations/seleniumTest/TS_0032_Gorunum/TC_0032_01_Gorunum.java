package testAutomations.seleniumTest.TS_0032_Gorunum;

import org.apache.commons.exec.ExecuteException;
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

public class TC_0032_01_Gorunum extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_header > div > div > div.topbar > div:nth-child(7) > div")
    public WebElement see;
    @FindBy(css = "#map-canvas > div.ol-viewport > canvas")
    public WebElement click;

    @Test
    public void testTC_0032_01_Gorunum() throws Exception {
        PageFactory.initElements(driver, this);

        try {
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            Logger.warn("Kullanıcı login olamadı.");
        }
        
        Actions actions = new Actions(driver);
        actions.doubleClick(click).perform();
        
        
        Thread.sleep(4000);

        Fwait.until(ExpectedConditions.visibilityOf(see));
        see.click();
        

    }
}