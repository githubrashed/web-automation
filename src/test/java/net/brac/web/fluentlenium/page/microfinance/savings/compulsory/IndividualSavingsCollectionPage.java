package net.brac.web.fluentlenium.page.microfinance.savings.compulsory;

import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import net.brac.web.fluentlenium.util.GeneralUtil;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.concurrent.TimeUnit;

public class IndividualSavingsCollectionPage extends BaseMicroFinancePage<IndividualSavingsCollectionPage> {
    @Override
    public String getUrl() {
        return "/mfDashboard#!/individualSavingsCollection/create";
    }

    @Override
    protected String projectSelector() {
        return "project_info_id";
    }

    @Override
    public String getPageId() {
        return null;
    }

    public IndividualSavingsCollectionPage clickCashRadioBtn() {
        el("input#cash").scrollToCenter().waitAndClick();
        return this;
    }

    public IndividualSavingsCollectionPage fillDepositAmount(String depositAmount) {
        FluentWebElement element = el("input#depositAmount");
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        await().atMost(30, TimeUnit.SECONDS).until(element).clickable();
        element.scrollToCenter().fill().with(depositAmount);
        FluentWebElement element1 = el("input#amountInWords");
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        await().atMost(30, TimeUnit.SECONDS).until(element1).displayed();
        GeneralUtil.waitForDomStable();
        return this;
    }

    public IndividualSavingsCollectionPage clickSaveBtn() {
        GeneralUtil.waitForDomStable();
        el(".buttons input[name='save']").scrollToCenter().waitAndClick();
        waitForSubmissionLoader();
        return this;
    }

}
