package test_cases.frontend.login;

import frontend.pages.LoginPage;
import test_cases.BaseTest;
import frontend.utilities.ElementUtilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void initializeData(){
        setupData();
    }
    @Test
    public void testLoginWithValidData() throws InterruptedException {
        loginPage.navigateTOLoginPage();
        String originalWindow = ElementUtilities.getOriginalWindow();
        loginPage.clickOnSignInButton();
        ElementUtilities.switchWindow(originalWindow);
        loginPage.enterEmailOrPhone("abdelrahman.sobhy@tagaddod.com");
        loginPage.clickOnNextButton();
        Thread.sleep(2000);
        loginPage.enterPassword("Abdosobhy2000");
        loginPage.clickOnNextButton();
        loginPage.clickOnSkipButton();
        Thread.sleep(5000);
    }

    private void setupData(){
        loginPage = new LoginPage();
    }
}
