package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.*;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {
    private final SelenideElement registerFormUsername = $("#username");
    private final SelenideElement registerFormEmail = $("#email");
    private final SelenideElement registerFormPassword = $("#password");
    private final SelenideElement registerFormConfirmPassword = $("#confirm_password");
    private final SelenideElement registerFormButton = $("button[type='submit']");
    //The given data was invalid.
    private final SelenideElement registerCommonError = $("small[type='invalid']");
    //Please provide a valid e-mail address!
    private final SelenideElement registerEmailError = $$(".invalid-feedback").get(0);
    //Password must be have minimum 8 characters length and contain at least one uppercase letter, one lowercase letter, one number and one of ~!@#$%^&*?- characters!
    private final SelenideElement registerPasswordError = $$(".invalid-feedback").get(1);
    //Confirmation password must be the same as password above!
    private final SelenideElement registerPasswordConfirmError = $$(".invalid-feedback").get(2);
    //for background-image css property inside form
    private final String backgroundImageUrlOk = "url(\"data:image/svg+xml;charset=utf-8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3E%3C/svg%3E\")";
    private final String backgroundImageUrlError = "url(\"data:image/svg+xml;charset=utf-8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545'%3E%3Ccircle cx='6' cy='6' r='4.5'/%3E%3Cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3E%3Ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3E%3C/svg%3E\")";

    //generating random number for username and mail registration
    Random rand = new Random();
    int randomNumber = rand.nextInt(Integer.MAX_VALUE);

    //filling and clearing
    public void clearRegisterFormUsername() {
        registerFormUsername.clear();
    }

    public void fillRegisterFormUsername() {
        clearRegisterFormUsername();
        registerFormUsername.sendKeys("Username" + randomNumber);
    }

    public void clearRegisterFormEmail() {
        registerFormEmail.clear();
    }

    public void fillRegisterFormEmailValid() {
        clearRegisterFormEmail();
        registerFormEmail.sendKeys("email@" + randomNumber + ".lt");
    }

    public void fillRegisterFormEmailInvalid() {
        clearRegisterFormEmail();
        registerFormEmail.sendKeys("email" + randomNumber + ".lt");
    }

    public void clearRegisterFormPassword() {
        registerFormPassword.clear();
    }

    public void fillRegisterFormPassword() {
        clearRegisterFormPassword();
        registerFormPassword.sendKeys("Password-1");
    }

    public void clearRegisterFormConfirmPassword() {
        registerFormConfirmPassword.clear();
    }

    public void fillRegisterFormConfirmPasswordValid() {
        clearRegisterFormConfirmPassword();
        registerFormConfirmPassword.sendKeys("Password-1");
    }

    public void fillRegisterFormConfirmPasswordInvalid() {
        registerFormConfirmPassword.sendKeys("Password");
    }

    //clicks
    public void clickRegisterFormButton() {
        registerFormButton.click();
    }

    //getters


    public SelenideElement getRegisterFormUsername() {
        return registerFormUsername;
    }

    public SelenideElement getRegisterCommonError() {
        return registerCommonError;
    }

    public SelenideElement getRegisterEmailError() {
        return registerEmailError;
    }

    public SelenideElement getRegisterPasswordError() {
        return registerPasswordError;
    }

    public SelenideElement getRegisterPasswordConfirmError() {
        return registerPasswordConfirmError;
    }

    public String getBackgroundImageUrlOk() {
        return backgroundImageUrlOk;
    }

    public String getBackgroundImageUrlError() {
        return backgroundImageUrlError;
    }
}
