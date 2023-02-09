package testAutomations;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions; //3. olarak kontrol edilecek yer. İmport eklenmiş olmalı, bunu kontrol ediyoruz.
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;


/**
 * Created by Emre Örs
 * Selam Mert
 * Date : 22.04.2022
 */


public class TestBase extends TestCase {

    protected static WebDriver driver;
    protected static FluentWait<WebDriver> Fwait;
    protected static Actions actions; //1. eklenecek yer.
    protected  static long randomLong = ((long)((Math.random() * 1000)+1000));
    protected static final String SERVIS_ADRESI = "https://geomarkettest.basarsoft.com.tr/geomarket_pro/web/Login";
    protected String servisAdresi = SERVIS_ADRESI;
    protected static final Logger Logger = LoggerFactory.getLogger(TestBase.class);
    protected JavascriptExecutor scroll;
    protected StringBuffer verificationErrors = new StringBuffer();
    ChromeOptions options = new ChromeOptions();

    boolean isHeadless = true;


    @Before
    public void setUp() throws IOException {
        Locale.setDefault(new Locale("tr", "TR"));

        if (isHeadless) {
            WebDriverManager.chromedriver().setup();
            driver = setup_localDriver(isHeadless);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        Logger.info("setUp(servisAdresi=" + servisAdresi + ").");
        actions = new Actions(driver); //2. eklenecek yer
        Fwait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(60))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(NoSuchElementException.class);
        scroll = (JavascriptExecutor) driver;
//        driver.manage().window().maximize();
        options.addArguments("-incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> contentSettings = new HashMap<String, Object>();
        // SET CHROME OPTIONS
        // 0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 0);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver.get(servisAdresi);
    }





    protected static WebDriver setup_localDriver(boolean isHeadless) {
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");

        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-extensions");
        }

        options.setExperimentalOption("prefs", new HashMap<String, String>() {{put("intl.accept_languages", "tr,tr_TR");}});

        Logger.info("setup_localDriver("+(isHeadless?"headless":"head:real")+").");

        return new ChromeDriver(options);
    }

    public void kullaniciGirisYap(WebDriver driver, Kullanici kullanici){
        try{
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).clear();
            driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).sendKeys(kullanici.getAd());
            driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).clear();
            driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")).sendKeys(kullanici.getSifre());
            driver.findElement(By.xpath("//button[@id='kt_login_signin_submit']")).click();
            Thread.sleep(5000);
        }catch (Exception e){
            Logger.warn("Giriş Yapılamadı.!");
        }

    }
// Metod tanımlanıp sonrasında metod ismi ile direkt çağırılabilir.
//    public void MertinSuperMetodu(){
//        try{
//            driver.manage().window().maximize();
//
//            driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();
//        }catch (Exception e){
//            Logger.warn("Giriş Yapılamadı.!");
//        }
//
//    }
//    "C:\Users\mert.sen\Desktop\SSmania"

    public void resimCek() {
        try {
            Date currentDate = new Date();
            String screenshotfilename = currentDate.toString().replace(" ", "-").replace(":", "-");
            System.out.println(screenshotfilename);
            String name = getName();
            System.out.println(name);
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:/Users/mert.sen/Desktop/SSmania/" + name + "-" + screenshotfilename + ".png"));
        } catch (Exception e) {
            Logger.warn("Resim çekilemedi.");
        }
    }

    @After
    public void tearDown() throws Exception {
        Allure.addAttachment("Ekran Görüntüsü", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
