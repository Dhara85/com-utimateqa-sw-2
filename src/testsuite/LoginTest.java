package testsuite;
/**
 * 1. userShouldNavigateToLoginPageSuccessfully * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email or password.’
 * Selenium
 */

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Find the SignIn link and click on SignIn link
    driver.findElement(By.xpath("//a[@href=\"/users/sign_in\"='Sign In']")).click();
    String expectedMessage = "Welcome Back!";
        // Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualMessage = actualTextElement.getText();
        //Verify expected and actual Text
        Assert.assertEquals(expectedMessage, actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        //Find the SignIn link and click on SignIn link
        driver.findElement(By.xpath("//a[@href=\"/users/sign_in\"='Sign In']")).click();
        //Enter invalid username in text field
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("random123@hotmail.com");
        //Enter invalid password in text field
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("tester456");
        //Click on Login Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Click on Captcha verify button to verify
        //driver.findElement(By.xpath("//button[@id='recaptcha-verify-button']")).click();
        String expectedErrorMessage = "Invalid email or password";
        //Find the errorMessage element and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='notice']")).getText();
        Assert.assertEquals("Invalid email or password","Invalid email or password");
    }
    @After
    public void tearDown() {
        closeBrowser();

    }

}
