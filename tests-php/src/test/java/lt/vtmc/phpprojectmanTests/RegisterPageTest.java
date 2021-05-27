package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

public class RegisterPageTest {

    @Rule
    public TextReport textReport = new TextReport();

    NavigationPage navigation = new NavigationPage();
    RegisterPage registration = new RegisterPage();

    @Before
    public void setupRegisterPage() {
        Configuration.headless = true;
        navigation.openRegisterPage();
    }

    @Test
    public void userCanRegisterWithValidData() {
        registration.fillRegisterFormUsername();
        registration.fillRegisterFormEmailValid();
        registration.fillRegisterFormPassword();
        registration.fillRegisterFormConfirmPasswordValid();
        registration.clickRegisterFormButton();
        navigation.getPageNavName().should(Condition.matchText("Dashboard"));
        Assert.assertEquals("http://lieta.lt/dashboard", url());
        navigation.logout();
    }

    @Test
    public void userCanNotRegisterWithInvalidConfirmPass() {
        registration.fillRegisterFormUsername();
        registration.fillRegisterFormEmailValid();
        registration.fillRegisterFormPassword();
        registration.fillRegisterFormConfirmPasswordInvalid();
        registration.clickRegisterFormButton();
        registration.getRegisterPasswordConfirmError().shouldHave(Condition.text("Confirmation password must be the same as password above!"));
    }

    @Test
    public void userCanNotRegisterWithInvalidEmail() {
        registration.fillRegisterFormUsername();
        registration.fillRegisterFormEmailInvalid();
        registration.fillRegisterFormPassword();
        registration.fillRegisterFormConfirmPasswordValid();
        registration.clickRegisterFormButton();
        registration.getRegisterEmailError().shouldHave(Condition.text("Please provide a valid e-mail address!"));
    }

    @Test
    public void userCanNotRegisterWithNoUsername() {
        registration.clearRegisterFormUsername();
        registration.fillRegisterFormEmailValid();
        registration.fillRegisterFormPassword();
        registration.fillRegisterFormConfirmPasswordValid();
        registration.clickRegisterFormButton();
        registration.getRegisterFormUsername().shouldHave(Condition.cssValue("background-image", registration.getBackgroundImageUrlError()));
    }

    @Test
    public void userCanNotRegisterWithNoEmail() {
        registration.fillRegisterFormUsername();
        registration.clearRegisterFormEmail();
        registration.fillRegisterFormPassword();
        registration.fillRegisterFormConfirmPasswordValid();
        registration.clickRegisterFormButton();
        registration.getRegisterEmailError().shouldHave(Condition.text("Please provide a valid e-mail address!"));
    }

    @Test
    public void userCanNotRegisterWithNoPassword() {
        registration.fillRegisterFormUsername();
        registration.fillRegisterFormEmailValid();
        registration.clearRegisterFormPassword();
        registration.clearRegisterFormConfirmPassword();
        registration.clickRegisterFormButton();
        registration.getRegisterPasswordError().shouldHave(Condition.text("Password must be have minimum 8 characters length and contain at least one uppercase letter, one lowercase letter, one number and one of ~!@#$%^&*?- characters!"));
        registration.getRegisterPasswordConfirmError().shouldHave(Condition.text("Confirmation password must be the same as password above!"));
    }

}
