package mil.navy.ndms.trac.client;

import mil.navy.ndms.trac.shared.RequestForm;
import mil.navy.ndms.trac.shared.ResponseForm;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface FormService extends RemoteService {
	RequestForm getRequestForm();
	void submitRequestForm(ResponseForm form);
}
