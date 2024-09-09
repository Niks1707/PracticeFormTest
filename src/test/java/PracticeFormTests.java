import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("iivanov@gmail.com");
        $("#genterWrapper").find("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8800555353");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$("option[value='1997']").click();
        $(".react-datepicker__month-select").$("option[value='4']").click();
        $(".react-datepicker__day--028").click();
        $("#subjectsInput").setValue("Physic").pressEnter();
        $("#hobbiesWrapper").find("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#currentAddress").setValue("Lenina street");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Ivan Ivanov"));
        $(".modal-body").shouldHave(text("iivanov@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8800555353"));
        $(".modal-body").shouldHave(text("28 April,1997"));
        $(".modal-body").shouldHave(text("test.png"));
        $(".modal-body").shouldHave(text("Lenina street"));
        $(".modal-body").shouldHave(text("NCR Gurgaon"));
        $("#closeLargeModal").click();
    }
}