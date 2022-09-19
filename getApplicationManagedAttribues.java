package Rules_IIQ;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sailpoint.object.ManagedAttribute;
import sailpoint.object.*;
import sailpoint.api.SailPointContext;

public class getApplicationManagedAttribues {
public static void main(String[] args) {
	SailPointContext context = null;
	  Filter filter =Filter.eq("application.name","CMS");
	  Filter filter1 =Filter.notnull("value");

	  Filter andFilter =Filter.and(filter,filter1);
	  QueryOptions qo = new QueryOptions();
	  qo.add(andFilter);
	  List IDS = new ArrayList();
	  List ID = context.getObjects(ManagedAttribute.class, qo);

	  for(ManagedAttribute attribute :ID) {
	    String value = attribute.getValue();

	    IDS.add(value);   
	  }
	  ArrayList list = new ArrayList();
	  System.out.println("**IDS**"+IDS);
	  return IDS;
}
}
