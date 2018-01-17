package com.isat.common;

public class SQLConstants {

	public static String IS_VALID_USER = "SELECT * FROM TEMP_INCIDENT_USER WHERE USERNAME = ? AND PASSWORD = ?";

	//public static String IS_VALID_USER_ROLE = "SELECT * FROM TEMP_INCIDNET_ROLE WHERE ROLE_ID ( SELECT ROLE_ID FROM TEMP_INCIDENT_USER_ROLE WHERE USER_ID=?)";

	//public static String IS_VALID_OFFER_ROLE = "select DISTINCT(OFFER_ID) from  where ROLE_ID IN (select ROLE_ID from TEMP_INCIDENT_USER_ROLE where USER_ID=(select user_id from TEMP_INCIDENT_USER where username=?))";
	public static String VALID_URLOFFER_ROLE = "select DISTINCT(b.OFFER_NAME) from TEMP_ROLE_BASED_OFFER a , TEMP_INCIDENT_OFFER b where a.OFFER_ID = b.OFFER_ID and A.ROLE_ID IN (select ROLE_ID from TEMP_INCIDENT_USER_ROLE where USER_ID=?)";
}
