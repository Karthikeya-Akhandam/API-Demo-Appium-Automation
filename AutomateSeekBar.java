package Demo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class AutomateSeekBar {
    public static void main (String[] args) throws MalformedURLException {

        // Desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "AndroidEmulator");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:platformVersion", "13.0");
        capabilities.setCapability("appium:appPackage", "io.appium.android.apis");
        capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        AndroidDriver driver = new AndroidDriver(url, capabilities);

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Scroll to find the element
        String Element1 = "Views";
        WebElement list1 = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + Element1 + "\"))"
        ));
        list1.click();

        String Element2 = "Seek Bar";
        WebElement list2 = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + Element2 + "\"))"
        ));
        list2.click();

        WebElement seek_bar = driver.findElement(By.xpath("//android.widget.SeekBar[@resource-id=\"io.appium.android.apis:id/seek\"]"));
        seek_bar.sendKeys("25");

        String text1 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/progress\"]")).getText();
        System.out.println(text1);

    }
}
