 import java.util.List;

  import sailpoint.api.Provisioner;
  import sailpoint.api.SailPointContext;
  import sailpoint.object.Application;
  import sailpoint.object.Identity;
  import sailpoint.api.IdentityService;
  import sailpoint.object.Link;
  import sailpoint.object.ProvisioningPlan;
  import sailpoint.object.ProvisioningProject;
  import sailpoint.object.ProvisioningPlan.AccountRequest;
  import sailpoint.object.ProvisioningPlan.AttributeRequest;
  import sailpoint.tools.GeneralException;
  import sailpoint.tools.Util;




  Identity idObj = context.getObject(Identity.class, "100074");
  System.out.println("*****idObj*****"+idObj);
  if(idObj != null) {
    Application appObj = context.getObject(Application.class, "Okta");
    if(null != appObj) {
      IdentityService idService = new IdentityService(context);
      List applst = idService.getLinks(idObj, appObj);
      if(Util.nullSafeSize(applst) > 0) {
        if(applst != null) {
          for (Object  natIdn : applst) {  
            String nativeIdentity = ((Link) natIdn).getNativeIdentity();
            System.out.println("****nativeIdentity***" +nativeIdentity);



            System.out.println("*****entering if*****");
            ProvisioningPlan plan = new ProvisioningPlan();
            AccountRequest accReqOkta = new AccountRequest();   
            System.out.println("22222222");
            accReqOkta.getApplication();
            accReqOkta.setNativeIdentity(nativeIdentity);
            accReqOkta.add(new AttributeRequest("groups",ProvisioningPlan.Operation.Add, "00g18kr3bzrStsRW70h8" ));
            System.out.println("5555555555555");
            accReqOkta.setOperation(AccountRequest.Operation.Create);           
            plan.add(accReqOkta);
            plan.setIdentity(idObj);

            Provisioner provisioner = new Provisioner(context);           
            ProvisioningProject proObj = provisioner.compile(plan);
            provisioner.execute();
            System.out.println("*****Plan is*****"+plan.toXml());
            return plan;

          }
        }
      }
    }
  }
