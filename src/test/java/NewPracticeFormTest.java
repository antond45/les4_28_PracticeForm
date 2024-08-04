
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationForm;
import utils.FakerUtils;

import static io.qameta.allure.Allure.step;

@Tag("smoke")
public class NewPracticeFormTest extends TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    FakerUtils fakerUtils = new FakerUtils();

    @Tag("regression")
    @Test
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

    @Tag("regression")
    @Test
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

    @Tag("negative")
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
