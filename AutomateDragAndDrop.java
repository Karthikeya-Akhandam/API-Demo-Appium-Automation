package Demo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class AutomateDragAndDrop {
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
        String MobElementToScroll = "Views";
        WebElement listItem = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + MobElementToScroll + "\"))"
        ));
        listItem.click();

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
        WebElement source = driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));
        WebElement destination = driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]"));
        TouchAction action = new TouchAction(driver);
        action.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();

    }
}
