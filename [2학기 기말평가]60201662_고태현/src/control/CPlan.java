package control;

import java.util.Vector;

import model.DataBase;
import valueObject.VPlan;

public class CPlan {

	public Vector<VPlan> planRead(String campus, String name, String professor, String credit) {
		DataBase database = new DataBase();
		Vector<VPlan> vPlans = database.planRead(campus, name, professor, credit);
		return vPlans;
	}
}
