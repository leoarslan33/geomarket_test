package testAutomations;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Emre Örs
 * @Date 25.04.2022
 */
public class ShmLogin extends testAutomations.TestBase {
    private String baseUrl;
    private boolean acceptNextAlert = true;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement kullanıcıAdi;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/input[1]")
    public WebElement sifre;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/button[1]/span[1]")
    public WebElement girisYapButonu;

//    @FindBy(xpath = "")
//    public WebElement elementVarName;
//
//    @FindBy(xpath = "")
//    public WebElement elementVarName;



    @Test
    public void testShmLogin() throws Exception {
        PageFactory.initElements(driver, this);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Logger.info("Start Test");
        System.out.println("test Start");

        Fwait.until(ExpectedConditions.visibilityOf(kullanıcıAdi));
        kullanıcıAdi.click();
        kullanıcıAdi.clear();
        kullanıcıAdi.sendKeys("demouser");

        Logger.info("Kullanıcı Adı Girildi");
        System.out.println("Kullanıcı adı girildi 2");

        Fwait.until(ExpectedConditions.visibilityOf(sifre));
        sifre.click();
        sifre.clear();
        sifre.sendKeys("demo_2021*");

        Logger.info("sifre Girildi");
        System.out.println("Sifre Girildi2");

        Fwait.until(ExpectedConditions.visibilityOf(girisYapButonu));

        girisYapButonu.click();


        System.out.println("Test Tamamlandı!");
        Thread.sleep(3000);
    }
}
