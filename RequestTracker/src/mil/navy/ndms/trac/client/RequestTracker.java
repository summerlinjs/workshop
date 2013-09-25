package mil.navy.ndms.trac.client;

import mil.navy.ndms.trac.client.activity.SubmitRequestActivity;
import mil.navy.ndms.trac.client.view.impl.SubmitRequestFormUiBinderView;
import mil.navy.ndms.trac.shared.RequestForm;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;


public class RequestTracker implements EntryPoint {
	
	public void onModuleLoad() 
	{
		RootPanel rootPanel = RootPanel.get();
		final SimplePanel panel = new SimplePanel();
		rootPanel.add(panel);
		FormServiceAsync service = GWT.create(FormService.class);
		service.getRequestForm(new AsyncCallback<RequestForm>() {
			
			@Override
			public void onSuccess(RequestForm form) { 
				new SubmitRequestActivity(new SubmitRequestFormUiBinderView(), form).start(panel, null);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				throw new RuntimeException(caught);
			}
		});
	}
	
}
