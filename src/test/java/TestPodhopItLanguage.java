import com.codeborne.selenide.Configuration;
import data.Language;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPodhopItLanguage {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    public void settingsAfterTest() {
        closeWebDriver();
    }

    @EnumSource(Language.class)
    @ParameterizedTest (name = "Проверка переключения языка для podhodit")
    void podhoditLangTest(Language chooseLang) {
        open("https://podhodit.com");
        $(".lang-panel").$(byText(chooseLang.name())).click();
        $(".fadeInDown").shouldHave(text(chooseLang.description));
    }

}
