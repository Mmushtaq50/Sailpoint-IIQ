package Rules_IIQ;

import java.util.ArrayList;
import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.object.Identity;

public class addMemIntoWorkGroup {
	public static void main(String[] args) {
		SailPointContext context = null;
		// can add Members into the workgroup
		
		Identity workgroup = context.getObjectByName(Identity.class, "SelfRegistrationWorkGroup");
		List wrkGrpList = new ArrayList();
		System.out.println("****workgroup**** :"+workgroup);
		wrkGrpList.add(workgroup);
		if (workgroup != null) {
			List names = new ArrayList();
			names.add("Bob Fields");		
			names.add("Alan Snow");
			System.out.println("****before****");
			for (String object : names) {
				Identity id = context.getObject(Identity.class, object);
				System.out.println("id " + id);
				id.setWorkgroups(wrkGrpList);		
				System.out.println("****in2***");
				System.out.println("workgroup " + workgroup.toXml());
			}
			context.saveObject(workgroup);
			context.commitTransaction();
		}

	}

}
