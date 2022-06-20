package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу github")
    public void openMainPage() {
        open("https://github.com/");
    }
    @Step("Ищем репозиторий по имени {repository}")
    public void searchForRep(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").setValue("IgorKanunnikov/qa_guru_1");
        $(".header-search-input").submit();
    }
    @Step("В резузьтатх поиска переходим по ссылке репозитория {repository}")
    public void openRepLink(String repository) {
        $(linkText("IgorKanunnikov/qa_guru_1")).click();
    }
    @Step("Кликаем и открываем Issues")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }
    @Step("Проверяем что существует Issue с номером {num}")
    public void checkIssueWithNumber(Integer num) {
        $(withText("#3")).should(Condition.exist);
    }
}
