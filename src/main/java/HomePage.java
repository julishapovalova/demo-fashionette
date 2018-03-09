import com.codeborne.selenide.Selenide;


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
