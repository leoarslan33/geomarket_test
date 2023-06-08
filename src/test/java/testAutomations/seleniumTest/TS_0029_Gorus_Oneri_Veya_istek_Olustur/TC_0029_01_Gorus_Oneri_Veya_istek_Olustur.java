package testAutomations.seleniumTest.TS_0029_Gorus_Oneri_Veya_istek_Olustur;

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
    


public class TC_0029_01_Gorus_Oneri_Veya_istek_Olustur extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_header > div > div > div.topbar > div:nth-child(2) > div")
    public WebElement gorusOneriBtn;

    @FindBy(id = "feedback_title")
    public WebElement title;

    @FindBy(id = "feedback_selector")
    public WebElement requestType;

    @FindBy(css = "#feedback_selector > option:nth-child(3)")
    public WebElement type;

    @FindBy(id = "feedback_description")
    public WebElement description;

    @FindBy(css = "#FeedbackPanel > div.jsPanel-ftr.active > button")
    public WebElement send;

    @Test

    public void testTC_0029_01_Gorus_Oneri_Veya_istek_Olustur() throws Exception {

        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            Logger.warn("Kullanıcı login olamadı.");

        }
        Fwait.until(ExpectedConditions.visibilityOf(gorusOneriBtn));
        gorusOneriBtn.click();
         
        title.sendKeys("test_oto_deneme");

        Fwait.until(ExpectedConditions.visibilityOf(requestType));
        requestType.click();

        Fwait.until(ExpectedConditions.visibilityOf(type));
        type.click();

        description.sendKeys("test_oto_deneme_description");

        
        Fwait.until(ExpectedConditions.visibilityOf(send));
        send.click();
        
        
         

        





            Thread.sleep(1000);
        
    }




   
    



}