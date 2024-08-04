
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationForm;
import utils.FakerUtils;

import static io.qameta.allure.Allure.step;

@Tag("regression")
public class NewPracticeFormTest extends TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    FakerUtils fakerUtils = new FakerUtils();
    @CsvSource(value = {
            "Anton, 8917222225", "cats, 8917222226"
    })
    @Tag("smoke")
    @ParameterizedTest (name = "Проерка регистрации для имени {0} и телефона {1}")
    void positiveAllRegistrationFormTest (String userName, String userNumber){
        step("Open form", () -> {
            registrationForm.openPage();});

        step("Fill form", () -> {
            registrationForm
                    .setFirstName(userName)
                    .setLastName(fakerUtils.lastName)
                    .setUserEmail(fakerUtils.userEmail)
                    .setGenter(fakerUtils.genderUser)
                    .setUserNumber(userNumber)
                    .setDateOFBirth(fakerUtils.userYaer, fakerUtils.userMounht, fakerUtils.userDay)
                    .setHobbies(fakerUtils.userHobbies)
                    .setSubjects(fakerUtils.userSubjects)
                    .setPicture(fakerUtils.userPicture)
                    .setAddress(fakerUtils.streetAddress)
                    .setState(fakerUtils.state)
                    .setCity(fakerUtils.city)
                    .clickSubmit();
        });

        step("Check results", () -> {
            registrationForm.checkResult(
                    userName + " " + fakerUtils.lastName,
                    fakerUtils.userEmail,
                    fakerUtils.genderUser,
                    userNumber,
                    fakerUtils.userDay + " " + fakerUtils.userMounht + "," + fakerUtils.userYaer,
                    fakerUtils.userSubjects,
                    fakerUtils.userHobbies,
                    fakerUtils.userPicture,
                    fakerUtils.streetAddress,
                    fakerUtils.state + " " + fakerUtils.city

            );
        });
    }

    @ValueSource(strings = {"Anton", "Stepa", "Yura"} )
    @Tag("smoke")
    @ParameterizedTest (name = "Проверка минимального набора данных с именем {0}")
    void testWithRequiredFieldsPositive(String name){
        step("Open form", () -> {
            registrationForm.openPage();});
        step("Fill form", () -> {
            registrationForm.setFirstName(name)
                    .setLastName(fakerUtils.lastName)
                    .setGenter(fakerUtils.genderUser)
                    .setUserNumber(fakerUtils.userNumber)
                    .clickSubmit();
        });

        step("Check results", () -> {
            registrationForm.checkOneResult("Student Name", name + " " + fakerUtils.lastName)
                    .checkOneResult("Gender", fakerUtils.genderUser)
                    .checkOneResult("Mobile", fakerUtils.userNumber);
        });
    }

    @Test
    void testNegativeRegistration(){
        step("Open form", () -> {
            registrationForm.openPage();});
        step("Fill form", () -> {
            registrationForm.setFirstName(fakerUtils.firstName)
                    .setUserNumber(fakerUtils.userEmail)
                    .setGenter(fakerUtils.genderUser)
                    .clickSubmit();
        });
        step("Check results", () -> {
            registrationForm.checkResultNegative();
        });
    }


}