package net.brac.web.fluentlenium.page.microfinance.member.member;

import net.brac.web.fluentlenium.component.microfinance.member.MemberItem;
import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.concurrent.TimeUnit;

public class MemberListPage extends BaseMicroFinancePage<MemberListPage> {
    @Override
    protected String projectSelector() {
        return "projectId";
    }

    @Override
    public String getPageId() {
        return null;
    }

    @Override
    public String getUrl() {
        return "/mfDashboard#!/memberInfo/list";
    }

    public MemberListPage selectMemberStatus(String text) {
        waitForBlockOverlayForWaitLoading();
        el("select#memberStatus").scrollToCenter().fillSelect().withText(text);
        waitForBlockOverlayForWaitLoading();
        return this;
    }

    public MemberListPage fillErpMemberNumber(String erpMemberNumber) {
        FluentWebElement erpMemberNumberElement = el("erpMemberNumberElement");
//        isDisplayed(erpMemberNumberElement);
        erpMemberNumberElement.scrollToCenter().fill().withText(erpMemberNumber);
        return this;
    }

    public MemberListPage clickSaveBtn() {
        el(".buttons input[type='button']").scrollToCenter().waitAndClick();
        return this;
    }

    FluentList<FluentWebElement> getMembers() {
        waitForBlockOverlayForWaitLoading();
        return find("table#list2 tr[id]");
    }

    public MemberItem getFirstMember() {
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        await().atMost(30, TimeUnit.SECONDS).until(getMembers().first()).displayed();
        return getMembers().index(0).scrollToCenter().as(MemberItem.class);
    }


    public MemberItem getMemberAt(int index) {
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        await().atMost(30, TimeUnit.SECONDS).until(getMembers().first()).displayed();
        return getMembers().index(0).scrollToCenter().as(MemberItem.class);
    }


    public MemberItem getMember(String ErpMemberNumber) {
        return getMembers().stream().map(memberItem -> memberItem.as(MemberItem.class))
                .filter(memberItem -> memberItem.getErpMemberNumber().equalsIgnoreCase(ErpMemberNumber)).findAny().orElse(null);
    }

}