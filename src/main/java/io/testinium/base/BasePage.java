package io.testinium.base;

import io.appium.java_client.windows.WindowsDriver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.time.LocalDate;

public class BasePage {
    public final Logger logger = LogManager.getLogger(BasePage.class);
    private WindowsDriver driver;
    public static String getDate() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }
    public BasePage(){
        this.driver = BaseTest.driver;
    }
    public void clickElementByName(String by) throws InterruptedException {
        logger.info(by + " elementine tiklaniyor");
        driver.findElementByName(by).click();
        logger.info(by + " elementine tiklandi");

    }
    public void fileName(String key) throws InterruptedException {
        logger.info("Dosya aiı: " + key + " olarak kaydediliyor");
        driver.findElementByAccessibilityId("1001").click();
        driver.findElementByAccessibilityId("1001").clear();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("1001").sendKeys(key);
        logger.info("Dosya adi: " + key + " olarak kaydedildi");

    }
    public void ekranaYaziYaz(String key) throws InterruptedException {
        logger.info("Ekrana: " + key + " yaziliyor");
        driver.findElementByClassName("Edit").sendKeys(key);
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElementByClassName("Edit").getText(),key);
        logger.info("Ekrana: " + key + " yazildi");


    }
    public void enterPress(){
        driver.findElementByClassName("Edit").sendKeys(Keys.ENTER);
        logger.info("Alt satira gecildi");
    }
    public void cleanEdit() throws InterruptedException {
        driver.findElementByClassName("Edit").clear();
        Assert.assertEquals(driver.findElementByClassName("Edit").getText(),"");
        logger.info("Icerik Temizlendi.");
    }
    public void writeDate() {
       driver.findElementByClassName("Edit").sendKeys(getDate());
       Assert.assertNotNull( driver.findElementByClassName("Edit"));
       logger.info("Tarih yazdirildi");

    }
    public void sendMail() throws EmailException {
        logger.info("Mail gonderme islemi baslatiliyor");
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setAuthenticator(new DefaultAuthenticator("your-email@gmail.com","your-password"));
        email.setSSLOnConnect(true);
        email.setFrom("blabla@gmail.com");
        email.setSubject("WinAppMail");
        email.setMsg("Test Başarıyla Yapılmıştır Bilginize Sunarım");
        email.addTo("bla-bla@hotmail.com");
        email.send();
        logger.info("Mail gonderme islemi tamamlandi");

    }


}
