package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement loginFormEmail = $("#email");
    private final SelenideElement loginFormPassword = $("#password");
    private final SelenideElement loginFormButton = $("button[type='submit']");
    private final SelenideElement loginEmailError = $$(".invalid-feedback").get(0);
    private final SelenideElement loginPasswordError = $$(".invalid-feedback").get(1);
    private final SelenideElement loginCommonError = $("small[type='invalid']");

    //filling and clearing
    public void clearEmail() {
        loginFormEmail.clear();
    }

    public void clearPassword() {
        loginFormPassword.clear();
    }

    public void fillEmailWithValidData() {
        clearEmail();
        loginFormEmail.sendKeys("labas@labas.lt");
    }

    public void fillEmailWithInvalidData() {
        clearEmail();
        loginFormEmail.sendKeys("labas@labas");
    }

    public void fillPasswordWithValidData() {
        clearPassword();
        loginFormPassword.sendKeys("Password-1");
    }

    public void fillPasswordWithInvalidData() {
        clearPassword();
        loginFormPassword.sendKeys("Password");
    }

    //clicks
    public void clickSignInButton() {
        loginFormButton.click();
    }

    //getters
    public SelenideElement getLoginEmailError() { return loginEmailError; }

    public SelenideElement getLoginPasswordError() { return loginPasswordError; }

    public SelenideElement getLoginCommonError() { return loginCommonError; }
}
