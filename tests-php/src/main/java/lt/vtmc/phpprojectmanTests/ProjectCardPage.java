package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ProjectCardPage {
    private final ElementsCollection projectCardNames = $$(".card h4");
    private final ElementsCollection projectCardDescriptions = $$(".card-text");
    private final ElementsCollection projectCardStates = $$(".card-header div");
    private final SelenideElement projectCardExpanded = $(By.className("collapse show"));

    //filling and clearing


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

    public SelenideElement getProjectCardExpanded() {
        return projectCardExpanded;
    }
}
