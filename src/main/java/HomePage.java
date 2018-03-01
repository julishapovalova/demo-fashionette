import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    Header header;
    /*Header header;
    Footer footer;
    PageBody body;*/
    HomePage(){
        header=new Header();
    }

//    public HomePage open(){
//        Selenide.open("https://www.fashionette.de/");
//        return this;
//    }



}
