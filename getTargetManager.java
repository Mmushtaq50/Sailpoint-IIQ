package Rules_IIQ;

import sailpoint.api.SailPointContext;
import sailpoint.object.Identity;

public class getTargetManager {
public static void main(String[] args) {
	SailPointContext context = null;
	 try{
		    Identity Managerobj = identity.getManager();

		    if(Managerobj != null){
		      return Managerobj.getAttribute("empNumber");
		    }else{
		      return "";
		    }
		  }catch(Exception e){
		    throw new Exception(Managerobj+" :::: Exception e is : "+e.getMessage());
		  }
}
}
