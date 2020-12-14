package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import model.MGangjwa;
import valueObject.VDirectory;
import valueObject.VGangjwa;

public class CGangjwa {

	public CGangjwa() {
	}

	public Vector<VGangjwa> getData(String fileName) {
		DataAccessObject dataAccessObject = new DataAccessObject();
		Vector<MGangjwa> mGangjwas = dataAccessObject.getGangjwas(fileName);

		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
		for (MGangjwa mGangjwa : mGangjwas) {
			VGangjwa vGangjwa = new VGangjwa();
			vGangjwa.setId(mGangjwa.getId());
			vGangjwa.setName(mGangjwa.getName());
			vGangjwa.setLecturer(mGangjwa.getLecturer());
			vGangjwa.setCredit(mGangjwa.getCredit());
			vGangjwa.setTime(mGangjwa.getTime());

			vGangjwas.add(vGangjwa);
		}
		return vGangjwas;
	}

}
