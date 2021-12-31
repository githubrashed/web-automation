package net.brac.web.fluentlenium.page.microfinance.loan.collection;

import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import net.brac.web.fluentlenium.util.GeneralUtil;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.concurrent.TimeUnit;

public class MemberLoanCollectionProgotiPage extends BaseMicroFinancePage<MemberLoanCollectionProgotiPage> {
    @Override
    protected String projectSelector() {
        return "project_info_id";
    }

    @Override
    public String getPageId() {
        return null;
    }

    @Override
    public String getUrl() {
        return "/mfDashboard#!/individualLoanCollection/memberLoanCollection";
    }

    public MemberLoanCollectionProgotiPage selectAccountNo(int index) {
        waitForBlockOverlay();
        el("select#loanAccountId").scrollToCenter().fillSelect().withIndex(index);
        waitForBlockOverlay();
        return this;
    }

    public MemberLoanCollectionProgotiPage clickCashRadioBtn() {
        FluentWebElement element = el("input#paymentMethodCash");
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        await().atMost(30, TimeUnit.SECONDS).until(element).clickable();
        element.scrollToCenter().waitAndClick();
        return this;
    }

    public MemberLoanCollectionProgotiPage selectCollectedBy(int index) {
        el("select#collectedBy").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public MemberLoanCollectionProgotiPage fillMemberPayment(int amount) {
        el("input#realizedAmount").scrollToCenter().fill().with(String.valueOf(amount));
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        GeneralUtil.waitForDomStable();
        return this;
    }

    public MemberLoanCollectionProgotiPage clickSaveBtn() {
        el("input#saveButtonId").scrollToCenter().waitAndClick();
        waitForSubmissionLoader();
        FluentWebElement fluentWebElementMessage = el("div.message");
        await().atMost(30, TimeUnit.SECONDS).until(fluentWebElementMessage).displayed();
        return this;
    }
}
