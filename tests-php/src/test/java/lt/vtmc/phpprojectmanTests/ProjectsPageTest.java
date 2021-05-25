package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPageTest {

    LoginPage login = new LoginPage();
    NavigationPage navigation = new NavigationPage();
    ProjectCardPage projectCards = new ProjectCardPage();
    ProjectPage projectPage = new ProjectPage();

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
    public void checkIfProjectNamesExist() {

        //targets only visible elements, so if more that 0, then should be ok
        projectCards.getProjectCardNames().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    public void checkIfProjectDescriptionExist() {
        //check if no project card is expanded and expand first if true
        //this is temporary solution, needs fixing
        while(!projectCards.getProjectCardExpanded().isDisplayed()) {
            projectCards.clickFirstProject();
        }

        //first expanded card should have visible description
        projectCards.getProjectCardDescriptions().get(0).shouldBe(Condition.visible);
    }

    //need age updates
//    @Test
//    public void checkIfStateIsVisible() {
//        navigation.clickProjectsButton();
//        System.out.println();
//    }

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
