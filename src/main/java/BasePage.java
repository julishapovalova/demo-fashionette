import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {

    BasePage() {
    }

    public void open() {
        Selenide.open("");
    }

    String checkedIsOpen() {
        return url();
    }
}
