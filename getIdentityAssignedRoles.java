package Rules_IIQ;

import java.util.ArrayList;
import java.util.List;
import sailpoint.api.SailPointContext;
import sailpoint.object.Bundle;
import sailpoint.object.Identity;

public class getIdentityAssignedRoles {
public static void main(String[] args) {
	SailPointContext context = null;
	 List lst = new ArrayList();
	  Identity idobject = context.getObject(Identity.class, "dmusso");
	  if(null != idobject){
	  List assignedRoles = idobject.getAssignedRoles();
	    if(null != assignedRoles){
	  for (Bundle bundle : assignedRoles) {
	    String name = bundle.getName();
	    lst.add(name);
	  }
	  return lst;
	  }
	  }
}
}
