package control;

import java.util.Vector;

import model.DataBase;
import valueObject.VCredit;
import valueObject.VPlan;

public class CCredit {
	int sum = 0;

	public int read(String fileName) {
		DataBase database = new DataBase();
		Vector<VCredit> VCredits = database.Creditread(fileName);

		for (VCredit vCredit : VCredits) {
			sum += Integer.parseInt(vCredit.getCredit());
		}
		return sum;
	}
}
