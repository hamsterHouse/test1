import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testfireLogin {

    WebDriver driver;
    @FindBy(name="uid")
    WebElement usertestfireName;

    @FindBy(name="passw")
    WebElement passwordtestfire;

    @FindBy(className="barone")
    WebElement titleText;

    @FindBy(name="btnSubmit")
    WebElement login;

    public testfireLogin(WebDriver driver){
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }
    //Set user name in textbox
    public void setUserName(String strUserName){
        usertestfireName.sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
        passwordtestfire.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
        login.click();
    }

    //Get the title of Login Page
    public String getLoginTitle(){
        return	titleText.getText();
    }

    public void logintestfire(String strUserName,String strPassword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPassword);
        //Click Login button
        this.clickLogin();
    }
}