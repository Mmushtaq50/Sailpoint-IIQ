  import java.util.ArrayList;
  import java.util.List;
  import sailpoint.api.SailPointContext;
  import sailpoint.api.Terminator;
  import sailpoint.object.Filter;
  import sailpoint.object.Identity;
  import sailpoint.object.QueryOptions;
  import sailpoint.tools.GeneralException;
  import sailpoint.tools.Util;
  import sailpoint.api.IdentityService;
  import sailpoint.object.Link;

Terminator terminator = new Terminator(context);
  Identity idobject = context.getObject(Identity.class, "PA.383656");
  if (idobject != null) {
    Application appobj = context.getObject(Application.class, "BeyondTrust REST");
    if (null != appobj) {
      IdentityService idService = new IdentityService(context);
      List appLink = idService.getLinks(idobject, appobj);
      for (Link link : appLink) {
        terminator.deleteObject(link);
        context.saveObject(idobject);
        context.commitTransaction();
      }
      return "sucess";
    }
  }