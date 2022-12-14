package Rules_IIQ;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sailpoint.object.ManagedAttribute;
import sailpoint.api.SailPointContext;
import sailpoint.object.*;
import sailpoint.tools.GeneralException;

public class getApplicationAttrbute {
public static void main(String[] args) {
	SailPointContext context = null;
	  List finull = new ArrayList();
	  Filter filterApp = Filter.eq("application.name", "Visual Limits Casino");
	  Filter filterRole = Filter.eq("attribute", "Roles-Bellagio");		// make sure you make the atrribute values as [ Managed ]
	  Filter andFilter = Filter.and(filterApp, filterRole);

	  QueryOptions qo = new QueryOptions();
	  qo.add(andFilter);

	  List list = context.getObjects(ManagedAttribute.class, qo);

	  for (ManagedAttribute attribute : list) {
	    String maAttrVal =  attribute.getValue();
	    finull.add(maAttrVal);
	  }
	  return finull;

}
}
