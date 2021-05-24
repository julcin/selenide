package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class NavigationPage {
    private final SelenideElement loginPageButton = $("a[href='/login']");
    private final SelenideElement registerPageButton = $("a[href='/register']");
    private final SelenideElement logoutButton = $("a[href='/logout']");
    private final SelenideElement projectsButton = $("a[href='/projects']");
    private final SelenideElement logoutOk = $(By.linkText("OK"));
    private final SelenideElement pageNavName = $("nav h1");
    private final SelenideElement userName = $("nav p");

    //methods
    public void openLoginPage() {
        open("http://lieta.lt");
        loginPageButton.click();
    }

    public void openRegisterPage() {
        open("http://lieta.lt");
        registerPageButton.click();
    }

    public void openProjectsLink() {
        open("http://lieta.lt/projects");
    }

    //click methods
    public void clickProjectsButton() {
        projectsButton.click();
    }

    public void logout() {
        logoutButton.click();
        logoutOk.click();
    }

    //getters
    public SelenideElement getPageNavName() {
        return pageNavName;
    }

    public SelenideElement getUserName() {
        return userName;
    }
}
