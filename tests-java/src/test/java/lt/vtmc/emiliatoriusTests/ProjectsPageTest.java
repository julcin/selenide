package lt.vtmc.emiliatoriusTests;

import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ProjectsPageTest {

    LoginPage login = new LoginPage();
    NavPage navigation = new NavPage();
    ProjectsPage projects = new ProjectsPage();

    @Before
    public void setupLoginPage() {
        //Configuration.headless = true;
        login.openLoginPage();
        login.fillEmailWithValidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
    }

    @Test
    public void checkIfProjectCardsVisible() {
        int i = 0;
        projects.getProjectCards().get(i).shouldBe(Condition.visible);
        while(projects.getProjectCards().get(i).exists()) {
            projects.getProjectCards().get(i).shouldBe(Condition.visible);
            i++;
        }
    }

    //not finished
//    @Test
//    public void userCanCreateProject() {
//        projects.clickCreateProject();
//        projects.fillCreateProjectName();
//        projects.fillCreateProjectDescription();
//        projects.clickCreateProjectLastStepButton();
//    }

}
