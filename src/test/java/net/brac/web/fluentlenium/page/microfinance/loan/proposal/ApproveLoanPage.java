package net.brac.web.fluentlenium.page.microfinance.loan.proposal;

import net.brac.web.fluentlenium.component.microfinance.loan.proposal.UnApproveLoanItem;
import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import net.brac.web.fluentlenium.util.GeneralUtil;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

public class ApproveLoanPage extends BaseMicroFinancePage<ApproveLoanPage> {
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
        return "/mfDashboard#!/loanApproval/unApprovedLoanList";
    }

    public ApproveLoanPage clearFromDate() {
        el("input#fromDate").scrollToCenter().clear();
        return this;
    }

    public ApproveLoanPage clearToDate() {
        el("input#toDate").scrollToCenter().clear();
        return this;
    }

    public ApproveLoanPage clickSearchBtn() {
        el("input.ui-state-default[name='create']").scrollToCenter().waitAndClick();
        GeneralUtil.waitForDomStable();
        GeneralUtil.waitForDomStable();
        return this;
    }

    public ApproveLoanPage clickApproveBtn() {
        el("input.ui-state-default[name='approve']").scrollToCenter().waitAndClick();
        return this;
    }

    public ApproveLoanPage clickRejectBtn() {
        el("input[name='reject']").scrollToCenter().waitAndClick();
        return this;
    }

    public FluentList<FluentWebElement> getUnApprovedLoans() {
        return find("table#loan-proposal-grid tbody tr[id]");
    }

    public UnApproveLoanItem getFirstLoanItem() {
        return getUnApprovedLoans().first().as(UnApproveLoanItem.class);
    }

    public enum Operation {
        APPROVE("Approve"),
        REJECT("Reject");
        private String name;

        Operation(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}


