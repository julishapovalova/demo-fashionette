import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {

    BasePage() {
    }

    public BasePage open() {
        Selenide.open("");
        return new BasePage();
    }

    boolean checkedIsOpen(String expectedUrl) {
        return url().contains(expectedUrl);
    }
}
