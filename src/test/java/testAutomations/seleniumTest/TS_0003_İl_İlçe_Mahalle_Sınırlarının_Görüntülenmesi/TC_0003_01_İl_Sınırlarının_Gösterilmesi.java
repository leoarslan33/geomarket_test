package testAutomations.seleniumTest.TS_0003_İl_İlçe_Mahalle_Sınırlarının_Görüntülenmesi;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;


public class TC_0003_01_İl_Sınırlarının_Gösterilmesi extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(xpath = "//a[@id='kt_quick_panel_toggle']")
    public WebElement acılırMenu;

    @FindBy(xpath = "//label[contains(text(),'Adres')]")
    public WebElement adresAcılırMenu;

    @FindBy(id = "#layer-item-2")
    public WebElement ilAcılırMenu;

    @Test
    public void testTC_0003_01_İl_Sınırlarının_Gösterilmesi() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(acılırMenu));
        acılırMenu.click();

        Fwait.until(ExpectedConditions.visibilityOf(adresAcılırMenu));
        adresAcılırMenu.click();

//        Fwait.until(ExpectedConditions.visibilityOf(ilAcılırMenu));
//        ilAcılırMenu.click();
        Thread.sleep(3000);
        js.executeScript("document.querySelector('#layer-item-2').click()");

        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
