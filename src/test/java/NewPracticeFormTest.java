import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationForm;
import utils.FakerUtils;

public class NewPracticeFormTest extends TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    FakerUtils fakerUtils = new FakerUtils();
    @CsvSource(value = {
            "Anton, 8917222225", "cats, 8917222226"
    })
    @Tag("smoke")
    @ParameterizedTest (name = "Проерка регистрации для имени {0} и телефона {1}")
    void positiveAllRegistrationFormTest (String userName, String userNumber){
        registrationForm.openPage()
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
    }

    @ValueSource(strings = {"Anton", "Stepa", "Yura"} )
    @Tag("regres")
    @ParameterizedTest (name = "Проверка минимального набора данных с именем {0}")
    void testWithRequiredFieldsPositive(String name){
        registrationForm.openPage()
                .setFirstName(name)
                .setLastName(fakerUtils.lastName)
                .setGenter(fakerUtils.genderUser)
                .setUserNumber(fakerUtils.userNumber)
                .clickSubmit();

        registrationForm.checkOneResult("Student Name", name + " " + fakerUtils.lastName)
        .checkOneResult("Gender", fakerUtils.genderUser)
        .checkOneResult("Mobile", fakerUtils.userNumber);
    }

    @Test
    void testNegativeRegistration(){
        registrationForm.openPage()
            .setFirstName(fakerUtils.firstName)
                .setUserNumber(fakerUtils.userEmail)
                .setGenter(fakerUtils.genderUser)
                .clickSubmit();

        registrationForm.checkResultNegative();
    }


}
