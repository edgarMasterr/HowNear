package com.iwantthisnear.tool;

/**
 * This class handles the variables used on this the project. 
 * @author Edgar Roman
 *
 */

public class NearVariables {

	/**
	 * Xpaht variable Address of reference
	 */
	public static String address1;
	/**
	 * Xpaht variable Address of destination
	 */
	public static String address2;
	/**
	 * Xpaht variable for button of the distance
	 */
	public static String buttonDistance;
	/**
	 * Xpaht variable for the label with the distance
	 */
	public static String fullLabelDistance;
	
	
	/**
	 * Method which has the Xpaths used in the current project
	 */
	public NearVariables() {
		address1 = "//*[@id=\"fromInput\"]";
		address2 = "//*[@id=\"toInput\"]";
		buttonDistance = "/html/body/div[1]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/span/form/a";
		fullLabelDistance = "//*[@id=\"driving_status\"]";
	}
	
	/**
	 * Method which has the address which is a constant in this project
	 * @return Address of reference
	 */
	
	public static String setAddress1() {
		String myAddress1 = "9032 Washingtond Dr, Des Plains, IL, 60016";
		return myAddress1;
	}

}
