package com.iwantthisnear.tool;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;


/**
 * This class handles the process with files to find the nearest place.
 * @author Edgar Roman
 * @version 1.0
 * 
 */

public class FileHandle {
	
	/**
	 * Reads the flat file from a specify path in drive C. It also open the file called ontherock.txt which is 
	 * in the specify path. 
	 * @return an Array List of addresses to estimate distance. Each row of this list has three 
	 * elements separated by comma <BR>
	 * First element is the address <BR>
	 * Second element is the city <BR>
	 * Third  element is the state <BR>
	 * @throws Two exceptions are handle
	 * File not found
	 * Error when the file is read
	 */
	
	public ArrayList<String> readFlatFile() {
		
		ArrayList<String> listAddresses = new ArrayList<String>();
		 // The name of the file to open.
		String addressesFile = "C:\\ontherocklist\\ontherocklist.txt";
		
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(addressesFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	//System.out.println("dentro del while" + j);
            	String[] words = line.split(",");
            	listAddresses.add(words[1] + "," + words[2] + "," + words[3]);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                 addressesFile + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + addressesFile + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		return listAddresses;		
	}
	
	/**
	 * It creates the final file which has two elements per row separated by pipe |. <BR>
	 * First element is the address <BR>
	 * Second element is the distance from the specified point in the code and this address <BR>
	 * This file is created on the specified path written in the code of this method. 
	 * The file PlacesAndDistances.txt is created on this method.
	 * @param distanceAddress List of two dimensions. First dimension has the address to be estimated 
	 * and the second dimension has the distance from the reference point to the address of destination.
	 * @throws Any problem to write the file.
	 */
	
	public void createAndWriteFile(List<List<String>> distanceAddress) {
		
		//Iterator creation to go through the List
		ListIterator<String> iterator = distanceAddress.get(0).listIterator();
		
		String todaysDate;
		String pathAndName;
		Calendar c = Calendar.getInstance();
		
		//Date for the file
		String month;
		String day;
		
		//System.out.println("dia del mes " + c.get(Calendar.DATE));
		//System.out.println("MES DEL AÑO " + c.get(Calendar.MONTH));
		//System.out.println(c.toString());
		
		if (c.get(Calendar.MONTH) < 10){
			month = "0" + Integer.toString(c.get(Calendar.MONTH));
		} else {
			month = Integer.toString(c.get(Calendar.MONTH));
		}
		
		if (c.get(Calendar.DATE) < 10){
			day = "0" + Integer.toString(c.get(Calendar.DATE));
		} else {
			day = Integer.toString(c.get(Calendar.DATE));
		}
		
		//Date for the file's name
		todaysDate = Integer.toString(c.get(Calendar.YEAR)) + month + day;
		//File creation
		pathAndName = "C:\\ontherocklist\\distances\\" + todaysDate + " PlacesAndDistances.txt";
		
		try {
            PrintWriter writer = new PrintWriter(pathAndName, "UTF-8");
            
    		int i = 0;
    		while (iterator.hasNext()) {
    			writer.println(distanceAddress.get(0).get(i) + "|" + distanceAddress.get(1).get(i));
    			i++;
    			iterator.next();
    		}
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
