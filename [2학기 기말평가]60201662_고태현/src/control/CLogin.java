package control;

import model.DataAccessObject;
import model.DataBase;
import model.MLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class CLogin {

	public boolean validateUser(VLogin vLogin) {
		boolean bResult = false;

		DataAccessObject dataAccessObject = new DataAccessObject();
		MLogin mLogin = dataAccessObject.getLogin(vLogin.getUserId());
		if (mLogin != null) {
			if (vLogin.getPassword().contentEquals(mLogin.getPassword())) {
				bResult = true;
			} else {
				// password mismatch
			}
		} else {
			// no userId
		}
		return bResult;
	}

	public VUserInfo validateUser1(VLogin vLogin) {
		DataBase dataBase = new DataBase();
		VUserInfo vUserInfo = dataBase.login(vLogin);

		return vUserInfo;
	}

	public int validateUser2(VLogin vLogin) {
		DataBase dataBase = new DataBase();
		int check = dataBase.login1(vLogin);
		return check;
	}

//	public boolean validateUser2(VLogin vLogin) {
//		boolean bResult = false;
//
//		DataBase dataBase = new DataBase();
//		VUserInfo vUserInfo = dataBase.login(vLogin);
//
//		if (vUserInfo.getId().equals(null) && vUserInfo.getPw().equals(null)) {
//			bResult = true;
//		} else {
//			bResult = false;
//		}
//		return bResult;
//	}
}
