package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;


public class FakerUtils {

    public static void main(String[]args){
        System.out.println(getRandomGender());
    }
    static Faker faker = new Faker(new Locale("en-GB"));


    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String streetAddress = faker.address().streetAddress();
    public String userNumber = faker.number().digits(10);
    public String genderUser = getRandomGender();
    public String userHobbies = getHobbies();
    public String userSubjects = getSubject();
    public String userPicture = getPicture();
    public String state = getRandomState();
    public String city = getRandomCiry(state);
    public String userMounht = getMounth();
    public String userYaer = getYaer();
    public String userDay = getDay();

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};

        return getRandomItemFromArray(gender);
    }

    public static String getHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(hobbies);
    }

    public static String getSubject() {
        String[] subjects  = {"Arts", "History", "English", "Chemistry",
                "Computer Science", "Commerce", "Economics", "Maths",
                "Social Studies", "Accounting", "Physics", "Biology",
                "Hindi", "Civics"};

        return getRandomItemFromArray(subjects);
    }

    public static String getPicture() {
        String[] picture = {"Screenshot_1.png", "Screenshot_5.png", "Screenshot_6.png"};

        return getRandomItemFromArray(picture);
    }

    public static String getRandomState(){
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(state);
    }

    public static String getRandomCiry(String state){
        String city ="";
        if (state.equals("NCR")) city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
    }

    public static String getMounth(){
        String[] mounth = {"December", "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November"};
        return faker.options().option(mounth);
    }

    public static String getYaer(){
        return String.valueOf(faker.number().numberBetween(1990, 2005));
    }

    public static String getDay(){
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

}
