package trySelenide;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class truingDifferentTests {
    SelenideElement blockA = $("[id=\"column-a\"]");
    SelenideElement blockB = $("[id=\"column-b\"]");
    @Test
    void solntsevShouldBeTheTopContributor() {
        //открыть страницу репозитория selenide
        open("https://github.com/selenide/selenide");
        //подвести мышку к первому контрибьютору
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        //проверка во всплывающем окне есть текст "Андрей Солнцев"
        $(".Popover").shouldHave(text("Andrei Solntsev"));

    }
    @Test
    void findCodeExamplesForJUnit5() {
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("[href=\"/selenide/selenide/wiki\"]").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("[data-filterable-for=\"wiki-pages-filter\"]").$(byText("Show 3 more pages…")).click();
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("[data-filterable-for=\"wiki-pages-filter\"]").$(byText("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("Using JUnit5"));
    }
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        //открыть главную страницу
        open("https://github.com/");
        //ввести в поиске selenide и нажать enter
        $("[placeholder=\"Search or jump to...\"]").click();
        $("[id=\"query-builder-test\"]").setValue("selenide").pressEnter();
        //кликнуть на первый репозиторий из списка найденных
        $("[href=\"/selenide/selenide\"]").click();
        //проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
    @Test
    void getGitHubPageSolution() {
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $("[href=\"/enterprise\"]").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
    @Test
    void testDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //actions().moveToElement($(byText("A"))).clickAndHold().moveToElement($(byText("B"))).release().perform();
        blockA.dragAndDrop(to(blockB));
        blockA.shouldHave(text("B"));
        blockB.shouldHave(text("A"));
    }
}
