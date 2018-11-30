package pageclasses;

import BaseClasses.BaseTest;

public class ProjectTeam extends BaseTest
{

	public void fn_AddNewTeamMemeber (String TeamMember, String Role, String startdate, String releasedate ) {
		click("AddMoreBTN_XPATH");
		Select("TeamMember_XPATH", TeamMember);
		type("RoleTB_XPATH", Role );
		dateselect("EngageDate_XPATH", startdate);
		dateselect("ExRelasedate_XPATH", releasedate);
		click("UpdateButton_XPATH");
	}

	
}
