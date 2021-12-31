package net.brac.web.fluentlenium.page.microfinance;

import net.brac.web.fluentlenium.page.BasePage;
import net.brac.web.fluentlenium.util.GeneralUtil;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.concurrent.TimeUnit;

public abstract class BaseMicroFinancePage<T extends BaseMicroFinancePage> extends BasePage {

    protected abstract String projectSelector();

    public T selectProject(String value) {
        waitForBlockOverlay();
        GeneralUtil.waitForDomStable();
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        await().atMost(30, TimeUnit.SECONDS).until(el("select#" + projectSelector())).displayed();
        waitForBlockOverlay();
        el("select#" + projectSelector()).scrollToCenter().fillSelect().withValue(value);
        GeneralUtil.waitForDomStable();
        return (T) this;
    }

    public T clickMemberNumber() {
        GeneralUtil.waitForDomStable();
        hasBlockPageImage();
        el("#memberLookupHtml a img[src$='zoom-small.png']").scrollToCenter().waitAndClick();
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        await().atMost(30, TimeUnit.SECONDS).until(el("table#fancybox-memberLookupHtml")).displayed();
        FluentList<FluentWebElement> fluentWebElementsMemberNumber = find("tbody tr td:first-child a:last-child");
        if (fluentWebElementsMemberNumber.count() > 0) {
            el("thead div.DataTables_sort_wrapper").scrollToCenter().waitAndClick();
            el("thead div.DataTables_sort_wrapper").scrollToCenter().waitAndClick();
        }
        await().atMost(30, TimeUnit.SECONDS).until(fluentWebElementsMemberNumber).size().greaterThanOrEqualTo(1);
        fluentWebElementsMemberNumber.get(0).scrollToCenter().waitAndClick();
        GeneralUtil.waitForDomStable();
        hasBlockPageImage();
        return (T) this;
    }

    public T fillMemberNumber(String memberNumber) {
        FluentWebElement fluentWebElementMembershipNumber = el("input#membershipNumber");
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        await().atMost(30, TimeUnit.SECONDS).until(fluentWebElementMembershipNumber).displayed();
        fluentWebElementMembershipNumber.scrollToCenter().fill().with(memberNumber);
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        FluentWebElement fluentWebElementErpMemberNo = el("input#value");
        fluentWebElementErpMemberNo.scrollToCenter().waitAndClick();
        waitForBlockOverlay();
        GeneralUtil.waitForDomStable();
        return (T) this;
    }

}
