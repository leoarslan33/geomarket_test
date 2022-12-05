package testAutomations;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;


public class login extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(xpath = "//a[@id='kt_quick_panel_toggle']")
    public WebElement elementVarName;


    @Test
    public void testlogin() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(elementVarName));
        elementVarName.click();

        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
