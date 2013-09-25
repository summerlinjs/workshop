package mil.navy.ndms.trac.client.view;

import com.google.gwt.user.client.ui.IsWidget;

import mil.navy.ndms.trac.shared.RequestForm;
import mil.navy.ndms.trac.shared.ResponseForm;

public interface SubmitRequestFormView extends IsWidget{

	void load(RequestForm form);
	void setPresenter(Presenter presenter);
	public interface Presenter{
		void submit(ResponseForm form);
	}
	
}
