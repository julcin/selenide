package lt.vtmc.emiliatoriusTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class LoginPageTest {

    LoginPage login = new LoginPage();
    NavPage navigation = new NavPage();
    ProjectsPage projects = new ProjectsPage();

    @Before
    public void setupLoginPage() {
//        Configuration.headless = true;
        login.openLoginPage();
    }

    @After
    public void signOut() {
        navigation.signOut();
    }

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
        System.out.println($(".swal-text"));
        login.getLoginErrorText().shouldHave(Condition.text("bad email or password"));
    }



}
