package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectsCreateTest {

    LoginPage login = new LoginPage();
    NavigationPage navigation = new NavigationPage();
    ProjectCardPage projectCards = new ProjectCardPage();
    ProjectPage projectPage = new ProjectPage();
    ProjectCreatePage projectCreate = new ProjectCreatePage();
    ProjectTaskPage projectTask = new ProjectTaskPage();

    @Before
    public void setupProjectsPage() {
//        Configuration.headless = true;
//        Configuration.clickViaJs = true;
        navigation.openLoginPage();
        login.fillEmailWithValidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        navigation.getUserName().shouldHave(Condition.text("labas"));
        navigation.openProjectsLink();
    }

    @After
    public void logoutIfLogged() {
        if(navigation.getUserName().has(Condition.text("labas"))) {
            navigation.logout();
        }
    }

    @Test
    public void userCanCreateProject() {
        projectPage.clickCreateProjectButton();
        projectCreate.fillProjectNameWithValidData();
        projectCreate.fillProjectDescriptionWithValidData();
        projectCreate.clickCreateProjectButton();
        projectCreate.getSuccessAlert().shouldHave(Condition.text("Project created succesfully"));
        projectCreate.clickGoToProjectButton();
        projectTask.getProjectName().shouldHave(Condition.text("" + projectCreate.randomNumber));
    }

    @Test
    public void userCanNotCreateProjectWithoutName() {
        navigation.clickProjectsLink();
        projectPage.clickCreateProjectButton();
        projectCreate.clearProjectName();
        projectCreate.fillProjectDescriptionWithValidData();
        projectCreate.clickCreateProjectButton();
        projectCreate.getNameError().shouldBe(Condition.visible);
    }

    @Test
    public void userCanNotCreateProjectWithoutDescription() {
        navigation.clickProjectsLink();
        projectPage.clickCreateProjectButton();
        projectCreate.fillProjectNameWithValidData();
        projectCreate.clearProjectDescription();
        projectCreate.clickCreateProjectButton();
        projectCreate.getCreateProjectDescription().shouldBe(Condition.visible);
    }

    @Test
    public void userCanNotCreateProjectWithoutNameAndDescription() {
        navigation.clickProjectsLink();
        projectPage.clickCreateProjectButton();
        projectCreate.clearProjectName();
        projectCreate.clearProjectDescription();
        projectCreate.clickCreateProjectButton();
        projectCreate.getNameError().shouldBe(Condition.visible);
        projectCreate.getCreateProjectDescription().shouldBe(Condition.visible);
    }

    @Test
    public void userCanNotCreateProjectWithSameName() {
        userCanCreateProject();
        navigation.clickProjectsLink();
        projectPage.clickCreateProjectButton();
        projectCreate.fillProjectNameWithValidData();
        projectCreate.fillProjectDescriptionWithValidData();
        projectCreate.clickCreateProjectButton();
        projectCreate.getNameTakenError().shouldBe(Condition.visible);
    }

    @Test
    public void userCanNotCreateLongNameProject() {
        navigation.clickProjectsLink();
        projectPage.clickCreateProjectButton();
        projectCreate.fillProjectNameWithLongValue();
        projectCreate.fillProjectDescriptionWithValidData();
        projectCreate.clickCreateProjectButton();
        projectCreate.getNameTooLongError().shouldBe(Condition.visible);
    }

}
