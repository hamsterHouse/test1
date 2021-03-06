import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baiduTest3 {
    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\tools/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void testChrome()throws Exception{
        // 浏览器访问 Baidu
        driver.get("http://www.baidu.com/");

        // 获取网页的title
        System.out.println("Home Page title is: " + driver.getTitle());

        // 通过id找到input的DOM
        WebElement element = driver.findElement(By.id("kw"));

        // 输入关键字
        element.sendKeys("test");

        // 提交 input 所在的  form
        element.submit();
        // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().endsWith("test");
            }
        });
    }
    @Test
    public void testChrome01()throws Exception{
        //通过CSS选择器 找到input的DOM
        WebElement element01 = driver.findElement(By.cssSelector("#kw"));

        //输入关键字
        element01.sendKeys("junit");

        //提交input所在的form
        element01.submit();
        Thread.sleep(1000);

        //获取网页的title
        System.out.println("Find Page title is: " + driver.getTitle());

        //通过css选择器查找"网页"的DOM
        WebElement element02 = driver.findElement(By.cssSelector(".s_tab_inner > b:nth-child(1)"));

        //判断元素内容
        String expect = element02.getText();
        String actual = "网页";
        assertEquals(expect,actual);
        Thread.sleep(1000);
    }

    @After
    public void fin(){
        // 显示搜索结果页面的 title
        System.out.println("2 Page title is: " + driver.getTitle());
        //关闭浏览器
        driver.quit();
    }
}
