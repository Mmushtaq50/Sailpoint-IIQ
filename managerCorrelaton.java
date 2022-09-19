package Rules_IIQ;

import java.util.HashMap;
import java.util.Map;

import sailpoint.api.SailPointContext;

public class managerCorrelaton {
public static void main(String[] args) {
	SailPointContext context = null;
	 Map managerMap = new HashMap();
	  System.out.println("*****Manager Corrlation Rule******");
	  String managerName = link.getAttribute("managerId");
	  if(managerMap != null){
	    managerMap.put("identityAttributeName", "employeeId");
	    managerMap.put("identityAttributeValue",managerName);
	    return managerMap;
	  }
}
}
