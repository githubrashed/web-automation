package net.brac.web.fluentlenium.test.microfinance.loan;

import net.brac.web.fluentlenium.component.microfinance.loan.LoanItem;
import net.brac.web.fluentlenium.page.microfinance.loan.proposal.ApprovedLoanListPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.enums.Project;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApprovedLoanListTest extends BaseAuthenticatedTest {
    @Override
    protected Credential credential() {
        return erpCredential();
    }

    @Test
    public void approvedLoanShouldBeFirst() {
        String amount = "15000";
        ApprovedLoanListPage approvedLoanListPage = goTo(ApprovedLoanListPage.class);
        approvedLoanListPage = approvedLoanListPage
                .selectProject(Project.PROGOTI.getValue())
                .clickSearchBtn();
        LoanItem approvedLoanItem = approvedLoanListPage
                .getFirstApprovedLoanItem();
        String productFromList = approvedLoanItem.getProduct();
        String amountFromList = approvedLoanItem.getLoanAmount();
        assertThat(amountFromList).isEqualTo(amount);


    }
}
