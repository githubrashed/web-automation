package net.brac.web.fluentlenium.page.microfinance.loan.disbursement;

import net.brac.web.fluentlenium.component.microfinance.loan.disbursement.DisbursedLoanItem;
import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

public class DisbursedLoanListPage extends BaseMicroFinancePage<DisbursedLoanListPage> {
    @Override
    protected String projectSelector() {
        return null;
    }

    @Override
    public String getPageId() {
        return "project_info_id";
    }

    @Override
    public String getUrl() {
        return "/mfDashboard#!/loanDisbursement/disbursedLoanList";
    }

    public DisbursedLoanListPage clickSaveBtn() {
        FluentWebElement fluentWebElement = el("input.ui-state-default[name='create']");
        fluentWebElement.scrollToCenter().waitAndClick();
        return this;
    }

    public FluentList<FluentWebElement> getDisbursedLoans() {
        return find("table#loan-disbursed-grid tbody tr[id]");
    }

    public DisbursedLoanItem getFirstDisbursedLoan() {
        return getDisbursedLoans().first().as(DisbursedLoanItem.class);
    }

}
