package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {
    private final SelenideElement createProjectButton = $x("//button[normalize-space()='Create New Project']");
    private final SelenideElement projectCardContainer = $(".accordion");

    //clicks
    public void clickCreateProjectButton() {
        createProjectButton.click();
    }

    //getters
    public SelenideElement getProjectCardContainer() {
        return projectCardContainer;
    }
}
