package parallel;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;

public class GeneralHook {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

   @Before(order = 1)
   public void  launchBrowser(){
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
   }

   @After(order = 0)
    public void quitBrowser(){
        driver.quit();
   }

   @After(order = 1)
    public void tearDown(Scenario sc){
        if(sc.isFailed()){
            //take screenshot:
            String screenshotName = sc.getName().replaceAll(" ","_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcePath, "image/png", screenshotName);
        }
   }

}
