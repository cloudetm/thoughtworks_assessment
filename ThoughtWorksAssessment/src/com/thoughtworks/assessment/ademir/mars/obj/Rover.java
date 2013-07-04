package com.thoughtworks.assessment.ademir.mars.obj;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.assessment.ademir.mars.constants.MarsConstants;

/**
 * Object used to represent the Rover
 * 
 * @author Ademir Constantino
 */
public class Rover implements MarsConstants {
	
	//current x and y positions
	private Integer xPosition;
	private Integer yPosition;
	// rover direction
	private Integer direction;
	// commands sent by NASA
	private List<Character> commandList;
	
	/**
	 * Default constructor for this class
	 * 
	 * @param xPosition The initial xPosition on the grid
	 * @param yPosition the initial yPosition on the grid
	 * @param direction The plateau information
	 */
	public Rover(Integer xPosition, Integer yPosition,Integer direction) {
		
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.direction = direction;
		this.commandList = new ArrayList<Character>();
	}

	/**
	 * Getter method
	 * @return the current x position
	 */
	public Integer getXPosition() {
		return xPosition;
	}

	/**
	 * Setter method
	 * 
	 * @param position Integer containing the new x position
	 */
	public void setXPosition(Integer position) {
		xPosition = position;
	}

	/**
	 * Getter method
	 * @return the current y position
	 */
	public Integer getYPosition() {
		return yPosition;
	}

	/**
	 * Setter method
	 * 
	 * @param position Integer containing the new x position
	 */
	public void setYPosition(Integer position) {
		yPosition = position;
	}

	/**
	 * Method referent to the rover commands
	 * controlled by the TWPlateaugrid
	 */
	public void moveForward() {
		
		// in this method we could validate the max(x,y) containing on the grid
		// however I did not do because it was not requested on the documentation
		
		if(direction == DIRECTION_NORTH) {
			yPosition++;
		} else if(direction == DIRECTION_SOUTH) {
			yPosition--;
		} else if(direction == DIRECTION_EAST) {
			xPosition++;
		} else if(direction == DIRECTION_WEST) {
			xPosition--;
		}
		
	}

	/**
	 * Method referent to the rover commands
	 * controlled by the TWPlateaugrid
	 */
	public void rotateLeft() {
		
		if(direction == DIRECTION_NORTH) {
			direction = DIRECTION_WEST;
		} else if(direction == DIRECTION_SOUTH) {
			direction = DIRECTION_EAST;
		} else if(direction == DIRECTION_EAST) {
			direction = DIRECTION_NORTH;
		} else if(direction == DIRECTION_WEST) {
			direction = DIRECTION_SOUTH;
		}
		
	}

	/**
	 * Method referent to the rover commands
	 * controlled by the TWPlateaugrid
	 */
	public void rotateRight() {
		
		if(direction == DIRECTION_NORTH) {
			direction = DIRECTION_EAST;
		} else if(direction == DIRECTION_SOUTH) {
			direction = DIRECTION_WEST;
		} else if(direction == DIRECTION_EAST) {
			direction = DIRECTION_SOUTH;
		} else if(direction == DIRECTION_WEST) {
			direction = DIRECTION_NORTH;
		}
		
	}
	
	/**
	 * Helper method used for transforming its
	 * magic numbers 
	 * @see com.thoughtworks.assessment.ademir.mars.constants.MarsConstants
	 * 
	 * @return String containing the plateau direction
	 */
	public String getDirectionAsString() {
		if(direction == DIRECTION_NORTH) {
			return "N";
		} else if(direction == DIRECTION_SOUTH) {
			return "S";
		} else if(direction == DIRECTION_EAST) {
			return "E";
		} else if(direction == DIRECTION_WEST) {
			return "W";
		} else {
			return "";
		}
	}

	/**
	 * Getter method
	 * 
	 * @return java.lang.Integer
	 */
	public Integer getDirection() {
		return direction;
	}

	/**
	 * Setter method
	 * @param direction the new direction
	 * @see com.thoughtworks.assessment.ademir.mars.constants.MarsConstants
	 */
	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	/**
	 * Getter method responsible for returning the rover command list sent by NASA
	 * 
	 * @return List containing a collection of Characters
	 */
	public List<Character> getCommandList() {
		return commandList;
	}

	/**
	 * Setter method
	 * 
	 * @param commandList the new command list
	 */
	public void setCommandList(List<Character> commandList) {
		this.commandList = commandList;
	}
	
}
