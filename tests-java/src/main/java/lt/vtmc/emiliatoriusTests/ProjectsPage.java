package lt.vtmc.emiliatoriusTests;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private final SelenideElement mainPageNavName = $(".navbar-brand");

    public void openProjectsPage() {
        open("http://localhost:3000/projects");
    }

    public SelenideElement getMainPageNavName() {
        return mainPageNavName;
    }
}
