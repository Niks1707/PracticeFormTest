import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoToEnterpriseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test

    void fromGitHubToEnterpriseTest() {
        open("https://github.com");
        $$("ul.d-lg-flex.list-style-none li").get(13).shouldBe(visible).hover();
        $$("ul.list-style-none.f5 li").get(12).shouldBe(visible).$("[href*='/enterprise']").click();

        $(".Primer_Brand__SubNav-module__SubNav__heading-container___jlouG").shouldBe(text("Enterprise"));
    }
}
