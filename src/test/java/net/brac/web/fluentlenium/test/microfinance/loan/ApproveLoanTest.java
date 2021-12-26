package net.brac.web.fluentlenium.test.microfinance.loan;

import net.brac.web.fluentlenium.page.microfinance.loan.proposal.ApproveLoanPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.enums.Project;
import org.testng.annotations.Test;

public class ApproveLoanTest extends BaseAuthenticatedTest {
    @Override
    protected Credential credential() {
        return erpCredential();
    }

    @Test
    public void approvedLoanShouldSucceed() {
        ApproveLoanPage approveLoanPage = goTo(ApproveLoanPage.class);
        approveLoanPage
                .selectProject(Project.PROGOTI.getValue())
                .clickSearchBtn()
                .getFirstLoanItem()
                .selectLoan()
                .selectApprover("AM");
        approveLoanPage = approveLoanPage
                .clickApproveBtn();
    }
}
