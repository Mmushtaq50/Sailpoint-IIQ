package Rules_IIQ;

import sailpoint.api.SailPointContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sailpoint.object.Filter;
import sailpoint.object.Identity;
import sailpoint.object.QueryOptions;
import sailpoint.tools.GeneralException;

public class getActiveManagerCount {
public static void main(String[] args) {
	SailPointContext context = null;
	List activeManagers = new ArrayList();
	  Filter isManager = Filter.and(Filter.eq("managerStatus", true), Filter.ne("IdentityStatus", "terminated"));
	  QueryOptions qo = new QueryOptions().addFilter(isManager);
	  Iterator managers = context.search(Identity.class, qo, "name");
	  while(managers.hasNext()) {
	    String managerName = (String) managers.next()[0];
	    Filter managerFilter = Filter.eq("manager.name", managerName);
	    Filter statusFilter = Filter.or(Filter.eq("identityStatus", "active"), Filter.eq("identityStatus", "prehire"), Filter.eq("identityStatus", "on leave"));
	    Filter compoundFilter = Filter.and(managerFilter, statusFilter);
	    List activeSubOrdninates = context.getObjects(Identity.class, new QueryOptions().addFilter(compoundFilter));
	    if(activeSubOrdninates == null || activeSubOrdninates.size() == 0) {
	      continue;
	    }
	    activeManagers.add(managerName);
	  }

	  if(taskResult != null) {
	    taskResult.setAttribute("count", activeManagers.size());
	    //taskResult.setAttribute("managers", activeManagers);
	    context.saveObject(taskResult);
	    context.commitTransaction();
	  }
}
}
