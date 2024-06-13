import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //name-email
        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("anton@tests.test");


        //gender
        $("#genterWrapper").$(byText("Male")).click();

        //Number
        $("#userNumber").setValue("89175555758");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__month").$(byText("14")).click();

        //Subjects/Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsInput").setValue("English").pressEnter();


        //Picture
        $("#uploadPicture").uploadFromClasspath("Screenshot_5.png");

        //Address
        $("#currentAddress").setValue("1234");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();


        $("#submit").click();

        //form-reg
        $(".table-responsive")
                .shouldHave(text("Anton Test"))
                .shouldHave(text("anton@tests.test"))
                .shouldHave(text("Male"))
                .shouldHave(text("8917555575"))
                .shouldHave(text("14 February,1997"))
                .shouldHave(text("English"))
                .shouldHave(text("Sports"))
                .shouldHave(text("Screenshot_5.png"))
                .shouldHave(text("1234"))
                .shouldHave(text("Uttar Pradesh Agra"));
    }
}
