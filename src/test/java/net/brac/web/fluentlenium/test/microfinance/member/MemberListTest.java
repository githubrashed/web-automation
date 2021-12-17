package net.brac.web.fluentlenium.test.microfinance.member;

import net.brac.web.fluentlenium.page.microfinance.member.member.MemberDetailPage;
import net.brac.web.fluentlenium.page.microfinance.member.member.MemberListPage;
import net.brac.web.fluentlenium.test.BaseAuthenticatedTest;
import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.enums.Project;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberListTest extends BaseAuthenticatedTest {
    @Override
    protected Credential credential() {
        return erpCredential();
    }

    @Test
    public void viewMemberInformShouldSucceed() {
        MemberListPage memberListPage = goTo(MemberListPage.class);
        memberListPage = memberListPage
                .selectProject(Project.PROGOTI.getValue())
                .clickSaveBtn();
        String erpMemberNumber = memberListPage.getFirstMember().getErpMemberNumber();
        String memberNumber = memberListPage.getFirstMember().getMemberNumber();
        String name = memberListPage.getFirstMember().getMemberName();
        String gender = memberListPage.getFirstMember().getGender();
        String status = memberListPage.getFirstMember().getStatus();
        MemberDetailPage memberDetailPage = memberListPage
                .getFirstMember()
                .clickErpMemberNumber();
        assertThat(memberDetailPage.hasText(erpMemberNumber)).isTrue();
        System.out.println(erpMemberNumber);
        assertThat(memberDetailPage.hasText(name)).isTrue();
        assertThat(memberDetailPage.hasText(gender)).isTrue();
        assertThat(memberDetailPage.hasText(status)).isTrue();
        System.out.println(status);
    }

}
