package com.thoughtworks.assessment.ademir.mars.obj;

import java.util.List;

/**
 * Class reffering to the Mars Grid as requested on the documentation
 * 
 * @author Ademir Constantino
 */
public class TWPlateauGrid {
	
	private Integer upperTop;
	private Integer upperRight;
	private final static Integer leftBottom = 0;
	private final static Integer lowerLeft = 0;
	
	/**
	 * Default constructor
	 * 
	 * @param upperTop the max(y) position
	 * @param upperRight the max (x) position
	 */
	public TWPlateauGrid(Integer upperTop, Integer upperRight) {
		this.upperTop = upperTop;
		this.upperRight = upperRight;
	}
	
	/**
	 * Method responsible for executing the rover actions
	 * 
	 * @param roverList a list containing the rover objects
	 */
	public void execute(List<Rover> roverList) {
		
		for(Rover rover: roverList) {
			
			for(Character command: rover.getCommandList()) {
				
				switch(command) {
				
					case 'L':
						rover.rotateLeft();
						break;
					
					case 'M':
						rover.moveForward();
						break;
					
					case 'R':
						rover.rotateRight();
						break;
				
				}
				
			}
			
			System.out.println(rover.getXPosition() + " " +
						rover.getYPosition() + " " +
							rover.getDirectionAsString());
			
		}
		
	}

	/**
	 * Getter method
	 * 
	 * @return java.lang.Integer
	 */
	public Integer getUpperTop() {
		return upperTop;
	}

	/**
	 * Setter method
	 * 
	 * @param upperTop The new max (y) poisition
	 */
	public void setUpperTop(Integer upperTop) {
		this.upperTop = upperTop;
	}

	/**
	 * Getter method
	 * 
	 * @return java.lang.Integer
	 */
	public Integer getUpperRight() {
		return upperRight;
	}

	/**
	 * Setter method
	 * 
	 * @param upperRight The new (x) position
	 */
	public void setUpperRight(Integer upperRight) {
		this.upperRight = upperRight;
	}

	/**
	 * Getter method
	 * 
	 * @return java.lang.Integer
	 */
	public static Integer getLeftBottom() {
		return leftBottom;
	}

	/**
	 * Getter method
	 * @return java.lang.Integer
	 */
	public static Integer getLowerLeft() {
		return lowerLeft;
	}

}
