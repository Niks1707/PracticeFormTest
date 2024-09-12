import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class MoveAToBTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void dragAndDropTest() {
        open("/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        actions().clickAndHold(elementA).moveToElement(elementB).release().perform();
       $("#column-b").shouldHave(text("A"));

    }
    @Test
    void dragAndDropTests() {
        open("/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        $(elementA).dragAndDrop(to(elementB));
        $("#column-b").shouldHave(text("A"));
    }

}
