package Rules_IIQ;
//Incase, if you want to check weather the identity is having the Application link or not....! 
import java.util.ArrayList;
import java.util.List;
import sailpoint.api.IdentityService;
import sailpoint.api.SailPointContext;
import sailpoint.object.Application;
import sailpoint.object.Identity;
import sailpoint.object.Link;
import sailpoint.tools.GeneralException;
import sailpoint.api.SailPointContext;

public class getIdentityAppLinkViaIdentityService {
public static void main(String[] args) {
	SailPointContext context = null;
	Identity idObj = context.getObject(Identity.class, "Victor");
    System.out.println("**idObj***" +idObj);     
    if(null != idObj) {
    Application appObj = context.getObject(Application.class, "Bravo Poker");
    if(null != appObj) {
    IdentityService idService = new IdentityService(context);
    List applst = idService.getLinks(idObj, appObj);
    System.out.println("**applst***" +applst);     
    }
    }
}
}
