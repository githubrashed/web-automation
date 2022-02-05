package net.brac.web.fluentlenium.page.microfinance.loan.proposal;

import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import net.brac.web.fluentlenium.util.GeneralUtil;
import org.fluentlenium.core.domain.FluentWebElement;

public class LoanProposalSetupPage extends BaseMicroFinancePage<LoanProposalSetupPage> {

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
        return "/mfDashboard#!/loanProposal/create";
    }

    public LoanProposalSetupPage selectProduct(int index) {
        el("select#product").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public LoanProposalSetupPage selectProductByValue(String value) {
        waitForBlockOverlay();
        el("select#product").scrollToCenter().fillSelect().withValue(value);
        waitForBlockOverlay();
        return this;
    }


    public LoanProposalSetupPage selectFrequency(int index) {
        el("select#loanProductDetails").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public LoanProposalSetupPage selectFrequencyByValue(String value) {
        el("select#loanProductDetails").scrollToCenter().fillSelect().withValue(value);
        return this;
    }

    public LoanProposalSetupPage selectSector(int index) {
        GeneralUtil.waitForDomStable();
        GeneralUtil.waitForDomStable();
        waitForBlockOverlay();
        el("select#sector").scrollToCenter().fillSelect().withIndex(index);
        waitForBlockOverlay();
        return this;
    }

    public LoanProposalSetupPage selectScheme(int index) {
        el("select#scheme").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public LoanProposalSetupPage fillProposedAmount(String depositAmount) {
        FluentWebElement fluentWebElementAmount = el("input#totalLoanAmount").scrollToCenter().waitAndClick();
        fluentWebElementAmount.fill().with(depositAmount);
        el("input#amountInWords").scrollToCenter().waitAndClick();
        return this;
    }

    public LoanProposalSetupPage fillInstallmentAmount(String installmentAmount) {
        FluentWebElement fluentWebElementAmount = el("input#userInstallmentAmount");
        fluentWebElementAmount.scrollToCenter().waitAndClick();
        fluentWebElementAmount.fill().with(installmentAmount);
        el("input#proposalRemarks").scrollToCenter().waitAndClick();
        if (hasFormError()) {
            String errorContent = el("div.formErrorContent").text().trim();
            String actualInstallmentAmount = errorContent.replaceAll("[^0-9]", "");
            fluentWebElementAmount.scrollToCenter().fill().with(actualInstallmentAmount);
            el("input#proposalRemarks").scrollToCenter().waitAndClick();
        }
        return this;
    }

    public LoanProposalSetupPage clickYesRadioBtn() {
        el("input#isYesMicroInsurance").scrollToCenter().waitAndClick();
        return this;
    }

    public LoanProposalSetupPage selectInsuranceProduct(int index) {
        el("select#insuranceProductId").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public LoanProposalSetupPage fillNominee1Name(String name) {
        el("input#nomineeName_0").fill().with(name);
        return this;
    }

    public LoanProposalSetupPage fillNominee1DateOfBirth(String year) {
        el("input#nomineeDob_0").scrollToCenter().waitAndClick();
        el("d#ui-datepicker-div select.ui-datepicker-year").scrollToCenter().fillSelect().withText(year);
        el("#ui-datepicker-div .ui-state-default").scrollToCenter().waitAndClick();
        return this;
    }

    public LoanProposalSetupPage selectRelationShip(int index) {
        el("select#nomineeRelationshipId_0").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public LoanProposalSetupPage fillNominee1NationalId(String nationalId) {
        el("input#nationalId_0").fill().with(nationalId);
        return this;
    }

    public LoanProposalSetupPage fillNominee1MobileNumber(String mobileNumber) {
        el("input#contactNo_0").fill().with(mobileNumber);
        return this;
    }

    public ApproveLoanPage clickSaveBtn() {
        FluentWebElement fluentWebElement = el("input.ui-state-default[name='save']");
        fluentWebElement.scrollToCenter().waitAndClick();
        return newInstance(ApproveLoanPage.class);
    }

    public LoanProposalSetupPage selectEarner() {
        el("input#type[value='1']").scrollToCenter().waitAndClick();
        return this;
    }

    public LoanProposalSetupPage selectMemberOwnIncome() {
        el("input#membersOwnIncome[value='0']").scrollToCenter().waitAndClick();
        return this;
    }

    public LoanProposalSetupPage selectLoanUser(int index) {
        el("select#type[name='loanUserId']").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }
}

