package Rules_IIQ;
//import sailpoint.connector.DelimitedFileConnector; 
// Create variable of a Map type to manipulate data temporarily 
//Map map = DelimitedFileConnector.defaultBuildMap(cols, record); 
// Get the employee number column from the row and store it as a String 

import sailpoint.connector.*;
import sailpoint.api.SailPointContext;

public class IIQ_BuildMap {
public static void main(String[] args) {
	SailPointContext context =  null;
	  Map map = JDBCConnector.buildMapFromResultSet(result, schema);


	  String strUserID = (String) map.get("EmployeeID"); 
	  String strCombined = "WORKGROUP: " + (String) map.get("GroupName") + " | " + 
	    "CAPABILITIES: " + (String) map.get("Group");

	  // If the emp number column has no value 
	  if (strUserID == null) 
	  { 
	    // Clear this entire row (map will return blank) 
	    //map.clear(); 

	    strUserID = (String) map.get("EmployeeID") + " (Blank emp number)"; 
	    map.put(" employeeNumber", strUserID); 
	  } 

	  map.remove("GroupName"); 
	  map.remove("Group"); 

	  map.put("ACCESS", strCombined ); 

	  // Return the map to SailPoint for aggregation into the identity 


	  return map;
}
}
