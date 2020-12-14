package control;

import java.util.Vector;

import model.DataBase;
import valueObject.VPlan;
import valueObject.VPlanWord;

public class CPlanWord {

	public VPlanWord planRead(VPlanWord vPlanWord) {
		DataBase database = new DataBase();
		VPlanWord vPlanWord1 = database.planWordRead(vPlanWord);
		return vPlanWord1;
	}
}
