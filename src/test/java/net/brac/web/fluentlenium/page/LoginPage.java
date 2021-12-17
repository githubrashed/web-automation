package net.brac.web.fluentlenium.page;

import net.brac.web.fluentlenium.util.GeneralUtil;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    public static final String PAGE_ID = "login";

    @Override
    public String getPageId() {
        return PAGE_ID;
    }

    @Override
    public String getUrl() {
        return "/login";
    }

    public LoginPage fillAndSubmitForm(String username, String password) {
        FluentWebElement usernameEl = el("input#username_txt");
//        isDisplayed(usernameEl);
        usernameEl.fill().with(username);
        FluentWebElement passwordEl = el("input#password");
//        isDisplayed(usernameEl);
        passwordEl.fill().with(password);
        el("form[id='loginForm'] button[type='button']").scrollToCenter().waitAndClick();
        GeneralUtil.waitForDomStable();
        return this;
    }

    //    public MyDashboardPage selectOffice(String officeCode) {
//        if (hasOffice()) {
//            selectValueFromFlexBoxByText("officeIdDiv", officeCode);
//            waitAndClickElement(el("#search-form .button.mar_right5"));
//            waitForBlockOverlay();
//            await().atMost(10, TimeUnit.SECONDS).until(this::isNotAtPage);
//            await().atMost(10, TimeUnit.SECONDS).untilPage().isLoaded();
//            GeneralUtil.waitForDomStable();
//        }
//        return newInstance(MyDashboardPage.class);
//    }
    public MyDashboardPage selectOffice(String officeCode) {
        if (hasOffice()) {
            FluentWebElement fluentWebElement = el("input[id^='officeIdDiv_input");
            fluentWebElement.scrollToCenter().waitAndClick();
            fluentWebElement.fill().with(officeCode);
            FluentList<FluentWebElement> fluentWebElements = find("div[id^='officeIdDiv_ctr'] div [id][class]");
            await().atMost(10, TimeUnit.SECONDS).until(fluentWebElements).size().greaterThanOrEqualTo(1);
            fluentWebElements.get(0).scrollToCenter().waitAndClick();
//            waitForBlockOverlay();
            el("#search-form .button.mar_right5").scrollToCenter().waitAndClick();
            GeneralUtil.waitForDomStable();
        }
        return newInstance(MyDashboardPage.class);

    }

    public boolean hasOffice() {
        return find("form#search-form").count() > 0;
    }

}
