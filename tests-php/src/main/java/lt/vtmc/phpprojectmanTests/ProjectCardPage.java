package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ProjectCardPage {
    private final ElementsCollection projectCardNames = $$(".card h4");
    private final ElementsCollection projectCardDescriptions = $$(".card-text");
    private final ElementsCollection projectCardStates = $$(".card-header div");
    private final SelenideElement projectCardExpanded = $(By.className("card-text"));

    //filling and clearing

    //clicks
    public void clickFirstProject() {
//        executeJavaScript("arguments[0].click();", projectCardNames.get(0));
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
