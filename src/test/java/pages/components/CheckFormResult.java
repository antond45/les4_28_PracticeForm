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
        tableResponse.$(byText("Student Name")).parent().shouldHave(text(studentName));
        tableResponse.$(byText("Student Email")).parent().shouldHave(text(studentEmail));
        tableResponse.$(byText("Gender")).parent().shouldHave(text(gender));
        tableResponse.$(byText("Mobile")).parent().shouldHave(text(mobile));
        tableResponse.$(byText("Date of Birth")).parent().shouldHave(text(dateOfBirth));
        tableResponse.$(byText("Subjects")).parent().shouldHave(text(subjects));
        tableResponse.$(byText("Hobbies")).parent().shouldHave(text(hobbies));
        tableResponse.$(byText("Picture")).parent().shouldHave(text(picture));
        tableResponse.$(byText("Address")).parent().shouldHave(text(address));
        tableResponse.$(byText("State and City")).parent().shouldHave(text(stateAndCity));
    }

    public void checkOneResult (String key, String value) {
        tableResponse.$(byText(key)).parent().shouldHave(text(value));
    }
}
