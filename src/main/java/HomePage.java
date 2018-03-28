import com.codeborne.selenide.Selenide;

public class HomePage extends BasePage {

    public Header header;

    HomePage() {
        header = new Header();
    }

    @Override
    public HomePage open() {
        Selenide.open("/");
        return new HomePage();
    }
}
