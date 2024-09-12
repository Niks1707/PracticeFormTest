import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindJUnit5SoftAssertionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void jUnit5inSoftAssertionsTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        Selenide.executeJavaScript("window.scrollBy(0,500);");//добавила скролл, т.к. не проходит тест на ноутбуке
        $("[href*='SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """));
        $("#wiki-body").shouldHave(text("""
                class Tests {
                  @RegisterExtension
                  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();
                
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }"""));
    }
}