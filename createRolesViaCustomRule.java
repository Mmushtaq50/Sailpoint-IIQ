package Rules_IIQ;

import java.util.ArrayList;
import java.util.List;
import sailpoint.object.Application;
import sailpoint.object.Bundle;
import sailpoint.object.Filter;
import sailpoint.object.Identity;
import sailpoint.object.ManagedAttribute;
import sailpoint.object.Profile;
import sailpoint.object.QueryOptions;
import sailpoint.object.TaskResult;
import sailpoint.tools.GeneralException;
import sailpoint.tools.Util;
import sailpoint.api.SailPointContext;

public class createRolesViaCustomRule {
	
	static SailPointContext context = null;
	 public boolean buildOrganizationalRule(String appName, Identity owner, List bundles) {
		 boolean success = false;
		 try {
			 Bundle role = new Bundle();
			 role.setName(appName);
			 role.setOwner(owner);
			 role.setType("Organizational");
			 role.setInheritance(bundles);
			 context.saveObject(role);
			 context.commitTransaction();
			 success = true;
		 }
		 catch(Exception e) {
			 log.error("Error while creating organizational role");
		 }
		 return success;
	 }
	 public Bundle buildITROle(Application app, Identity owner, ManagedAttribute entitlement) throws GeneralException {
		 String value = entitlement.getValue();
		 String displayName = Util.isNotNullOrEmpty(entitlement.getDisplayName()) ? entitlement.getDisplayName() : value;
		 Bundle role = new Bundle();
		 String nameFormat = app.getName()+"."+"VDI."+displayName;
		 role.setName(nameFormat);
		 role.setOwner(owner);
		 role.setAttribute("approvalLevel", "1");
	   role.setAttribute("approvalLevel1", owner.getName());
		 Profile profile = new Profile();
		 profile.setApplication(app);
		 Filter filter = Filter.contains(entitlement.getAttribute(), value);
		 profile.addConstraint(filter);
		 role.add(profile);
		 context.saveObject(role);
		 context.commitTransaction();
		 return role;
	 }
	 public static List buildApplicationRoles(String appName) {
		 List bundles = new ArrayList();
		 List rolesCreated = new ArrayList();
		 Application app = context.getObject(Application.class, appName);
		 if(app != null) {
			 Filter appFilter = Filter.eq("application.name", appName);
			 Identity owner = context.getObject(Identity.class, "CMS - Approvers"); // give workgroupName
			 if(owner != null) {
				 QueryOptions qo = new QueryOptions();
				 qo.addFilter(appFilter);
				 List entitlements = context.getObjects(ManagedAttribute.class, qo);
				 if(entitlements != null &amp;&amp; entitlements.size()>0) {
					 for(ManagedAttribute entitlement : entitlements) {
						Bundle role = buildITROle(app, owner, entitlement);
						if(role != null) {
							bundles.add(role);
							rolesCreated.add(role.getName());
						}
					 }
					 boolean success = buildOrganizationalRule(appName, owner, bundles);
				 }
			 }
		 }
		 return rolesCreated;
	 }	
public static void main(String[] args) {
	SailPointContext context = null;
	 String appName = "CMS";// give appName
	 List rolesCreated = buildApplicationRoles(appName);
	 return "Roles created successfully";
}
}
