package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject
{
    private static final String
            LOGIN_BUTTON="xpath://body/div/a[text()='Log in']",
            LOGIN_INPUT="css:#wpName1[name='wpName']",
            PASSWORD_INPUT="css:#wpPassword1[name='wpPassword']",
            SUBMIT_BUTTON="css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver){
        super(driver);
    }

    public void clickAuthButton()
    {
        this.waitForElementPresent(LOGIN_BUTTON,"Cannot find auth button",15);
        this.waitForElementAndClick(LOGIN_BUTTON,"Cannot find and click auth button",15);
    }

    public void enterLoginData(String login, String password)
    {
        this.waitForElementAndSendKeys(LOGIN_INPUT,login,"Cannot find and put login to the login input",15);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password,"Cannot find and put login to the login input",15);
    }

    public void submitForm()
    {
        this.waitForElementAndClick(SUBMIT_BUTTON,"Cannot find and click submit auth button",15);
    }
}
