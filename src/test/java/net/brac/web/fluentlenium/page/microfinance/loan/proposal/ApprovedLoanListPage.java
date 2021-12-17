package net.brac.web.fluentlenium.page.microfinance.loan.proposal;

import net.brac.web.fluentlenium.component.microfinance.loan.LoanItem;
import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

public class ApprovedLoanListPage extends BaseMicroFinancePage<ApprovedLoanListPage> {
    @Override
    public String getPageId() {
        return null;
    }

    @Override
    protected String projectSelector() {
        return "project_info_id";
    }

    @Override
    public String getUrl() {
        return "/mfDashboard#!/loanApproval/approvedLoanList";
    }

    public ApprovedLoanListPage clickSearchBtn() {
        el("input[type='button']").scrollToCenter().waitAndClick();
        return this;
    }

    public FluentList<FluentWebElement> getApprovedLoans() {
        return find("table#loan-approved-grid tbody tr[id]");
    }

    public LoanItem getFirstApprovedLoanItem() {
        return getApprovedLoans().first().as(LoanItem.class);
    }

    public LoanItem getLoanItem(String memberNumber) {
        return getApprovedLoans().stream().map(member -> member.as(LoanItem.class))
                .filter(member -> member.getMemberNumber().equals(memberNumber)).findAny().orElse(null);
    }

}
