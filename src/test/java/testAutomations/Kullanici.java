package testAutomations;

import org.junit.Ignore;

/**
 * Created by Emre Örs
 * Date :22.04.2022
 */
@Ignore
public enum Kullanici {

    KULLANICI1("demouser", "demo_2021*"),
    KULLANICI2("botas", "123456"),
    KULLANICI3("sube_muduru", "123456"),
    KULLANICI4("daire_baskani", "123456"),
    KULLANICI5("genel_mudur_yardimcisi", "123456"),
    KULLANICI6("genel_mudur","123456");





    private String ad;
    private String sifre;

    public String getAd() {
        return ad;
    }

    public String getSifre() {
        return sifre;
    }

    Kullanici(String ad, String sifre) {
        this.ad = ad;
        this.sifre = sifre;
    }
}