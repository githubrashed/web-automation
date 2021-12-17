package net.brac.web.fluentlenium.component.microfinance.loan.proposal;

import net.brac.web.fluentlenium.component.BaseComponent;
import net.brac.web.fluentlenium.page.microfinance.loan.disbursement.LoanDisbursementPage;
import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.openqa.selenium.WebElement;

public class ApprovedLoanItem extends BaseComponent {

    /**
     * Creates a new fluent web element.
     *
     * @param element      underlying element
     * @param control      control interface
     * @param instantiator component instantiator
     */
    public ApprovedLoanItem(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    public LoanDisbursementPage clickDisburseBtn() {
        el("[id^='action-button-'] input[type='button']").scrollToCenter().waitAndClick();
        return newInstance(LoanDisbursementPage.class);
    }
}
