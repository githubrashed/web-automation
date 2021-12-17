package net.brac.web.fluentlenium.test.microfinance.loan;

import net.brac.web.fluentlenium.component.microfinance.loan.LoanItem;
import net.brac.web.fluentlenium.page.microfinance.loan.proposal.LoanProposalListPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.enums.Project;
import net.brac.web.fluentlenium.util.enums.Status;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanProposalListTest extends BaseAuthenticatedTest {
    @Override
    protected Credential credential() {
        return erpCredential();
    }

    public void searchPendingLoanProposalShouldSucceed() {
        LoanProposalListPage loanProposalListPage = goTo(LoanProposalListPage.class);
        loanProposalListPage
                .selectProject(Project.PROGOTI.getValue())
                .selectProposalStatus(Status.PENDING.getName())
                .clickSearchBtn();
        LoanItem loanProposalItem = loanProposalListPage
                .getFirstLoanProposalItem();
        String status = loanProposalItem.getLoanStatus();
        assertThat(status).isEqualTo(Status.PENDING.getName());

    }
}
