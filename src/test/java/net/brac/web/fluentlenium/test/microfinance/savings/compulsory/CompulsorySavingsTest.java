package net.brac.web.fluentlenium.test.microfinance.savings.compulsory;

import net.brac.web.fluentlenium.page.microfinance.savings.compulsory.IndividualSavingsCollectionPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.enums.Project;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompulsorySavingsTest extends BaseAuthenticatedTest {

    @Override
    protected Credential credential() {
        return erpCredential(
        );
    }

    @Test
    public void progotiIndividualSavingsCollectionViaCashShouldSucceed() {
        IndividualSavingsCollectionPage individualSavingsCollectionPage = goTo(IndividualSavingsCollectionPage.class)
                .selectProject(Project.PROGOTI.getValue())
                .clickMemberNumber()
                .fillDepositAmount("500")
                .clickCashRadioBtn()
                .clickSaveBtn();
        assertThat(individualSavingsCollectionPage.hasAlertSuccess()).isTrue();
    }
}
