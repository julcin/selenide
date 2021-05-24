package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.lang.reflect.Array;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ProjectsPageTest {

    LoginPage login = new LoginPage();
    NavigationPage navigation = new NavigationPage();
    ProjectCardPage projectCards = new ProjectCardPage();
    ProjectPage projectPage = new ProjectPage();

    @Before
    public void setupProjectsPage() {
//        Configuration.headless = true;
        navigation.openLoginPage();
        login.fillEmailWithValidData();
        login.fillPasswordWithValidData();
        login.clickSignInButton();
        navigation.clickProjectsButton();
    }

    @Test
    public void checkIfProjectNamesExist() {
        navigation.clickProjectsButton();
        //targets only visible elements, so if more that 0, then should be ok
        projectCards.getProjectCardNames().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    public void checkIfProjectDescriptionExist() {
        navigation.clickProjectsButton();
        //check if no project card is expanded and expand first if true
        if (!projectCards.getProjectCardExpanded().isDisplayed()) {
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
        navigation.clickProjectsButton();
        //targets only visible elements, so if more that 0, then should be ok
        projectPage.getProjectCardContainer().shouldBe(Condition.visible);
    }

    @Test
    public void checkIfUserCanNotSeeProjectsAfterLogout() {
        navigation.logout();
        navigation.openProjectsLink();
        projectPage.getProjectCardContainer().shouldNotBe(Condition.visible);
    }

}
