package pages.components;

import pages.RegistrationForm;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarForm {

    public void setDate (String yars, String mounth, String day){
        $(".react-datepicker__month-select").selectOption(mounth);
        $(".react-datepicker__year-select").selectOption(yars);
        $(".react-datepicker__month").$(byText(day)).click();


    }
}
