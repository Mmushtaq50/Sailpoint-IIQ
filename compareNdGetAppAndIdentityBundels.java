package Rules_IIQ;

import java.util.ArrayList;
import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.object.Bundle;
import sailpoint.object.Filter;
import sailpoint.object.Identity;
import sailpoint.object.QueryOptions;

public class compareNdGetAppAndIdentityBundels {
public static void main(String[] args) {
	SailPointContext context = null;
	//getting common bundles of specific - Application and  Identity. 	

	  String app = "Okta";

		  Filter filterApp = Filter.eq("applicationName", app);
		  QueryOptions qo = new QueryOptions();
		  qo.addFilter(filterApp);
		  List roles = context.getObjects(Bundle.class, qo);

		  List listBundle = new ArrayList();
		  Identity identity = context.getObjectById(Identity.class, "0afe03337fdf15a2817fe72226dd1bf7");
		  List bundle = identity.getBundles();
		  for (Bundle m : bundle) {
		    for(Bundle bund : roles){
		      if(m==bund) {
		    	  listBundle.add(bund.getName());
		      }
		    }
		  }
		  return bundleList;
}
}
