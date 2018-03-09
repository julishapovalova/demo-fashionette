import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    public Header header;
    public LoginFrame loginFrame;

    HomePage() {
        header = new Header();
    }

    public static HomePage open() {
        Selenide.open("/");
        return new HomePage();
    }


}
