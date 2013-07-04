package com.thoughtworks.assessment.ademir.mars.filesupport;

import init.MarsInit;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.assessment.ademir.mars.constants.MarsConstants;
import com.thoughtworks.assessment.ademir.mars.exception.MarsFileAccessException;
import com.thoughtworks.assessment.ademir.mars.obj.Rover;

/**
 * Class responsible for accessing the text file containing
 * the rover information and transforming it to a Rover object list
 * 
 * @author Ademir Constantino
 */
public class MarsFileSupport {
	
	private File currentFile;
	private FileReader fileReader;
	private BufferedReader bfReader;
	
	/**
	 * Method responsible for initializing the file
	 * using the constant defined on MarsConstants
	 * (This file has to be on the $APPLICATION/init folder)
	 */
	public void begin() {
		currentFile = getFile(MarsConstants.APPLICATION_FILENAME);
	}
	
	/**
	 * Method responsible for instantiating the file object
	 * 
	 * @param fileName File name located on the /init folder
	 * @return java.io.File object
	 */
	public File getFile(String fileName) {
		// MAKE SURE YOU FILE WAS SAVED IN THE APPLICATION CLASSPATH
		File file = new File(MarsInit.class.getResource(fileName).getPath());
		return file;
	}
	
	/**
	 * Method responsible for creating the file reader object
	 * 
	 * @return a java.io.FileReader object referring to the file previously defined
	 * @throws MarsFileAccessException If any error occurs
	 */
	public FileReader getFileReader() throws MarsFileAccessException {
		if(currentFile == null)
			begin();
		try {
			fileReader = new FileReader(currentFile);
		} catch(FileNotFoundException fnfe) {
			throw new MarsFileAccessException(fnfe.getMessage());
		}
		
		return fileReader;
	}
	
	/**
	 * Method responsible for getting the first line information of file
	 * and creating the Plateau coordinates
	 * 
	 * @return java.awt.Point containing the max(x) position and max(y) position
	 * @throws MarsFileAccessException If any error occurs
	 */
	public Point getPlateauCoordinates() throws MarsFileAccessException {
		
		if(currentFile == null)
			begin();
		
		fileReader = this.getFileReader();
		bfReader = new BufferedReader(fileReader);

		try {
			String plateauCoordinates = bfReader.readLine().trim();
			
			Point coordinates = new Point(new Integer(plateauCoordinates.substring(0, 1)),
						new Integer(plateauCoordinates.substring(2, 3)));
			
			return coordinates;
			
			} catch (IOException ioe) {
				throw new MarsFileAccessException(ioe.getMessage());
			}
	}
	
	/**
	 * Method responsible for transforming the application
	 * text file to a rover object list containing its respective
	 * commands
	 * 
	 * @return java.util.List containing Rover objects
	 * @throws MarsFileAccessException If an file access or I/O error occurs
	 */
	public List<Rover> getRoverListFromFile() throws MarsFileAccessException {
		
		try {
			
			ArrayList<Rover> returnList = new ArrayList<Rover>();
			String roverData = bfReader.readLine();
			
			while(roverData != null) {
				
				String roverCommands = bfReader.readLine();
				if(roverCommands == null) {
					break;
				}
				
				Integer x = new Integer(roverData.substring(0, 1));
				Integer y = new Integer(roverData.substring(2, 3));
				String orientation = roverData.substring(4, 5);
				
				Integer orienInteger = 0;
				if(orientation.equals("N")) {
					orienInteger = MarsConstants.DIRECTION_NORTH;
				} else if(orientation.equals("S")) {
					orienInteger = MarsConstants.DIRECTION_SOUTH;
				} else if(orientation.equals("E")) {
					orienInteger = MarsConstants.DIRECTION_EAST;
				} else if(orientation.equals("W")) {
					orienInteger = MarsConstants.DIRECTION_WEST;
				}
				
				Rover newRover = new Rover(x, y, orienInteger);
				
				returnList.add(newRover);
				
				char[] commmands = roverCommands.toCharArray();
				
				
				for(Character c: commmands) {
					newRover.getCommandList().add(c);
				}
				
				roverData = bfReader.readLine();
			}
			
			bfReader.close();
			fileReader.close();
			
			return returnList;
					
			} catch (IOException ioe) {
				throw new MarsFileAccessException(ioe.getMessage());
			}
	}

}
