package net.brac.web.fluentlenium.test.microfinance.smoketest;

import com.thedeanda.lorem.LoremIpsum;
import net.brac.web.fluentlenium.page.microfinance.member.MemberDetailPage;
import net.brac.web.fluentlenium.page.microfinance.member.MemberListPage;
import net.brac.web.fluentlenium.page.microfinance.member.MemberSetupPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.GeneralUtil;
import net.brac.web.fluentlenium.util.enums.Project;
import net.brac.web.fluentlenium.util.enums.Status;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeTest extends BaseAuthenticatedTest {
    private Project projectProgoti = Project.PROGOTI;
    public String erpMemberNumber = "";
    protected String memberNumber = "";
    protected String bKashWalleNo = "";

    @Override
    protected Credential credential() {
        return smokeSuiteCredential();
    }

   @Test
   public void progotiMemberSetupShouldSucceed(){
        memberSetup(projectProgoti);

   }

    public void memberSetup(Project project) {
        String firstName = LoremIpsum.getInstance().getTitle(1);
        String fatherName = LoremIpsum.getInstance().getTitle(2);
        String motherName = LoremIpsum.getInstance().getTitle(2);
        bKashWalleNo = GeneralUtil.getMobileNumber();
        String nationalId = GeneralUtil.getNationalId();
        String tim = GeneralUtil.getTinNumber();

        MemberDetailPage memberDetailPage;
        MemberSetupPage memberSetupPage = goTo(MemberSetupPage.class);
        GeneralUtil.waitForDomStable();
        if (Objects.equals(project, Project.PROGOTI)) {
            memberSetupPage = memberSetupPage
                    .selectProject(projectProgoti.getValue())
                    .selectCategory("1")
                    .selectSalutation(1)
                    .fillFirstName(firstName)
                    .fillMiddleName(LoremIpsum.getInstance().getTitle(1))
                    .fillLastName(LoremIpsum.getInstance().getTitle(1))
                    .selectAssignedPo(1);
            memberDetailPage = memberSetupPage
                    .fillNationalId(nationalId)
                    .selectGender(2)
                    .selectMaritalStatus(2)
                    .fillDateOfBirth("1985")
                    .selectOccupation(1)
                    .fillFatherName(fatherName)
                    .fillMotherName(motherName)
                    .fillMobileNumber(bKashWalleNo)
                    .fillAddress(LoremIpsum.getInstance().getTitle(3))
                    .selectDistrict(0)
                    .selectUpazila(0)
                    .fillZipCode("1200")
                    .clickSameAsPresentAddress()
                    .selectSavingsProduct(1)
                    .fillNewTargetAmount()
                    .clickSaveBtn();

            assertThat(memberDetailPage.hasAlertSuccess()).isTrue();
            erpMemberNumber = memberDetailPage.getId();
            System.out.println("Erp Member Number : " + erpMemberNumber);

            MemberListPage memberListPage = goTo(MemberListPage.class)
                    .selectProject(projectProgoti.getValue())
                    .fillErpMemberNumber(erpMemberNumber)
                    .selectMemberStatus(Status.ACTIVE.getName())
                    .clickSaveBtn();

            memberNumber = memberListPage.getFirstMember().getMemberNumber();
            System.out.println("Member Number : " + memberNumber);
            assertThat(memberListPage.getFirstMember().getErpMemberNumber()).isEqualTo(erpMemberNumber);
            assertThat(memberListPage.getFirstMember().getMemberName()).contains(firstName);
            assertThat(memberListPage.getFirstMember().getStatus()).isEqualTo(Status.ACTIVE.getName());
        }
    }
}
