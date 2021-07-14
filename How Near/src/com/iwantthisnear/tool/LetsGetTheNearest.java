package com.iwantthisnear.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * It initiates the program
 * @author Edgar Roman
 *
 */

public class LetsGetTheNearest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String addressBrowser = "https://www.mapdevelopers.com/distance_from_to.php";
		
		//Flat file with addresses is read and put on an Array
		FileHandle fhdl = new FileHandle();
		
		
		ArrayList<String> myAddressList = new ArrayList<String>();
		myAddressList = fhdl.readFlatFile();
				
		FormCommands obj1 = new FormCommands();

		obj1.createChromeDriver();
		obj1.openBrowser(addressBrowser);
		obj1.setAddres1();
		
		//create a List of two dimensions to store address and distance
		List<List<String>> distanceAddress = new ArrayList<List<String>>();
		distanceAddress.add(new ArrayList<String>());
		distanceAddress.add(new ArrayList<String>());
	
		ListIterator<String> iterator = myAddressList.listIterator();
		
		//With this, the distance for all address is estimated
		int i = 0;
		while (iterator.hasNext()) {
			obj1.setAddres2(myAddressList.get(i));
			obj1.clickEstimate();
			distanceAddress.get(0).add(myAddressList.get(i).trim());
			distanceAddress.get(1).add(obj1.getDistance().trim());
			obj1.cleanTextBox(NearVariables.address2);
			i++;
			iterator.next();
		}

		fhdl.createAndWriteFile(distanceAddress);
		System.out.println("Process Finished....");
	}

}
