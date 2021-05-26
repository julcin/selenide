package lt.vtmc.emiliatoriusTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPageTest {

    LoginPage login = new LoginPage();
    NavPage navigation = new NavPage();
    ProjectsPage projects = new ProjectsPage();

    @Before
    public void setupLoginPage() {
//        Configuration.headless = true;
        login.openLoginPage();
    }


//    @Before
//    public void setupProjectsPage() {
////        Configuration.headless = true;
////        Configuration.clickViaJs = true;
//        navigation.openLoginPage();
//        login.fillEmailWithValidData();
//        login.fillPasswordWithValidData();
//        login.clickSignInButton();
//        navigation.getUserName().shouldHave(Condition.text("labas"));
//        navigation.openProjectsLink();
//    }
//
//    @After
//    public void logoutIfLogged() {
//        if(navigation.getUserName().has(Condition.text("labas"))) {
//            navigation.logout();
//        }
//    }

    @Test
    public void userCanLoginWithValidData() {
        login.fillEmailWithValidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        navigation.getPageNavName().should(Condition.matchText("Emiliatorius'3"));
    }

    //does not work, element is not displayed, but if i click manually it is displayed
    @Test
    public void validateUsernameAfterLogin() {
        userCanLoginWithValidData();
        navigation.clickNavButton();
        navigation.getUserName().shouldHave(Condition.text("admin@mail.com"));
    }

    @Test
    public void userCanNotLoginWithNoData() {
        login.clearEmail();
        login.clearPassword();
        login.clickSignInButton();
        login.getLoginErrorText().shouldHave(Condition.text("Bad email or password!"));
    }

    @Test
    public void userCanNotLoginWithNoName() {
        login.clearEmail();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        login.getLoginErrorText().shouldHave(Condition.text("Bad email or password!"));
    }

    @Test
    public void userCanNotLoginWithNoPassword() {
        login.fillEmailWithValidData();
        login.clearPassword();
        login.clickSignInButton();
        login.getLoginErrorText().shouldHave(Condition.text("Bad email or password!"));
    }

    @Test
    public void userCanNotLoginWithBadPassword() {
        login.fillEmailWithValidData();
        login.fillPasswordWithInvalidData();
        login.clickSignInButton();
        login.getLoginErrorText().shouldHave(Condition.text("Bad email or password!"));
    }

    @Test
    public void userCanNotLoginWithBadName() {
        login.fillEmailWithInvalidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        login.getLoginErrorText().shouldHave(Condition.text("Bad email or password!"));
    }

    @Test
    public void userCanLogout() {
        userCanLoginWithValidData();
        navigation.clickNavButton();
        navigation.clickLogoutButton();
        Assert.assertEquals("http://localhost:3000/", url());
        navigation.getNavButton().shouldNot(Condition.exist);
    }

    @Test
    public void userCanNotGoBackAfterLogout() {
        userCanLogout();
        back();
        navigation.getNavButton().shouldNot(Condition.exist);
        navigation.getPageNavName().shouldNot(Condition.exist);
    }
}
