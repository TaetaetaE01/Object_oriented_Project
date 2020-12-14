package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import valueObject.VDirectory;

public class CDirectory {

	public CDirectory() {
	}
	
	public Vector<VDirectory> getData(String fileName) {
		DataAccessObject dataAccessObject = new DataAccessObject();
		Vector<MDirectory> mDirectories = dataAccessObject.getDirectories(fileName);
		
		Vector<VDirectory> vDrectories = new Vector<VDirectory>();
		for (MDirectory mDirectory: mDirectories) {
			VDirectory vDirectory = new VDirectory(
				mDirectory.getName(),
				mDirectory.getFileName()
			);
			vDrectories.add(vDirectory);
		}		
		return vDrectories;
	}

}
