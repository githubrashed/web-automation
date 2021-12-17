package net.brac.web.fluentlenium.page.microfinance.loan.proposal;

import net.brac.web.fluentlenium.component.microfinance.loan.LoanItem;
import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

public class LoanProposalListPage extends BaseMicroFinancePage<LoanProposalListPage> {
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
        return "mfDashboard#!/loanProposal/list";
    }

    public LoanProposalListPage selectProposalStatus(String text) {
        el("select#loanStatusId").fillSelect().withText(text);
        return this;
    }

    public LoanProposalListPage clickSearchBtn() {
        el("input[type='button']").scrollToCenter().waitAndClick();
        return this;
    }

    public FluentList<FluentWebElement> getLoanProposals() {
        return find("table#list2 tbody tr[id]");
    }

    public LoanItem getFirstLoanProposalItem() {
        return getLoanProposals().first().as(LoanItem.class);
    }
    
}