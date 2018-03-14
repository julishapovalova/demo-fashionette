import com.codeborne.selenide.Selenide;

public class HomePage extends BasePage {

    public Header header;

    HomePage() {
        header = new Header();
    }

    @Override
    public void open() {
        Selenide.open("/");
    }
}
