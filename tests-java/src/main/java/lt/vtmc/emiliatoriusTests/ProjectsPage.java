package lt.vtmc.emiliatoriusTests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    //private final SelenideElement pageNavName = $(".navbar-brand");

    //    methods
    public void openProjectsPage() {
        open("http://localhost:3000/projects");
    }


    //    getters

}
