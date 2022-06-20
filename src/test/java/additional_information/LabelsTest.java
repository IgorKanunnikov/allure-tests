package additional_information;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("Igor")
    @Severity(SeverityLevel.MINOR)
    @Feature("Логин юзера")
    @Story("Можно что-нибудь написать")
    @DisplayName("Тест на логин юзера")
    @Description("Невероятный тест")
    @Link(name = "GitHub", url = "https://github.com")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.label("owner", "Igor");
        Allure.label("severity", SeverityLevel.NORMAL.value());
        Allure.feature("Разлогин юзера");
        Allure.story("Можно динамически кого-нибудь пнуть");
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setName("Что за тест мама мия"));
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setDescription("Что здесь происходит"));
        Allure.link("GitHub", "https://guthub.com");
    }

    @Test
    public void testParameters() {
        Allure.parameter("Город", "Москва");
        Allure.parameter("Область", "Московская");
    }

}