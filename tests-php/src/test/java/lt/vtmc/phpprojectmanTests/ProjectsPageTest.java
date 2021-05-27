package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import com.codeborne.selenide.*;

public class ProjectsPageTest {

    @Rule
    public TextReport textReport = new TextReport();

    LoginPage login = new LoginPage();
    NavigationPage navigation = new NavigationPage();
    ProjectCardPage projectCards = new ProjectCardPage();
    ProjectPage projectPage = new ProjectPage();

    @Before
    public void setupProjectsPage() {
        Configuration.headless = true;
        navigation.openLoginPage();
        login.fillEmailWithValidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        navigation.getUserName().shouldHave(Condition.text("labas"));
        navigation.openProjectsLink();
    }

    @After
    public void logoutIfLogged() {
        if (navigation.getUserName().has(Condition.text("labas"))) {
            navigation.logout();
        }
    }

    @Test
    public void checkIfProjectNamesExist() {

        //targets only visible elements, so if more that 0, then should be ok
        projectCards.getProjectCardNames().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    public void checkIfProjectDescriptionExist() {
        //check if no project card is expanded and expand first if true
        //this is temporary solution, needs fixing
        while (!projectCards.getProjectCardExpanded().isDisplayed()) {
            projectCards.clickFirstProject();
        }
        //first expanded card should have visible description
        projectCards.getProjectCardDescriptions().get(0).shouldBe(Condition.visible);
    }

    @Test
    public void checkIfStateIsVisible() {
        int i = 0;
        projectCards.getProjectCardStates().get(0).shouldBe(Condition.visible);
        while (projectCards.getProjectCardStates().get(i).exists()) {
            //state can be "In Progress" or "Done"
            projectCards.getProjectCardStates().get(i).shouldHave(Condition.or("StateIsOk", (Condition.text("In Progress")), (Condition.text("Done"))));
            i++;
        }
    }

    @Test
    public void checkIfAssignedTasksVisible() {
        int i = 0;
        projectCards.getProjectCardTasksAssigned().get(0).shouldBe(Condition.visible);
        while (projectCards.getProjectCardTasksAssigned().get(i).exists()) {
            //state can be "In Progress" or "Done"
            projectCards.getProjectCardTasksAssigned().get(i).shouldBe(Condition.visible);
            i++;
        }
    }

    @Test
    public void checkIfUnfinishedTasksVisible() {
        int i = 0;
        projectCards.getProjectCardSTasksLeft().get(0).shouldBe(Condition.visible);
        while (projectCards.getProjectCardSTasksLeft().get(i).exists()) {
            //state can be "In Progress" or "Done"
            projectCards.getProjectCardSTasksLeft().get(i).shouldBe(Condition.visible);
            i++;
        }
    }

    @Test
    public void checkIfProjectListExists() {
        //targets only visible elements, so if more that 0, then should be ok
        projectPage.getProjectCardContainer().shouldBe(Condition.visible);
    }

    @Test
    public void checkIfUserCanNotSeeProjectsAfterLogout() {
        navigation.logout();
        navigation.getUserName().shouldNot(Condition.exist);
        navigation.openProjectsLink();
        projectPage.getProjectCardContainer().shouldNotBe(Condition.visible);
    }

}
