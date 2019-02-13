import common.generalmail2;




        public class forgotPassword extends generalmail2{

            ArrayList<String> pathlist=new ArrayList<String>();
            String btn = "";
            String path= "";
            generalmail2  generalMail = new generalmail2();



            @Test
            public void Regestration_test() throws Exception {
                Thread.sleep(2000);
                logger = report.startTest("ForgotPassword");
                getDriver().findElement(By.id("forgotpassword")).click();
                getLogger().log(LogStatus.PASS ,"got the forgot password id");
                getLogger().log(LogStatus.INFO , "forgotpassword page is open");
                validationTest("Sheet3");

            }

            public void validationTest(String sheet) throws Exception {

                Selenium_read obj = new Selenium_read();
                ArrayList<ArrayList> tablelist=obj.readExcel(sheet);
                System.out.println(tablelist);
                for (ArrayList<String> row : tablelist){
                    Forgotpassword_method(row.get(0),row.get(1));
                }

                Forgotpassword_method1();
                Forgotpassword_method2();       
            }

            public void Forgotpassword_method(String email, String snapshot)throws Exception {


                WebElement email_id= getDriver().findElement(By.xpath(".//*[@id='forgotPasswordForm']/div[1]/div/input"));
                email_id.clear();
                String myWindowHandle = getDriver().getWindowHandle();
                getDriver().switchTo().window(myWindowHandle);
                WebElement email_id1= getDriver().findElement(By.xpath(".//*[@id='forgotPasswordForm']/div[1]/div/input"));
                email_id1.sendKeys(email);
                getDriver().findElement(By.xpath(".//*[@id='forgotPasswordForm']/div[2]/div/button[2]")).click();

            }

            public void Forgotpassword_method1()throws Exception {

                getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                getDriver().manage().window().maximize();
                getDriver().get("https://mail.google.com/");
                getDriver().findElement(By.id("identifierId")).sendKeys("kunal@pedagogy.study");
                getDriver().findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
                Thread.sleep(4000);
                getDriver().findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("pedagogy@123");
                Thread.sleep(4000);
                getDriver().findElement(By.id("passwordNext")).click();
                Thread.sleep(4000);
                getLogger().log(LogStatus.INFO , "successfully open email");
                List<WebElement> email = getDriver().findElements(By.cssSelector("div.xT>div.y6>span>b"));
                for(WebElement emailsub : email){
                if(emailsub.getText().equals("Pedagogy : Password Reset") == true){

                       emailsub.click();
                       break;
                    }
                }
                Thread.sleep(4000);
                String mytext = getDriver().findElement(By.partialLinkText("http://52.89.55.95:3000/changepassword?email=kunal@pedagogy.study&token=")).getText();
                getDriver().get(mytext);
            }

            public void Forgotpassword_method2()throws Exception {

                getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                getDriver().findElement(By.xpath(".//*[@id='password']")).sendKeys("Pedagogy@123");
                getDriver().findElement(By.xpath(".//*[@id='confirmPassword']")).sendKeys("Pedagogy@123");
                getDriver().findElement(By.xpath("html/body/app-root/app-changepassword/div/div/div[2]/form/div[3]/button")).click();
                getLogger().log(LogStatus.INFO , "Successfully change the password");


            }


            public void switchToTab() { 
                getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
                getDriver().switchTo().defaultContent(); 
            }



            public void setButton(String str){
                btn=str;
            }


            public void setPath(String str){
                path=str;
            }

        }



    package Pedagogy;


    import java.io.File;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.concurrent.TimeUnit;
    import org.apache.commons.io.FileUtils;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.OutputType;
    import org.openqa.selenium.TakesScreenshot;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.Select;
    import org.testng.annotations.Test;
    import common.generalmail2;




    public class Registration extends generalmail2 {

            ArrayList<String> pathlist=new ArrayList<String>();
            String btn = "";
            String path= "";
            generalmail2  generalMail = new generalmail2();



        @Test
        public void Regestration_test() throws Exception {
            logger = report.startTest("SignUp");
            getDriver().findElement(By.xpath(".//*[@id='wrapper']/div/div/div/a")).click();
            validationTest("Sheet1");

            }


        public void regNull() {
                getDriver().findElement(By.id("firstname")).clear();
                getDriver().findElement(By.id("lastname")).clear();
                getDriver().findElement(By.xpath("html/body/app-root/app-register/div/div/div/div[2]/form/div[3]/ng2-datepicker/div/div/input")).clear();
                getDriver().findElement(By.name("radio1")).isSelected();
                Select dropdown = new Select(getDriver().findElement(By.id("countrycode")));dropdown.selectByVisibleText("India");
                getDriver().findElement(By.id("contact")).clear();
                getDriver().findElement(By.id("email")).clear();
                getDriver().findElement(By.id("agree")).click();
                getDriver().findElement(By.id("submitBtn")).click();

            }   

            public void validationTest(String sheet) throws Exception{
                // Null Validations
                regNull();

                Selenium_read obj = new Selenium_read();
                ArrayList<ArrayList> tablelist=obj.readExcel(sheet);
                System.out.println(tablelist);
                for (ArrayList<String> row : tablelist){
                    regMethod(row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5));
                }

                registration_method();
                Createpassword_method();
            }


            public void regMethod(String firstName ,String lastName ,String dob, String contact,String email , String snapshot ) throws Exception {
                regNull();
                Thread.sleep(4000);
                getDriver().findElement(By.id("firstname")).sendKeys(firstName);
                getDriver().findElement(By.id("lastname")).sendKeys(lastName);
                getDriver().findElement(By.xpath("html/body/app-root/app-register/div/div/div/div[2]/form/div[3]/ng2-datepicker/div/div/input")).sendKeys(dob);
                getDriver().findElement(By.id("one")).isEnabled();
                getDriver().findElement(By.id("contact")).sendKeys(contact);
                getDriver().findElement(By.id("email")).sendKeys(email);
                getDriver().findElement(By.id("agree")).click();
                getDriver().findElement(By.id("submitBtn")).click();
                snapshot(snapshot);
                regNull();
            }
            public void registration_method()throws Exception {

                getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
                getDriver().manage().window().maximize();
                getDriver().get("https://mail.google.com/");
                getDriver().findElement(By.id("identifierId")).sendKeys("kunal@pedagogy.study");
                getDriver().findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
                Thread.sleep(4000);
                getDriver().findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("pedagogy@123");

                Thread.sleep(4000);
                getDriver().findElement(By.id("passwordNext")).click();

                Thread.sleep(4000);
                List<WebElement> email = getDriver().findElements(By.cssSelector("div.xT>div.y6>span>b"));

                for(WebElement emailsub : email){
                    if(emailsub.getText().equals("Pedagogy : Password Reset") == true){

                           emailsub.click();
                           break;
                        }
                }

                Thread.sleep(4000);

                String mytext = getDriver().findElement(By.partialLinkText("http://52.89.55.95:3000/changepassword?email")).getText();
                 getDriver().get(mytext);
                }


            public void Createpassword_method()throws Exception {
                getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                getDriver().findElement(By.xpath(".//*[@id='password']")).sendKeys("Pedagogy@123");
                getDriver().findElement(By.xpath(".//*[@id='confirmPassword']")).sendKeys("Pedagogy@123");
                getDriver().findElement(By.xpath("html/body/app-root/app-changepassword/div/div/div[2]/form/div[3]/button")).click();


            }


            public void setButton(String str){
                btn=str;
            }

            public void setPath(String str){
                path=str;
            }

            public void snapshot(String name) throws IOException {
                File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("D:\\PEDAGOGY SELENIUM PROJECT\\selenium\\screenshot signup\\"+path+name));
                pathlist.add("D:\\PEDAGOGY SELENIUM PROJECT\\selenium\\screenshot\\"+path+name);


        }
        }





<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">

   <test name="Test2">
    <classes>
     <class name="Pedagogy.login"/>
      <class name="Pedagogy.forgotPassword"/>
      <class name="Pedagogy.Registration"/>
    </classes>


   </test>



</suite> 


package common;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class generalmail2 {

    public ExtentReports report=new ExtentReports("D:\\KETAN\\ProjectReport.html");;
    public static ExtentTest logger;



    public ExtentTest getLogger() {
        return logger;
    }


    public void setLogger(ExtentTest logger) {
        this.logger = logger;
    }


    WebDriver driver ;
    public WebDriver getDriver() {
        return driver;
    }


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    @BeforeSuite
    public void OpenBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "D://KETAN//selenium//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger = report.startTest("Pedagogy");
        driver.get("http://52.89.55.95:3000/");
        logger.log(LogStatus.INFO , "Appliacation is up and running");


    }


    public ExtentReports getReport() {
        return report;
    }


    public void setReport(ExtentReports report) {
        this.report = report;
    }


    @AfterMethod
    public void tearDown(ITestResult result) 
    {
        if (result.getStatus()==ITestResult.FAILURE)
        {
        String screenshotpath = generalScreenshot.captureScreenshot(driver, result.getName());
        String image = logger.addScreenCapture(screenshotpath);
        logger.log(LogStatus.FAIL , "failed", image);   
        }

        report.endTest(logger);
        report.flush();


    }


    @AfterSuite
    public void openReport(){
        driver.get("D:\\KETAN\\ProjectReport.html");

    }

}