package io.testinium.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WindowsDriver driver = null;

    @BeforeScenario
    public static void setUp(){
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app","C:\\Windows\\system32\\notepad.exe");
            capabilities.setCapability("platformName","Windows");
            capabilities.setCapability("deviceName","WindowsPC");
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"),capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        } catch (Exception e){
            e.printStackTrace();

        }
    }

    @AfterScenario
    public void tearDown(){
        driver.quit();
    }

}
