import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class Background {
    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = "https://www.fashionette.de";
        open(Configuration.baseUrl);
    }
}
