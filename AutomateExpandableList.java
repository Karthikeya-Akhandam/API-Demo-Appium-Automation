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

public class AutomateExpandableList {
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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Simple Adapter\"]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Group 1\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//android.widget.ExpandableListView[@resource-id=\"android:id/list\"]/android.widget.TwoLineListItem[4]")).click();


    }
}
