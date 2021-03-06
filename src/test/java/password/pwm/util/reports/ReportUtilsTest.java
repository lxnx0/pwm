package password.pwm.util.reports;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import password.pwm.svc.report.ReportColumnFilter;

public class ReportUtilsTest {

    @Test
    public void testToReportColumnFilter() {
        String desiredColumns = "username,userDN,ldapProfile,userGUID,accountExpirationTime,passwordExpirationTime,passwordChangeTime,responseSetTime,lastLoginTime,hasResponses,hasHelpdeskResponses,responseStorageMethod,responseFormatType,requiresPasswordUpdate,requiresResponseUpdate,requiresProfileUpdate,cacheTimestamp";
        ReportColumnFilter reportColumnFilter = ReportUtils.toReportColumnFilter(desiredColumns);

        // Verify the column name string gets translated into a ReportColumnFilter correctly:
        assertThat(reportColumnFilter.isUserDnVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isLdapProfileVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isUsernameVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isUserGuidVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isAccountExpirationTimeVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isLastLoginTimeVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isPasswordExpirationTimeVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isPasswordChangeTimeVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isResponseSetTimeVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isHasResponsesVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isHasHelpdeskResponsesVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isResponseStorageMethodVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isResponseFormatTypeVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isRequiresPasswordUpdateVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isRequiresResponseUpdateVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isRequiresProfileUpdateVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isCacheTimestampVisible()).isEqualTo(true);

        assertThat(reportColumnFilter.isEmailVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isPasswordStatusExpiredVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isPasswordStatusPreExpiredVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isPasswordStatusViolatesPolicyVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isPasswordStatusWarnPeriodVisible()).isEqualTo(false);
    }

    @Test
    public void testToReportColumnFilter2() {
        String desiredColumns = "username,email,passwordStatusExpired,passwordStatusPreExpired,passwordStatusViolatesPolicy,passwordStatusWarnPeriod";
        ReportColumnFilter reportColumnFilter = ReportUtils.toReportColumnFilter(desiredColumns);

        // Verify the column name string gets translated into a ReportColumnFilter correctly:
        assertThat(reportColumnFilter.isUsernameVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isEmailVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isPasswordStatusExpiredVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isPasswordStatusPreExpiredVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isPasswordStatusViolatesPolicyVisible()).isEqualTo(true);
        assertThat(reportColumnFilter.isPasswordStatusWarnPeriodVisible()).isEqualTo(true);

        assertThat(reportColumnFilter.isUserDnVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isLdapProfileVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isUserGuidVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isAccountExpirationTimeVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isLastLoginTimeVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isPasswordExpirationTimeVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isPasswordChangeTimeVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isResponseSetTimeVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isHasResponsesVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isHasHelpdeskResponsesVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isResponseStorageMethodVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isResponseFormatTypeVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isRequiresPasswordUpdateVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isRequiresResponseUpdateVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isRequiresProfileUpdateVisible()).isEqualTo(false);
        assertThat(reportColumnFilter.isCacheTimestampVisible()).isEqualTo(false);
    }

}
