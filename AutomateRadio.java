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

public class AutomateRadio {
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

        String Element2 = "Radio Group";
        WebElement list2 = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + Element2 + "\"))"
        ));
        list2.click();

        WebElement radio1 = driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"Lunch\"]"));
        radio1.click();

        String result = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"You have selected: (none)\"]")).getText();
        if (result.equals("You have selected: 2131296728")) {
            System.out.println("Snacks");
        }else if (result.equals("You have selected: 2131296319")) {
            System.out.println("Breakfast");
        }else if (result.equals("You have selected: 2131296544")) {
            System.out.println("Lunch");
        }else if (result.equals("You have selected: 2131296401")) {
            System.out.println("Dinner");
        }else if (result.equals("You have selected: 2131296294")) {
            System.out.println("All of Them");
        }else {
            System.out.println("None");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement button1 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Clear\"]"));
        button1.click();

        System.out.println("Cleared");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String result1 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"You have selected: (none)\"]")).getText();
        if (result1.equals("You have selected: (none)")) {
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

    }
}