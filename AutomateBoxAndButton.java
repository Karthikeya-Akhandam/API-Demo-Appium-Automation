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

public class AutomateBoxAndButton {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

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
        String MobElementToScroll = "Views";
        WebElement listItem = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + MobElementToScroll + "\"))"
        ));
        listItem.click();

        // Click on Controls
        WebElement b2 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Controls']"));
        b2.click();

        // Click on Light Theme
        WebElement b3 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Light Theme']"));
        b3.click();

        // Enter text in EditText
        WebElement t1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/edit']"));
        t1.sendKeys("Karthikeya");

        // Click on Checkbox 1
        WebElement c1 = driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc='Checkbox 1']"));
        c1.click();

        // Click on RadioButton 1
        WebElement r1 = driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc='RadioButton 1']"));
        r1.click();

        // Wait before quitting (optional)
        Thread.sleep(5000);

    }
}