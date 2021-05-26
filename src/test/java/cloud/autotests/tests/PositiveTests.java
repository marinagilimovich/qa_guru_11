package cloud.autotests.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PositiveTests {
    @Test
    public void checkMainPageTitleTest() {
        open("https://www.profitero.com/");
        $("title").shouldHave(attribute("text",
                "Profitero | Accelerate your eCommerce sales"));
    }

    @Test
    public void checkMenuItemsTest() {
        open("https://www.profitero.com/");
        $("#megamenu__platform-tab").shouldHave(text("Platform"));
        $("#megamenu__who-we-help-tab").shouldHave(text("Who we help"));
        $("#megamenu__in-the-news-tab").shouldHave(text("In the news"));
        $("#megamenu__resources-tab").shouldHave(text("Resources"));
        $("#megamenu__about-us-tab").shouldHave(text("About us"));
    }

    @Test
    public void loginPageAvailabilityTest() {
        open("https://www.profitero.com/");
        $(byText("Login")).click();
        $("h1").shouldHave(text("Login"));
    }

    @Test
    public void loginWithEmptyFieldTest() {
        open("https://www.profitero.com/");
        $(byText("Login")).click();
        $("h1").shouldHave(text("Login"));
        $("#submit-btn").click();
        $$(".error-msg").first().shouldHave(text("Please enter a value."));

    }

    @Test
    public void requestDemoPageTest() {
        open("https://www.profitero.com/");
        $(byText("Request a demo")).click();
        $x("//h2/span").shouldHave(text("Accelerate your eCommerce sales"));
        $("#hs_cos_wrapper_widget_1612362065267_ p").shouldHave(text("Book your demo to see how these brands"));
    }

}
