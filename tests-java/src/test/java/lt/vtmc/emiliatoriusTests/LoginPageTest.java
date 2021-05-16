package lt.vtmc.emiliatoriusTests;

import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest {

    LoginPage loginPage = new LoginPage();
    ProjectsPage projectPage = new ProjectsPage();

    @Before
    public void setupLoginPage() {
//        Configuration.headless = true;
        loginPage.openLoginPage();
    }

    @Test
    public void userCanLoginWithValidData() {
        loginPage.fillEmailWithValidData();
        loginPage.fillPasswordWithValidData();
        loginPage.clickSignInButton();
        projectPage.getMainPageNavName().should(Condition.matchText("Emiliatorius'3"));
        //...something wrong with selenide, i will check later and continue to write tests
    }

}
