import java.util.List;

import javax.validation.ConstraintViolationException;
import sailpoint.api.Terminator;
import sailpoint.api.SailPointContext;
import sailpoint.object.Filter;
import sailpoint.object.Identity;
import sailpoint.object.QueryOptions;
import sailpoint.tools.GeneralException;

public class terminateAppAccounts {
public static void main(String[] args) throws GeneralException {
	try {
	SailPointContext context = null;
	
	Terminator terminator = new Terminator(context);
    Filter appFilter =Filter.eq("application.name","BeyondTrust REST");

    QueryOptions qo = new QueryOptions();
    qo.add(appFilter);
    List ID = context.getObjects(Identity.class, qo);
		terminator.deleteObjects(Identity.class, qo);
    context.commitTransaction();
   // return "success";
	}catch(ConstraintViolationException e) {
		System.out.println("Exception cought " +e.getMessage());
	}
	
}
}