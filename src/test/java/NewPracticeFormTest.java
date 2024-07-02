import org.junit.jupiter.api.Test;
import pages.RegistrationForm;

public class NewPracticeFormTest extends TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    @Test
    void positiveAllRegistrationFormTest (){
        registrationForm.openPage()
                .setFirstName("Anton")
                .setLastName("Test")
                .setUserEmail("anton@tests.test")
                .setGenter("Male")
                .setUserNumber("7917257895")
                .setDateOFBirth("1997", "February", "14")
                .setHobbies("Sports")
                .setSubjects("English")
                .setPicture("Screenshot_5.png")
                .setAddress("1234")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .clickSubmit();

        registrationForm.checkResult(
                "Anton Test",
                "anton@tests.test",
                "Male",
                "7917257895",
                "14 February,1997",
                "English",
                "Sports",
                "Screenshot_5.png",
                "1234",
                "Uttar Pradesh Agra"
        );
    }

    @Test
    void testWithRequiredFieldsPositive(){
        registrationForm.openPage()
                .setFirstName("Anton")
                .setLastName("Test")
                .setGenter("Male")
                .setUserNumber("7917257895")
                .clickSubmit();

        registrationForm.checkOneResult("Student Name", "Anton Test")
        .checkOneResult("Gender", "Male")
        .checkOneResult("Mobile", "7917257895");
    }

    @Test
    void testNegativeRegistration(){
        registrationForm.openPage()
            .setFirstName("Anton")
                .setUserNumber("7917257895")
                .setGenter("Male")
                .clickSubmit();

        registrationForm.checkResultNegative();
    }


}
