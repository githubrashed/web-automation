package net.brac.web.fluentlenium.test.microfinance.loan;

import net.brac.web.fluentlenium.page.microfinance.loan.proposal.LoanProposalSetupPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.enums.Product;
import net.brac.web.fluentlenium.util.enums.Project;
import org.testng.annotations.Test;

public class LoanProposalSetupTest extends BaseAuthenticatedTest {
    protected String proposedAmount = "5000";
    protected String installmentAmount = "1425";
    private Product productDabi = Product.BD_10038;
    private Product productProgoti = Product.BD_10072;

    @Override
    protected Credential credential() {
        return erpCredential();
    }

    @Test
    public void loanProposalSetupShouldSucceed() {
        LoanProposalSetupPage loanProposalSetupPage = goTo(LoanProposalSetupPage.class);
        loanProposalSetupPage
                .selectProject(Project.PROGOTI.getValue())
                .clickMemberNumber()
                .selectProductByValue(productProgoti.getValue())
                .selectFrequencyByValue("1310")
                .selectSector(1)
                .selectScheme(1)
                .fillProposedAmount(proposedAmount)
                .fillInstallmentAmount(installmentAmount)
                .clickSaveBtn();
    }
}
