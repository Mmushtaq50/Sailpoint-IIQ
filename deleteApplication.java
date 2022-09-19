package Rules_IIQ;

import sailpoint.object.*;  
import sailpoint.tools.GeneralException;  
import sailpoint.api.SailPointContext;  
import sailpoint.server.InternalContext;  
import sailpoint.api.Terminator;  
import sailpoint.object.Application;  
import java.util.List;  
import sailpoint.api.SailPointContext;

public class deleteApplication {
public static void main(String[] args) {
	SailPointContext context = null;
	Application appName = null;     
	  try {     
	    appName = context.getObjectByName(Application.class, "Okta");    
	  } catch (GeneralException e) {          
	    e.printStackTrace();     
	  }     
	  Terminator t = new Terminator(context);     
	  try {      
	    t.deleteObject(appName);      
	    System.out.println("Deleting application" + appName);      
	  } catch (GeneralException e) {     
	    e.printStackTrace();     
	  }    
	  try {      
	    context.commitTransaction();      
	  } catch (GeneralException e) {  

	    e.printStackTrace();      
	  }     
	  try {    
	    context.close();     
	  } catch (GeneralException e) {  
	    e.printStackTrace();    
	  } 
}
}
