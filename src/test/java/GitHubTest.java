import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;


public class GitHubTest {

    @BeforeAll()
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkForJUnit5InSoftAssertions(){
        // Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions\
        $(".js-wiki-more-pages-link").click();
        $(byId("wiki-pages-box")).$(byText("SoftAssertions"));



        // Откройте страницу SoftAssertions
        $$(".Truncate-text").get(17).click(); //сделал через get элемента посмотреть как работает
        // Проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("JUnit5 "));
    }
}
