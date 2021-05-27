package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProjectTaskPage {
    private final SelenideElement projectName = $("h2");

    //getters
    public SelenideElement getProjectName() {
        return projectName;
    }
}
