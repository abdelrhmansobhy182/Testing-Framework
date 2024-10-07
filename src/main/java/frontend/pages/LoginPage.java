package frontend.pages;

import frontend.utilities.ElementUtilities;
import org.openqa.selenium.By;

public class LoginPage {
    private String pageURL = "https://staging2.tagaddod.com/admin/login";
    private By signInButton = By.xpath("//div[@class=\"nsm7Bb-HzV7m-LgbsSe-MJoBVe\"]");
    private By emailInput = By.xpath("//input[@type=\"email\"]");
    private By passwordInput = By.xpath("//input[@type=\"password\"]");
    private By nextButton = By.xpath("//span[contains(text(),'Next')]");
    private By signInFrame = By.xpath("//iframe[starts-with(@id, 'gsi_')]");
    private By skipButton = By.xpath("//a[contains(text(),'Do this later')]");

    public void navigateTOLoginPage(){
        ElementUtilities.navigateToURL(pageURL);
    }
    public void clickOnSignInButton(){
        ElementUtilities.switchToFrame(signInFrame);
        ElementUtilities.clickElementWithJavaScript(signInButton);
    }

    public void enterEmailOrPhone(String input) {
        ElementUtilities.fillElement(emailInput,input);
    }

    public void enterPassword(String password) {
        ElementUtilities.fillElement(passwordInput,password);
    }

    public void clickOnNextButton(){
        ElementUtilities.clickElement(nextButton);
    }

    public void clickOnSkipButton(){
        ElementUtilities.clickElement(skipButton);
    }


}
