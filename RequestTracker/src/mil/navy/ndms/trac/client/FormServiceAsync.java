package mil.navy.ndms.trac.client;

import mil.navy.ndms.trac.shared.RequestForm;
import mil.navy.ndms.trac.shared.ResponseForm;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface FormServiceAsync {
	void getRequestForm(AsyncCallback<RequestForm> callback);

	void submitRequestForm(ResponseForm form, AsyncCallback<Void> callback);
}
