package control;

import model.DataBase;
import valueObject.VRegister;

public class CRegister {

	public void write(VRegister vRegister) {
		DataBase dataBase = new DataBase();
		dataBase.registerPersonalinfo(vRegister);
	}

	public int confirm(VRegister vRegister) {
		DataBase dataBase = new DataBase();
		int confirmID = dataBase.joinCheck(vRegister);

		return confirmID;
	}
}
