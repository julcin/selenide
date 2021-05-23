package lt.vtmc.emiliatoriusTests;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement loginFormEmail = $("input[type='email']");
    private final SelenideElement loginFormPassword = $("input[type='password']");
    private final SelenideElement loginFormButton = $("button[type='submit']");
    private final SelenideElement loginErrorText = $(".swal-text");

    //methods
    public void openLoginPage() {
        open("http://localhost:3000");
    }

    public void clearEmail() {
        loginFormEmail.clear();
    }

    public void clearPassword() {
        loginFormPassword.clear();
    }

    public void fillEmailWithValidData() {
        clearEmail();
        loginFormEmail.sendKeys("admin@mail.com");
    }

    public void fillPasswordWithValidData() {
        clearPassword();
        loginFormPassword.sendKeys("password");
    }

    public void clickSignInButton() {
        loginFormButton.click();
    }

    //getters

    public SelenideElement getLoginErrorText() {
        return loginErrorText;
    }
}
