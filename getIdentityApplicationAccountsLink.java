package Rules_IIQ;

import java.util.ArrayList;
import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.object.Identity;
import sailpoint.object.Link;
import sailpoint.tools.GeneralException;

public class getIdentityApplicationAccountsLink {
public static void main(String[] args) {
	SailPointContext context = null;
	List applst = new ArrayList();

	  Identity idobject = context.getObject(Identity.class, "John");
	  if (idobject != null) {
	    List idlinks = idobject.getLinks();
	     System.out.println("** idlinks **" +idlinks);
	    for (Link applink : idlinks) {
	      String name = applink.getApplicationName();					
	         applst.add(name);
	    }
	    System.out.println("** applst **" +applst);
	  }
}
}
