import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @Test
    void shouldBeCodeForJUnit5() {
        //open https://github.com/selenide/selenide
        open("https://github.com/selenide/selenide");

        //go to Wiki page
        $("#wiki-tab").click();

        //Make sure there is a SoftAssertions page in the Pages list
        $(".f6.Link--muted.js-wiki-more-pages-link.btn-link.mx-auto").click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("SoftAssertions"));

        //Open the SoftAssertions page, check that inside there is a sample code for JUnit5
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:")).sibling(0)
                .shouldHave(text("""
                     @ExtendWith({SoftAssertsExtension.class})
                     class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                        
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                    }
                """));
        sleep(5000);
    }
}
