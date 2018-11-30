package pageclasses;

import BaseClasses.BaseTest;

public class ProjectTeam extends BaseTest
{

	public void fn_AddNewTeamMemeber ( String startdate, String releasedate ) {
		click("AddMoreBTN_XPATH");
		Select("TeamMember_XPATH", Config.getProperty("teammembername"));
		type("RoleTB_XPATH", "Developer");
		dateselect("EngageDate_XPATH", startdate);
		dateselect("ExRelasedate_XPATH", releasedate);
		click("UpdateButton_XPATH");
	}

	
}
