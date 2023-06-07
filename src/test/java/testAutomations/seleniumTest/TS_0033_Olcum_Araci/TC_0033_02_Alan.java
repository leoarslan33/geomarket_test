
package testAutomations.seleniumTest.TS_0033_Olcum_Araci;



import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testAutomations.Kullanici;


public class TC_0033_02_Alan  extends testAutomations.TestBase {
    private String baseUrl;

    @FindBy(css = "#kt_header > div > div > div.topbar > div:nth-child(10) > div.topbar-item > div")
    public WebElement cizimAraclari;

    @FindBy(css = "#kt_header > div > div > div.topbar > div.dropdown.show > div.dropdown-menu.p-0.m-0.dropdown-menu-right.dropdown-menu-anim-up.dropdown-menu-lg.min-w-lg-250px.w-auto.mapiconsdropdown.show > div > h4:nth-child(2) > a")
    public WebElement alan;

    @FindBy(xpath = "//div[@id='kt_content']")
    public WebElement haritaAlanCiz;

    




    @Test
    public void testTC_0033_02_Alan() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try{
            kullaniciGirisYap(driver, Kullanici.KULLANICI1);
        }catch (Exception e){
            Logger.warn("Kullanıcı login olamadı.");
        }

        Thread.sleep(1000);
        
        Actions builder4 = new Actions(driver);
        builder4.moveToElement(haritaAlanCiz).clickAndHold().moveByOffset(0, 0).release().perform();
        builder4.doubleClick().perform();
        Thread.sleep(1000);
        builder4.doubleClick().perform();
        Thread.sleep(1000);
        builder4.doubleClick().perform();
        
        Fwait.until(ExpectedConditions.visibilityOf(cizimAraclari));
        cizimAraclari.click();

        Fwait.until(ExpectedConditions.visibilityOf(alan));
        alan.click();



   

        Actions builder1 = new Actions(driver);
        builder1.moveToElement(haritaAlanCiz).moveByOffset(0, 0).click().perform();

        Thread.sleep(1000);

        Actions builder2 = new Actions(driver);
        builder2.moveToElement(haritaAlanCiz).moveByOffset(0, 150).click().perform();
      


        Thread.sleep(1000);
        
        Actions builder3 = new Actions(driver);
        builder3.moveToElement(haritaAlanCiz).moveByOffset(150, 0).click().perform();
        builder4.doubleClick().perform();

        Thread.sleep(3000);

  
  
    }
}