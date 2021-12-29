package net.brac.web.fluentlenium.test.microfinance.loan.disbursement;

import net.brac.web.fluentlenium.page.microfinance.loan.disbursement.LoanDisbursementPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.enums.Project;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanDisbursementTest extends BaseAuthenticatedTest {
    @Override
    protected Credential credential() {
        return erpCredential();
    }

    @Test
    public void loanDisbursementShouldSucceed() {
        LoanDisbursementPage loanDisbursementPage = goTo(LoanDisbursementPage.class);
        loanDisbursementPage=loanDisbursementPage
                .selectProject(Project.PROGOTI.getValue())
                .clickSearchBtn()
                .getFirstLoanItem()
                .clickDisburseBtn()
                .submitDisburse();
        assertThat(loanDisbursementPage.hasAlertSuccess()).isTrue();
    }
}
