package testAutomations.seleniumTest.TS_0006_Sorgulamalar_Hiyerarsik_Sorgulamalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class TC_0006_01_Sorgulamalar_Hiyerarsik_Sorgulamalar extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(id = "kt_quick_panel_toggle")
    public WebElement panel;

    @FindBy(xpath = "//a[contains(text(),'Arama İşlemleri')]")
    public WebElement aramaIslemleri;

    @FindBy(css = "#kt_quick_panel_2 > div.navi.navi-icon-circle.navi-spacer-x-0 > a:nth-child(4) > div")
    public WebElement HTS;

    @FindBy(css = "#hierarchical-query > div > div > div:nth-child(1) > div > span > span.selection > span > ul > li")
    public WebElement il;

    @FindBy(css = "#hierarchical-query > div > div > div:nth-child(2) > div > span > span.selection > span > ul")
    public WebElement ilce;

    @FindBy(css = "#hierarchical-query > div > div > div:nth-child(3) > div > span > span.selection > span > ul")
    public WebElement mahalle;

    @FindBy(css = "#HierarchicalQuery > div.jsPanel-ftr.active > button")
    public WebElement run;

    @Test
    public void testTC_0006_01_Sorgulamalar_Hiyerarsik_Sorgulamalar() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        } catch (Exception e) {
            Logger.warn("Kullanıcı login olamadı.");
        }

        WebElement[] elements = { panel, aramaIslemleri, HTS };

        for (WebElement element : elements) {
            try {
                Fwait.until(ExpectedConditions.visibilityOf(element));
                element.click();

            } catch (Exception e) {
                System.out.println("Hata oluştu: " + e.getMessage());
            }
            Thread.sleep(1000);
        }


        Robot robot = new Robot();

        Actions action = new Actions(driver);
        actions.click(il).sendKeys("ankara").perform();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        actions.click(ilce).sendKeys("Çankaya").perform();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);

        actions.click(mahalle).sendKeys("100. yıl").perform();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);

        
        


        Fwait.until(ExpectedConditions.visibilityOf(run));
        run.click();
    }
}