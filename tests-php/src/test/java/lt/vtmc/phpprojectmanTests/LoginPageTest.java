package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPageTest {

    @Rule
    public TextReport textReport = new TextReport();

    LoginPage login = new LoginPage();
    NavigationPage navigation = new NavigationPage();

    @Before
    public void setupLoginPage() {
        Configuration.headless = true;
        navigation.openLoginPage();
    }

    @Test
    public void userCanLoginWithValidData() {
        login.fillEmailWithValidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        navigation.getPageNavName().should(Condition.matchText("Dashboard"));
        Assert.assertEquals("http://lieta.lt/dashboard", url());
        navigation.logout();
    }

    @Test
    public void validateUsernameAfterLogin() {
        login.fillEmailWithValidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        navigation.getUserName().shouldHave(Condition.text("labas"));
        navigation.logout();
    }

    @Test
    public void userCanNotLoginWithNoData() {
        login.clearEmail();
        login.clearPassword();
        login.clickSignInButton();
        login.getLoginEmailError().shouldHave(Condition.text("Please provide a valid e-mail address!"));
        login.getLoginPasswordError().shouldHave(Condition.text("Please provide a valid password!"));
        Assert.assertEquals("http://lieta.lt/login", url());
    }

    @Test
    public void userCanNotLoginWithEmptyEmail() {
        login.clearEmail();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        login.getLoginEmailError().shouldHave(Condition.text("Please provide a valid e-mail address!"));
        Assert.assertEquals("http://lieta.lt/login", url());
    }

    @Test
    public void userCanNotLoginWithEmptyPassword() {
        login.fillEmailWithValidData();
        login.clearPassword();
        login.clickSignInButton();
        login.getLoginPasswordError().shouldHave(Condition.text("Please provide a valid password!"));
        Assert.assertEquals("http://lieta.lt/login", url());
    }

    @Test
    public void userCanNotLoginWithBadPassword() {
        login.fillEmailWithValidData();
        login.fillPasswordWithInvalidData();
        login.clickSignInButton();
        login.getLoginCommonError().shouldHave(Condition.text("The username and password you entered does not match any account! Please try again"));
        Assert.assertEquals("http://lieta.lt/login", url());
    }

    @Test
    public void userCanNotLoginWithBadEmail() {
        login.fillEmailWithInvalidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        login.getLoginCommonError().shouldHave(Condition.text("The username and password you entered does not match any account! Please try again"));
        Assert.assertEquals("http://lieta.lt/login", url());
    }

    @Test
    public void userCanLogout() {
        login.fillEmailWithValidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        navigation.logout();
        navigation.getPageNavName().should(Condition.matchText("Login"));
        Assert.assertEquals("http://lieta.lt/login", url());
    }

    @Test
    public void userCanNotGoBackAfterLogout() {
        login.fillEmailWithValidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        navigation.logout();
        back();
        navigation.getPageNavName().should(Condition.matchText("Login"));
        Assert.assertEquals("http://lieta.lt/login", url());
    }
}
