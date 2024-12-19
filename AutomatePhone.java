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

public class AutomatePhone {
    public static void main (String[] args) throws MalformedURLException {

        //Desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:deviceName","AndroidEmulator");
        capabilities.setCapability("appium:platformname","Android");
        capabilities.setCapability("appium:automationName","uiautomator2");
        capabilities.setCapability("appium:platformversion","13.0");

        capabilities.setCapability("appium:appPackage","com.google.android.dialer");
        capabilities.setCapability("appium:appActivity","com.android.dialer.DialtactsActivity");

        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver = new AndroidDriver(url, capabilities);

        //Dial
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='key pad']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='8,TUV']")).click(); //8
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='3,DEF']")).click(); //3
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='0']")).click(); //0
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='9,WXYZ']")).click(); //9
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='7,PQRS']")).click(); //7
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='5,JKL']")).click(); //5
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.dialer:id/dialpad_key_number' and @text='1']")).click(); //1
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='7,PQRS']")).click(); //7
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.dialer:id/dialpad_key_number' and @text='1']")).click(); //1
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='9,WXYZ']")).click(); //9
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='dial']")).click(); //Dial

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();

    }
}
