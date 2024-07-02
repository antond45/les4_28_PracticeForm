package pages;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarForm;
import pages.components.CheckFormResult;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    CalendarForm calendarForm = new CalendarForm();
    CheckFormResult checkFormResult = new CheckFormResult();

    //locators
    public final SelenideElement
        firstName = $("#firstName"),
        lasName = $("#lastName"),
        userEmail = $("#userEmail"),
        genterWrapper = $("#genterWrapper"),
        userNumber = $("#userNumber"),
        dateOfBirhtDay = $("#dateOfBirthInput"),
        hobbies = $("#hobbiesWrapper"),
        subjects = $("#subjectsInput"),
        uploadPicture = $("#uploadPicture"),
        currentAddress = $("#currentAddress"),
        state = $("#state"),
        stateCity = $("#stateCity-wrapper"),
        city = $("#city"),
        checkError = $("#app"),
        submit = $("#submit");


    public RegistrationForm openPage() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationForm setFirstName (String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationForm setLastName (String value) {
        lasName.setValue(value);

        return this;
    }

    public RegistrationForm setUserEmail (String value){
        userEmail.setValue(value);
        return this;
    }

    public RegistrationForm setGenter (String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationForm setUserNumber (String value){
        userNumber.setValue(value);

        return this;
    }

    public RegistrationForm setDateOFBirth (String yars, String mounth, String day){
        dateOfBirhtDay.click();
        calendarForm.setDate(yars, mounth, day);
        return this;
    }

    public RegistrationForm setHobbies (String value) {
        hobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationForm setPicture (String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationForm setSubjects (String value) {
        subjects.setValue(value).pressEnter();

        return this;
    }

    public RegistrationForm setAddress (String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationForm setState (String value) {
        state.click();
        stateCity.$(byText(value)).click();

        return this;
    }

    public RegistrationForm setCity (String value) {
        city.click();
        stateCity.$(byText(value)).click();

        return this;
    }

    public RegistrationForm clickSubmit (){
        submit.click();

        return this;
    }

    public void checkResult (String studentName, String studentEmail, String gender, String mobile,
                                         String dateOfBirth, String subjects, String hobbies, String picture,
                                         String address, String stateAndCity) {
        checkFormResult.getResult(studentName, studentEmail, gender, mobile, dateOfBirth, subjects,
                hobbies, picture, address, stateAndCity);
    }

    public RegistrationForm checkOneResult (String key, String value) {
        checkFormResult.checkOneResult(key, value);

        return this;
    }

    public RegistrationForm checkResultNegative () {
        checkError.shouldNotHave((text("Thanks for submitting the form")));
        return this;
    }
}
