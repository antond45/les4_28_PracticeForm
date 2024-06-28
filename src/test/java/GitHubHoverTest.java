import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.WithText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubHoverTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }


    //Task1
    //На главной странице GitHub выберите меню Solutions -> Enterprise
    // с помощью команды hover для Solutions.
    // Убедитесь что загрузилась нужная страница (например, что заголовок: "The AI-powered developer platform.")

    @Test
    void hoverTest (){
        open("https://github.com/");
        $("header").$(withText("Solutions")).hover();
        $("[aria-labelledby=solutions-by-size-heading]").$(withText("Enterprise")).click();
        $(byText("The AI-powered")).shouldBe(visible);
        $(byText("developer platform.")).shouldBe(visible);
    }

    //Task2
    //(опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
    @Test
    void dragAndDropTest () {
        //- Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //- Перенесите прямоугольник А на место В
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();

        //- Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldBe(text("B"));

        //- В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldBe(text("A"));
    }
}
