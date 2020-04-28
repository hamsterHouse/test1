import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testDemo {
    WebDriver driver;
    testfireLogin objLogin;
    testfireHomePage objHomePage;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "D:\\tools/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://testfire.net/bank/main.jsp");
    }

    @Test
    public void test_Home_Page_Appear_Correct(){
        objLogin = new testfireLogin(driver);
        objLogin.logintestfire("admin", "admin");
        objHomePage = new testfireHomePage(driver);
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().contains("Congratulations!"));
    }
}