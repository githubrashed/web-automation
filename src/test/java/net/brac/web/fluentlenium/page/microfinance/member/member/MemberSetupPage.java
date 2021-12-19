package net.brac.web.fluentlenium.page.microfinance.member.member;

import com.thedeanda.lorem.LoremIpsum;
import net.brac.web.fluentlenium.page.microfinance.BaseMicroFinancePage;
import net.brac.web.fluentlenium.util.GeneralUtil;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.concurrent.TimeUnit;

public class MemberSetupPage extends BaseMicroFinancePage<MemberSetupPage> {
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
        return "/mfDashboard#!/memberInfo/index";
    }

    public MemberSetupPage selectCategory(String value) {
        el("select#memberClassificationId").scrollToCenter().fillSelect().withValue(value);
        return this;
    }

    public MemberSetupPage selectSalutation(int index) {
        el("select[id='personalInfoDomain.salutationId']").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public MemberSetupPage fillFirstName(String firstName) {
        el("#fName").scrollToCenter().fill().with(firstName);
        return this;
    }

    public MemberSetupPage fillMiddleName(String middleName) {
        el("input#mName").scrollToCenter().fill().with(middleName);
        return this;
    }

    public MemberSetupPage fillLastName(String lastName) {
        el("input#lName").scrollToCenter().fill().with(lastName);
        return this;
    }

    public MemberSetupPage selectGender(int index) {
        GeneralUtil.waitForDomStable();
        el("select#personalInfoDomainGenderId").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public MemberSetupPage fillDateOfBirth(String year) {
        el("input#personalInfoInstanceDateOfBirth").scrollToCenter().waitAndClick();
        el("div#ui-datepicker-div select.ui-datepicker-year").scrollToCenter().fillSelect().withText(year);
        el("#ui-datepicker-div .ui-state-default").scrollToCenter().waitAndClick();
        return this;
    }

    public MemberSetupPage fillNationalId(String nationalId) {
        el("input#nationalId").scrollToCenter().fill().withText(nationalId);
        return this;
    }

    public MemberSetupPage selectAssignedPo(int index) {
        el("select#assignedPO").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public MemberSetupPage selectMaritalStatus(int index) {
        el("select#personalInfoDomainMaritalStatusId").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public MemberSetupPage selectOccupation(int index) {
        el("select[id$='.occupationId']").scrollToCenter().fillSelect().withIndex(index);
        return this;
    }

    public MemberSetupPage fillFatherName(String fatherName) {
        el("#memberFatherName").scrollToCenter().fill().withText(fatherName);
        return this;
    }

    public MemberSetupPage fillMotherName(String motherName) {
        el("#memberMotherName").scrollToCenter().fill().withText(motherName);
        return this;
    }

    public MemberSetupPage selectMaritalStatus(String value) {
        el("select#personalInfoDomainMaritalStatusId").scrollToCenter().fillSelect().withValue(value);
        GeneralUtil.waitForDomStable();
        if (el("select#personalInfoDomainMaritalStatusId").el("select#personalInfoDomainMaritalStatusId option[value='" + value + "']").equals("Married")) {
            fillSpouseName(LoremIpsum.getInstance().getTitle(2));
            fillSpouseDateOfBirth("1988");
            fillSpouseNationalId(GeneralUtil.getNationalId());
            fillSpouseNationalId(GeneralUtil.getPassportNo());
            fillSpouseSmartCardId(GeneralUtil.getSmartCardId());
        }
        return this;
    }

    public MemberSetupPage fillSpouseName(String spouseName) {
        FluentWebElement fluentWebElement = el("input#personalInfoDomainSpouseName");
        fluentWebElement.scrollToCenter().scrollToCenter().fill().with(spouseName);
        return this;
    }

    public MemberSetupPage fillSpouseDateOfBirth(String year) {
        el("input#spouseDateOfBirth").scrollToCenter().waitAndClick();
        el("div#ui-datepicker-div select.ui-datepicker-year").scrollToCenter().fillSelect().withText(year);
        el("#ui-datepicker-div .ui-state-default").scrollToCenter().waitAndClick();
        return this;
    }

    public MemberSetupPage fillSpouseNationalId(String spouseNationalId) {
        el("input#spNationalId").scrollToCenter().fill().with(spouseNationalId);
        return this;
    }

    public MemberSetupPage fillSpouseSmartCardId(String spSmartCardId) {
        el("input#spSmartCardId").scrollToCenter().fill().with(spSmartCardId);
        return this;
    }

    public MemberSetupPage fillMobileNumber(String mobileNumber) {
        el("#contactNo").scrollToCenter().fill().withText(mobileNumber);
        return this;
    }

    public MemberSetupPage fillAddress(String address) {
        el("#address_0").scrollToCenter().fill().withText(address);
        return this;
    }

    public MemberSetupPage selectDistrict(int index) {
        FluentWebElement fluentWebElement = el("span[id^='city_0Div_arrow']");
        fluentWebElement.scrollToCenter().waitAndClick();
        waitForBlockOverlay();
        GeneralUtil.waitForDomStable();
        FluentList<FluentWebElement> fluentWebElements = find("div[id^='city_0Div_ctr'] div[id][class]");
        await().atMost(10, TimeUnit.SECONDS).until(fluentWebElements).size().greaterThanOrEqualTo(1);
        fluentWebElements.get(index).scrollToCenter().waitAndClick();
        waitForBlockOverlay();
        return this;
    }

    public MemberSetupPage selectUpazila(int index) {
        FluentWebElement fluentWebElement = el("span[id^='thana_0Div_arrow']");
        fluentWebElement.scrollToCenter().waitAndClick();
        waitForBlockOverlay();
        GeneralUtil.waitForDomStable();
        FluentList<FluentWebElement> fluentWebElements = find("div[id^='thana_0Div_ctr'] div[id][class]");
        await().atMost(10, TimeUnit.SECONDS).until(fluentWebElements).size().greaterThanOrEqualTo(1);
        fluentWebElements.get(index).scrollToCenter().waitAndClick();
        waitForBlockOverlay();
        return this;
    }

    public MemberSetupPage fillZipCode(String zipCode) {
        el("input#zipCode_0").scrollToCenter().fill().withText(zipCode);
        return this;
    }

    public MemberSetupPage clickSameAsPresentAddress() {
        el("#isSameAsPresentAddress").scrollToCenter().waitAndClick();
        await().untilPage().isLoaded();
        return this;
    }

    public MemberSetupPage selectSavingsProduct(int index) {
        waitForBlockOverlay();
        el("select#savingsProductId").scrollToCenter().fillSelect().withIndex(index);
        waitForBlockOverlay();
        return this;
    }

    public MemberSetupPage fillNewTargetAmount() {
        el("input#targetAmount").scrollToCenter().fill().withText("9999");
        return this;
    }

    public MemberDetailPage clickSaveBtn() {
      waitForBlockOverlay();
        el("input#saveButtonId").scrollToCenter().waitAndClick();
        GeneralUtil.waitForDomStable();
        return newInstance(MemberDetailPage.class);
    }

}
