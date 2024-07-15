import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationForm;
import utils.FakerUtils;

public class NewPracticeFormTest extends TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    FakerUtils fakerUtils = new FakerUtils();
    @Test
    void positiveAllRegistrationFormTest (){
        registrationForm.openPage()
                .setFirstName(fakerUtils.firstName)
                .setLastName(fakerUtils.lastName)
                .setUserEmail(fakerUtils.userEmail)
                .setGenter(fakerUtils.genderUser)
                .setUserNumber(fakerUtils.userNumber)
                .setDateOFBirth(fakerUtils.userYaer, fakerUtils.userMounht, fakerUtils.userDay)
                .setHobbies(fakerUtils.userHobbies)
                .setSubjects(fakerUtils.userSubjects)
                .setPicture(fakerUtils.userPicture)
                .setAddress(fakerUtils.streetAddress)
                .setState(fakerUtils.state)
                .setCity(fakerUtils.city)
                .clickSubmit();

        registrationForm.checkResult(
                fakerUtils.firstName + " " + fakerUtils.lastName,
                fakerUtils.userEmail,
                fakerUtils.genderUser,
                fakerUtils.userNumber,
                fakerUtils.userDay + " " + fakerUtils.userMounht + "," + fakerUtils.userYaer,
                fakerUtils.userSubjects,
                fakerUtils.userHobbies,
                fakerUtils.userPicture,
                fakerUtils.streetAddress,
                fakerUtils.state + " " + fakerUtils.city

        );
    }

    @Test
    void testWithRequiredFieldsPositive(){
        registrationForm.openPage()
                .setFirstName(fakerUtils.firstName)
                .setLastName(fakerUtils.lastName)
                .setGenter(fakerUtils.genderUser)
                .setUserNumber(fakerUtils.userNumber)
                .clickSubmit();

        registrationForm.checkOneResult("Student Name", fakerUtils.firstName + " " + fakerUtils.lastName)
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
