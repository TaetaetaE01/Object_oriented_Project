package control;

import model.DataBase;
import valueObject.VUserInfo;

public class CChange {

	public void change(String changePw, VUserInfo vUserInfo) {
		DataBase dataBase = new DataBase();
		dataBase.change(changePw, vUserInfo);
	}
}
