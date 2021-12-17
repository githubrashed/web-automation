package net.brac.web.fluentlenium.page.microfinance.loan.proposal;

import net.brac.web.fluentlenium.component.microfinance.loan.proposal.UnApproveLoanItem;
import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import net.brac.web.fluentlenium.util.GeneralUtil;
import org.apache.commons.lang3.StringUtils;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.concurrent.TimeUnit;

public class ApproveLoanPage extends BaseMicroFinancePage<ApproveLoanPage> {
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
        return "/mfDashboard#!/loanApproval/unApprovedLoanList";
    }

    public ApproveLoanPage clearFromDate() {
        el("input#fromDate").scrollToCenter().clear();
        return this;
    }

    public ApproveLoanPage clearToDate() {
        el("input#toDate").scrollToCenter().clear();
        return this;
    }

    public ApproveLoanPage clickSearchBtn() {
        el("input.ui-state-default[name='create']").scrollToCenter().waitAndClick();
        GeneralUtil.waitForDomStable();
        GeneralUtil.waitForDomStable();
        return this;
    }

    public ApproveLoanPage clickApproveBtn() {
        el("input.ui-state-default[name='approve']").scrollToCenter().waitAndClick();
        return this;
    }

    public ApproveLoanPage clickRejectBtn() {
        el("input[name='reject']").scrollToCenter().waitAndClick();
        return this;
    }

    public FluentList<FluentWebElement> getUnApprovedLoans() {
        return find("table#loan-proposal-grid tbody tr[id]");
    }

    public UnApproveLoanItem getFirstLoanItem() {
        return getUnApprovedLoans().first().as(UnApproveLoanItem.class);
    }

    public int getUnApprovedLoan() {
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).untilPage().isLoaded();
        GeneralUtil.waitForDomStable();
        if (getUnApprovedLoans().count() > 0) {
            String paginationInfo = el("div.ui-paging-info").text().trim();
            if (StringUtils.getDigits(paginationInfo).length() > 0) {
                paginationInfo = paginationInfo.replaceAll("[^\\d ]", "");
                String numbers[] = paginationInfo.split("\\ ");
                return Integer.parseInt(numbers[numbers.length - 1].trim());
            } else {
                return getUnApprovedLoans().count();
            }
        } else {
            return getUnApprovedLoans().count();
        }
    }

    public enum Operation {
        APPROVE("Approve"),
        REJECT("Reject");
        private String name;

        Operation(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}


