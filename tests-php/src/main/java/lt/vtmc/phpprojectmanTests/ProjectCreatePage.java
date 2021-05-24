package lt.vtmc.phpprojectmanTests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

import java.util.Random;

public class ProjectCreatePage {
    private final SelenideElement createProjectName = $("#name");
    private final SelenideElement createProjectDescription = $("#description");
    private final SelenideElement createProjectButton = $("form > button");
    private final SelenideElement nameError = $x("//div[normalize-space()='The name field is required.']");
    private final SelenideElement nameTakenError = $x("//div[normalize-space()='The name has already been taken.']");
    private final SelenideElement nameTooLongError = $x("//div[normalize-space()='The name must not be greater than 255 characters.']");
    private final SelenideElement descriptionError = $x("//div[normalize-space()='The description field is required.']");
    private final SelenideElement successAlert = $(".alert-heading");
    private final SelenideElement goToProjectButton = $x("//button[normalize-space()='Go To Project Task List']");

    //generating random number for username and mail registration
    Random rand = new Random();
    int randomNumber = rand.nextInt(Integer.MAX_VALUE);

    //filling and clearing
    public void fillProjectNameWithValidData() {
        createProjectName.clear();
        createProjectName.sendKeys("" + randomNumber);
    }

    public void fillProjectNameWithLongValue() {
        createProjectName.clear();
        //send 256 characters to name
        createProjectName.sendKeys("hmTdqwH5cDBtWD3p3CzzDufbGkd0tarzz5vcxbOfOakJ3Y6WyLi823ceeUoPNyf8rJaRnPDrPmydLyUOKTrTCmYO5EBhTaWFpSt066JkeJThSZY0NOEdlpz8Drt3twAC7dTyZMBw2cE6v4Id8OACqgXpfvJDbOJGffFQYnxaDcJ3ncWOlhGzz3nw70FFscbxkyZpCii14tilD43xFqdtRm9L5k96I9Ez0OHlhla9lC5ph8a9alPhtCgLd1k6s6sL");
    }

    public void clearProjectName() {
        createProjectName.clear();
    }

    public void fillProjectDescriptionWithValidData() {
        createProjectDescription.clear();
        createProjectDescription.sendKeys("Description" + randomNumber);
    }

    public void clearProjectDescription() {
        createProjectDescription.clear();
    }


    //clicks
    public void clickCreateProjectButton() {
        createProjectButton.click();
    }

    public void clickGoToProjectButton() {
        goToProjectButton.click();
    }

    //getters
    public SelenideElement getCreateProjectName() {
        return createProjectName;
    }

    public SelenideElement getCreateProjectDescription() {
        return createProjectDescription;
    }

    public SelenideElement getCreateProjectButton() {
        return createProjectButton;
    }

    public SelenideElement getNameError() {
        return nameError;
    }

    public SelenideElement getDescriptionError() {
        return descriptionError;
    }

    public SelenideElement getSuccessAlert() {
        return successAlert;
    }

    public SelenideElement getNameTakenError() {
        return nameTakenError;
    }

    public SelenideElement getNameTooLongError() {
        return nameTooLongError;
    }
}
