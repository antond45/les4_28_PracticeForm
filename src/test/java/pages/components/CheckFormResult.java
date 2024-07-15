package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckFormResult {

    public final SelenideElement
            tableResponse = $(".table-responsive");

    public void getResult(String studentName, String studentEmail, String gender, String mobile, String dateOfBirth,
                          String subjects, String hobbies, String picture,
                          String address, String stateAndCity ){
        tableResponse.$(byText("Student Name")).parent().$x("td[2]").shouldHave(text(studentName));
        tableResponse.$(byText("Student Email")).parent().$x("td[2]").shouldHave(text(studentEmail));
        tableResponse.$(byText("Gender")).parent().$x("td[2]").shouldHave(text(gender));
        tableResponse.$(byText("Mobile")).parent().$x("td[2]").shouldHave(text(mobile));
        tableResponse.$(byText("Date of Birth")).parent().$x("td[2]").shouldHave(text(dateOfBirth));
        tableResponse.$(byText("Subjects")).parent().$x("td[2]").shouldHave(text(subjects));
        tableResponse.$(byText("Hobbies")).parent().$x("td[2]").shouldHave(text(hobbies));
        tableResponse.$(byText("Picture")).parent().$x("td[2]").shouldHave(text(picture));
        tableResponse.$(byText("Address")).parent().$x("td[2]").shouldHave(text(address));
        tableResponse.$(byText("State and City")).parent().$x("td[2]").shouldHave(text(stateAndCity));
    }

    public void checkOneResult (String key, String value) {
        tableResponse.$(byText(key)).parent().$x("td[2]").shouldHave(text(value));
    }
}
