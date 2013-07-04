package init;
import java.awt.Point;
import java.util.List;

import com.thoughtworks.assessment.ademir.mars.filesupport.MarsFileSupport;
import com.thoughtworks.assessment.ademir.mars.obj.Rover;
import com.thoughtworks.assessment.ademir.mars.obj.TWPlateauGrid;


public class MarsInit {
	
	public static void main(String[] args) throws Exception {
		
		MarsFileSupport mfs = new MarsFileSupport();
		Point max = mfs.getPlateauCoordinates();
		List<Rover> roverList = mfs.getRoverListFromFile();
		TWPlateauGrid grid = new TWPlateauGrid(max.x,max.y);
		grid.execute(roverList);
		
	}

}
