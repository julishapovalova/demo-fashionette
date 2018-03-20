import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {

    BasePage() {
    }

    public void open() {
        Selenide.open("");
    }

    boolean checkedIsOpen(String expectedUrl) {
        return url().contains(expectedUrl);
    }
}
