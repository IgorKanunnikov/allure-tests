package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
    @Step("Проверяем что существует Issue с названием {text}")
    public void checkIssueWithName(String text) {
        $(withText("Test")).should(Condition.exist);
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
