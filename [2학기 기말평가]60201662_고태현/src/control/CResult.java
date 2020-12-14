package control;

import java.util.Vector;

import model.DataAccessObject;
import model.DataBase;
import model.MGangjwa;
import valueObject.VGangjwa;
import valueObject.VUserInfo;

public class CResult {

	public CResult() {

	}

	public void save(String fileName, Vector<VGangjwa> vGangjwas) {

		DataAccessObject dataAccessObject = new DataAccessObject();
		dataAccessObject.saveResults(fileName, vGangjwas);

	}

	public Vector<VGangjwa> get(String fileName) {
		DataAccessObject dataAccessObject = new DataAccessObject();
		Vector<MGangjwa> mGangjwas = dataAccessObject.getResults(fileName);

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
	
	public void create(String fileName) {
		DataBase database = new DataBase();
		database.create(fileName);
	}

	// save 미리담기
	public void save1(String fileName, Vector<VGangjwa> vGangjwas) {
		DataBase database = new DataBase();
		database.Save(fileName, vGangjwas);
	}

	// save 수강신청
	public void save2(String ID, Vector<VGangjwa> vGangjwas) {
		DataBase database = new DataBase();
		//database.sugangchincheongSave(ID, vGangjwas);
	}

	// read
	public Vector<VGangjwa> get1(String fileName) {
		DataBase database = new DataBase();
		Vector<VGangjwa> vGangjwas = database.read(fileName);

//		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
//		for (MGangjwa mGangjwa : mGangjwas) {
//			VGangjwa vGangjwa = new VGangjwa();
//			vGangjwa.setId(mGangjwa.getId());
//			vGangjwa.setName(mGangjwa.getName());
//			vGangjwa.setLecturer(mGangjwa.getLecturer());
//			vGangjwa.setCredit(mGangjwa.getCredit());
//			vGangjwa.setTime(mGangjwa.getTime());
//
//			vGangjwas.add(vGangjwa);
//		}
		return vGangjwas;
	}
}
