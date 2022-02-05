package net.brac.web.fluentlenium.test.microfinance.loan.collection;

import net.brac.web.fluentlenium.page.microfinance.loan.collection.MemberLoanCollectionProgotiPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.enums.Project;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberLoanCollectionProgotiTest extends BaseAuthenticatedTest {

    protected String memberNumber = "36";

    @Override
    protected Credential credential() {
        return erpCredential();
    }

    @Test
    public void memberLoanCollectionShouldSucceed() {
        MemberLoanCollectionProgotiPage memberLoanCollectionProgotiPage = goTo(MemberLoanCollectionProgotiPage.class);
        memberLoanCollectionProgotiPage = memberLoanCollectionProgotiPage
                .selectProject(Project.PROGOTI.getValue())
//                .clickMemberNumber()
                .fillMemberNumber(memberNumber)
                .selectAccountNo(1)
                .clickCashRadioBtn()
                .fillMemberPayment(500)
                .selectCollectedBy(1)
                .clickSaveBtn();
        assertThat(memberLoanCollectionProgotiPage.hasAlertSuccess()).isTrue();
    }
}
