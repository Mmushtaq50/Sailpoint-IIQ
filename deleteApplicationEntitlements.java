package Rules_IIQ;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sailpoint.object.ManagedAttribute;
import sailpoint.object.*;
import sailpoint.api.Terminator;
import sailpoint.api.SailPointContext;

public class deleteApplicationEntitlements {
public static void main(String[] args) {
	SailPointContext context = null;

	  Terminator terminator = new Terminator(context);
	  Filter filter =Filter.eq("application.name","Legal Hold Pro(MGM)");

	  QueryOptions qo = new QueryOptions();
	  qo.add(filter);
	  List ID = context.getObjects(ManagedAttribute.class, qo);
	  terminator.deleteObjects(ManagedAttribute.class, qo);
	  context.commitTransaction();
	  return "success";
}
}
