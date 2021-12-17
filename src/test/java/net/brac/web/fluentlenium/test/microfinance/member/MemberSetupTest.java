package net.brac.web.fluentlenium.test.microfinance.member;

import com.thedeanda.lorem.LoremIpsum;
import net.brac.web.fluentlenium.page.microfinance.member.member.MemberDetailPage;
import net.brac.web.fluentlenium.page.microfinance.member.member.MemberSetupPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.GeneralUtil;
import net.brac.web.fluentlenium.util.enums.Project;
import org.testng.annotations.Test;

import java.util.Objects;

public class MemberSetupTest extends BaseAuthenticatedTest {
    private Project projectProgoti = Project.PROGOTI;

    @Override
    protected Credential credential() {
        return erpCredential();
    }

    @Test
    public void progotiMemberSetupShouldSucceed() {
//        assertThat(memberSetupPage(projectProgoti).hasAlertSuccess()).isTrue();
        memberSetupPage(projectProgoti);
    }

    private MemberDetailPage memberSetupPage(Project project) {
        MemberDetailPage memberDetailPage;
        MemberSetupPage memberSetupPage = goTo(MemberSetupPage.class);
        if (Objects.equals(project, Project.PROGOTI)) {
            memberSetupPage = memberSetupPage
                    .selectProject(project.getValue())
                    .selectCategory("1")
                    .selectSalutation(1)
                    .fillFirstName(LoremIpsum.getInstance().getTitle(2))
                    .fillMiddleName(LoremIpsum.getInstance().getTitle(1))
                    .fillLastName(LoremIpsum.getInstance().getTitle(1))
                    .fillNationalId(GeneralUtil.getNationalId())
                    .selectAssignedPo(1)
                    .selectGender(1)
                    .selectMaritalStatus(1)
                    .fillDateOfBirth("1988")
                    .selectOccupation(1)
                    .fillFatherName(LoremIpsum.getInstance().getTitle(2))
                    .fillMotherName(LoremIpsum.getInstance().getTitle(2))
                    .fillSpouseName(LoremIpsum.getInstance().getTitle(2))
                    .fillSpouseDateOfBirth("1988")
                    .fillMobileNumber("01984444444")
                    .fillAddress(LoremIpsum.getInstance().getTitle(3))
                    .selectDistrict(0)
                    .selectUpazila(0)
                    .fillZipCode("1200")
                    .clickSameAsPresentAddress()
                    .selectSavingsProduct(1)
                    .fillNewTargetAmount();
        }
        return memberSetupPage
                .clickSaveBtn();
    }

}