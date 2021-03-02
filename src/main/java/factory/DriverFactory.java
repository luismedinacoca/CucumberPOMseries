package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadlocal driver on the basics of given browser
     * @param browser
     * @return
     */
    public WebDriver init_driver(String browser){
        System.out.println("browser value is: " + browser);
        if(browser.contentEquals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        } else if(browser.equals("opera")){
            WebDriverManager.operadriver().setup();
            tlDriver.set(new OperaDriver());
        } else {
            System.out.println("Please pass the correct borwser value " + browser);
        }
        getDriver().manage().deleteAllCookies();
        //getDriver().manage().window().maximize();

        return getDriver();
    }

    /**
     * This is used to get the driver with ThreadLocal
     * @return
     */
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
