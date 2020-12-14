package control;

import model.DataBase;
import valueObject.VFind;

public class CFind {

	public VFind idFind(String name, String stnum) {
		DataBase database = new DataBase();
		VFind vFind = database.idFind(name, stnum);
		if (vFind == null) {
			return null;
		} else {
			return vFind;
		}
	}

	public VFind pwFind(String id, String stnum) {
		DataBase database = new DataBase();
		VFind vFind = database.pwFind(id, stnum);
		if (vFind == null) {
			return null;
		} else {
			return vFind;
		}
	}
}
