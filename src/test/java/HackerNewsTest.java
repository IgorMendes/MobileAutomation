import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HackerNewsTest {

    private AndroidDriver driver;
    private String msgResultadoLogin;
    private String msgDeErro = "Arrr…wrong username/password";
    private String msgLoginVazio = "Catch you, anonymous!";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "MotoGPlay");
        desiredCapabilities.setCapability("appPackage", "com.leavjenn.hews");
        desiredCapabilities.setCapability("appActivity", "com.leavjenn.hews.ui.MainActivity");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void testLoginUsuarioInvalido() throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Navegar para cima");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView[4]");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.leavjenn.hews:id/et_user_name");
        el4.click();
        el4.sendKeys("username");
        MobileElement el5 = (MobileElement) driver.findElementById("com.leavjenn.hews:id/et_password");
        el5.click();
        el5.sendKeys("132465");
        MobileElement loginButton = (MobileElement) driver.findElementById("android:id/button1");
        loginButton.click();
        //Aguarda tempo de login
        TimeUnit.SECONDS.sleep(5);
        MobileElement el7 = (MobileElement) driver.findElementById("com.leavjenn.hews:id/tv_prompt");
        this.msgResultadoLogin = el7.getText();
        assertEquals(msgDeErro, msgResultadoLogin);

    }
    @Test
    public void testLoginUsuarioVazio() throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Navegar para cima");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView[4]");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]");
        el3.click();
        MobileElement loginButton = (MobileElement) driver.findElementById("android:id/button1");
        loginButton.click();
        //Aguarda tempo de login
        TimeUnit.SECONDS.sleep(5);
        MobileElement el7 = (MobileElement) driver.findElementById("com.leavjenn.hews:id/tv_prompt");
        this.msgResultadoLogin = el7.getText();
        assertEquals(msgLoginVazio, msgResultadoLogin);

    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}