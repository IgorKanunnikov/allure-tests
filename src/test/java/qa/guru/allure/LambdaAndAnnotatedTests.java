package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaAndAnnotatedTests {

    private final String REP = "IgorKanunnikov/qa_guru_1";
    private final String issueNameCheck = "Test";
    WebSteps steps = new WebSteps();

    @Test
    void lambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу github", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий по имени " + REP, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REP);
            $(".header-search-input").submit();
        });
        step("В резузьтатх поиска переходим по ссылке репозитория " + REP, () -> {
            $(linkText("IgorKanunnikov/qa_guru_1")).click();
        });
        step("Кликаем и открываем Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue с названием " + issueNameCheck, () -> {
            $(withText(issueNameCheck)).should(Condition.exist);
        });
    }

    @Test
    void annotatedTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();
        steps.searchForRep(REP);
        steps.openRepLink(REP);
        steps.openIssueTab();
        steps.checkIssueWithName(issueNameCheck);
    }
}

