package net.brac.web.fluentlenium.test.microfinance.member;

import com.thedeanda.lorem.LoremIpsum;
import net.brac.web.fluentlenium.page.microfinance.member.MemberDetailPage;
import net.brac.web.fluentlenium.page.microfinance.member.MemberListPage;
import net.brac.web.fluentlenium.page.microfinance.member.MemberSetupPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.GeneralUtil;
import net.brac.web.fluentlenium.util.enums.Project;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.Objects;

public class MemberSetupTest extends BaseAuthenticatedTest {
    private Project projectProgoti = Project.PROGOTI;
    public String erpMemberNo = "";
    protected String memberNo = "";

    @Override
    protected Credential credential() {
        return erpCredential();
    }

    @Test
    public void progotiMemberSetupShouldSucceed() {
        memberSetupPage(projectProgoti);
    }

    public void memberSetupPage(Project project) {
        String firstName = LoremIpsum.getInstance().getTitle(2);
        String fatherName = LoremIpsum.getInstance().getTitle(2);
        String motherName = LoremIpsum.getInstance().getTitle(2);
        MemberDetailPage memberDetailPage;
        MemberSetupPage memberSetupPage = goTo(MemberSetupPage.class);
        if (Objects.equals(project, Project.PROGOTI)) {
            memberSetupPage = memberSetupPage
                    .selectProject(project.getValue())
                    .selectCategory("1")
                    .selectSalutation(1)
                    .fillFirstName(firstName)
                    .fillMiddleName(fatherName)
                    .fillLastName(motherName)
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
            memberDetailPage = memberSetupPage
                    .clickSaveBtn();
//            memberDetailPage=memberDetailPage;
            assertThat(memberDetailPage.hasAlertSuccess()).isTrue();
            erpMemberNo = memberDetailPage.getId();
            System.out.println("ERP Member No:" + erpMemberNo);
//            assertThat(memberDetailPage.hasText(memberDetailPage.getErpMemberId())).isTrue();
            MemberListPage memberListPage = goTo(MemberListPage.class);
            memberListPage = memberListPage
                    .selectProject(Project.PROGOTI.getValue())
                    .fillErpMemberNumber(erpMemberNo)
                    .clickSaveBtn();
            memberNo = memberListPage.getMemberAt(0).getMemberNumber();
            System.out.println("ERP Member No:" + erpMemberNo);
            System.out.println(" Member No:" + memberNo);

        }
    }
}