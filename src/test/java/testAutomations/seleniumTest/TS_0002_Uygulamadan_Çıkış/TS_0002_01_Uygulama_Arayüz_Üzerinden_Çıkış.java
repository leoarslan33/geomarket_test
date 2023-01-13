package testAutomations.TS_0003_İl_İlçe_Mahalle_Sınırlarının_Görüntülenmesi;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;


public class TS_0002_01_Uygulama_Arayüz_Üzerinden_Çıkış extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_quick_user_toggle")
    public WebElement acılırMenu;

    @FindBy(css = "#kt_quick_user > div.offcanvas-content.pr-5.mr-n5.scroll.ps > div.d-flex.align-items-center.mt-5 > div.d-flex.flex-column > div > a")
    public WebElement cıkısButonu;

    @FindBy(css = "#kt_body > div.bootbox.modal.fade.show > div > div > div.modal-footer > button.btn.btn-light-primary")
    public WebElement cıkısEvetButonu;

    @Test
    public void testTS_0002_01_Uygulama_Arayüz_Üzerinden_Çıkış() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Fwait.until(ExpectedConditions.visibilityOf(acılırMenu));
        acılırMenu.click();

        Fwait.until(ExpectedConditions.visibilityOf(cıkısButonu));
        cıkısButonu.click();

        Fwait.until(ExpectedConditions.visibilityOf(cıkısEvetButonu));
        cıkısEvetButonu.click();

        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
