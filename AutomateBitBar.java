package Demo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class AutomateBitBar {
    public static void main (String[] args) throws MalformedURLException {

        //Desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:deviceName","AndroidEmulator");
        capabilities.setCapability("appium:platformname","Android");
        capabilities.setCapability("appium:automationName","uiautomator2");
        capabilities.setCapability("appium:platformversion","13.0");

        capabilities.setCapability("appium:appPackage","com.bitbarsampleapp");
        capabilities.setCapability("appium:appActivity","com.bitbarsampleapp.MainActivity");

        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver = new AndroidDriver(url, capabilities);

        //Clicking
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Biometric authentication']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Ask biometric authentication']")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Force pass callback']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Check
        String txt1 = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup[2]")).getText();
        if (txt1 == "SUCCEEDED") {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}
