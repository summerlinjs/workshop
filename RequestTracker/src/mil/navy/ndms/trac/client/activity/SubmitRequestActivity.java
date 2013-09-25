package mil.navy.ndms.trac.client.activity;

import mil.navy.ndms.trac.client.FormService;
import mil.navy.ndms.trac.client.FormServiceAsync;
import mil.navy.ndms.trac.client.view.SubmitRequestFormView;
import mil.navy.ndms.trac.shared.RequestForm;
import mil.navy.ndms.trac.shared.ResponseForm;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SubmitRequestActivity extends AbstractActivity implements SubmitRequestFormView.Presenter
{
	SubmitRequestFormView view;
	FormServiceAsync service = GWT.create(FormService.class);
	public SubmitRequestActivity(SubmitRequestFormView view, RequestForm form) {
		view.load(form);
		this.view = view;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@Override
	public void submit(ResponseForm form) {
		service.submitRequestForm(form, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Submitted");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
		});
	}
	
	
}
