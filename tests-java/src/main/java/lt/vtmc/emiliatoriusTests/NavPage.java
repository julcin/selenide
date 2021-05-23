package lt.vtmc.emiliatoriusTests;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class NavPage {

    private final SelenideElement pageNavName = $(".navbar-brand");
    private final SelenideElement navButton = $("nav button");
    private final SelenideElement userName = $(".dropdown-item a");
    private final SelenideElement logoutButton = $(".dropdown-item p");

    //    methods
    public void clickNavButton() {
        navButton.click();
    }

    public void signOut() {
        clickNavButton();
        logoutButton.click();
    }

    //    getters
    public SelenideElement getPageNavName() {
        return pageNavName;
    }

    public SelenideElement getNavButton() {
        return navButton;
    }

    public SelenideElement getUserName() {
        return userName;
    }

    public SelenideElement getLogoutButton() {
        return logoutButton;
    }
}
