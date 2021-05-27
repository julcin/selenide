package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ProjectCardPage {
    private final ElementsCollection projectCardNames = $$(".card h4");
    private final ElementsCollection projectCardDescriptions = $$(".card-text");
    private final ElementsCollection projectCardStates = $$(By.className("project-state"));
    private final ElementsCollection projectCardTasksAssigned = $$(By.className("project-tasks-assigned"));
    private final ElementsCollection projectCardSTasksLeft = $$(By.className("project-unfinished-tasks"));
    private final SelenideElement projectCardExpanded = $(By.className("card-text"));

    //clicks
    public void clickFirstProject() {
        projectCardNames.get(0).click();
    }

    //getters
    public ElementsCollection getProjectCardNames() {
        return projectCardNames;
    }

    public ElementsCollection getProjectCardDescriptions() {
        return projectCardDescriptions;
    }

    public ElementsCollection getProjectCardStates() {
        return projectCardStates;
    }

    public ElementsCollection getProjectCardTasksAssigned() {
        return projectCardTasksAssigned;
    }

    public ElementsCollection getProjectCardSTasksLeft() {
        return projectCardSTasksLeft;
    }

    public SelenideElement getProjectCardExpanded() {
        return projectCardExpanded;
    }
}
