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

public class CalculadoraTest {

    private AndroidDriver driver;
    private int resultado;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "MotoGPlay");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void verificaSoma2Mais6Test() throws InterruptedException {
        /* Espera o app carregar*/
        TimeUnit.SECONDS.sleep(5);
        MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("mais");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_6");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("igual");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");

        this.resultado = Integer.parseInt(el5.getText());
        assertEquals(8, resultado);
    }
    @Test
    public void verificaSubtrai9Menos5Test() throws InterruptedException {
        /* Espera o app carregar*/
        TimeUnit.SECONDS.sleep(5);
        MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("menos");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_5");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("igual");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");

        this.resultado = Integer.parseInt(el5.getText());
        assertEquals(4, resultado);
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
