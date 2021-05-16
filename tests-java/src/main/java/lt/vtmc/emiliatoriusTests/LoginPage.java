package lt.vtmc.emiliatoriusTests;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement loginFormEmail = $("input[type='email']");
    private final SelenideElement loginFormPassword = $("input[type='password']");
    private final SelenideElement loginFormButton = $("button[type='submit']");

    public void openLoginPage() {
        open("http://localhost:3000");
    }

    public void fillEmailWithValidData() {
        loginFormEmail.clear();
        loginFormEmail.sendKeys("admin@mail.com");
    }

    public void fillPasswordWithValidData() {
        loginFormPassword.clear();
        loginFormPassword.sendKeys("password");
    }

    public void clickSignInButton() {
        loginFormButton.click();
    }

}
