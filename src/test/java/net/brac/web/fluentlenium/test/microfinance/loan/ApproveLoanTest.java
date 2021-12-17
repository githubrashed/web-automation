package net.brac.web.fluentlenium.test.microfinance.loan;

import net.brac.web.fluentlenium.page.microfinance.loan.proposal.ApproveLoanPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.enums.Project;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
                .clickSearchBtn();
        int unApprovedLoanBefore = approveLoanPage.getUnApprovedLoan();
        approveLoanPage
                .getFirstLoanItem()
                .selectLoan()
                .selectApprover("AM");
        approveLoanPage = approveLoanPage
                .clickApproveBtn();
        Assertions.assertThat(approveLoanPage.hasAlertSuccess()).isTrue();
        int unApprovedLoanAfter = goTo(ApproveLoanPage.class)
                .selectProject(Project.PROGOTI.getValue())
                .clickSearchBtn()
                .getUnApprovedLoan();
        assertThat(unApprovedLoanAfter).isLessThan(unApprovedLoanBefore);
    }
}
