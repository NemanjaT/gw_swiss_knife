package rs.edu.viser.services.filler.groups;

import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

public class SystemFillerGroup extends FillerGroup {

	public SystemFillerGroup() {
		super(FillerGroupTypes.SYSTEM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getModels(SchedulerTypes type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		// TODO Auto-generated method stub
		return null;
	}

}
