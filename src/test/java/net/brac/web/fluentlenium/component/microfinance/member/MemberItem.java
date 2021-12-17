package net.brac.web.fluentlenium.component.microfinance.member;

import net.brac.web.fluentlenium.component.microfinance.TableItem;
import net.brac.web.fluentlenium.page.microfinance.member.member.MemberDetailPage;
import net.brac.web.fluentlenium.util.GeneralUtil;
import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MemberItem extends TableItem {
    /**
     * Creates a new fluent web element.
     *
     * @param element      underlying element
     * @param control      control interface
     * @param instantiator component instantiator
     */
    public MemberItem(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    public String getGender() {
        return el("td[aria-describedby$='_gender']").text().trim();
    }
    public String getStatus() {
        return el("td[aria-describedby$='_memberStatus']").text().trim();
    }


    public MemberDetailPage clickErpMemberNumber() {
        el("td a:last-child").scrollToCenter().waitAndClick();
        await().atMost(30, TimeUnit.SECONDS).untilPage().isLoaded();
        GeneralUtil.waitForDomStable();
        return newInstance(MemberDetailPage.class);
    }

}
