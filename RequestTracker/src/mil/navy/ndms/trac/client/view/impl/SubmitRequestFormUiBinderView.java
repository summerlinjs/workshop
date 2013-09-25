package mil.navy.ndms.trac.client.view.impl;

import java.io.Serializable;
import java.util.List;

import mil.navy.ndms.trac.client.view.SubmitRequestFormView;
import mil.navy.ndms.trac.client.widget.BooleanWidget;
import mil.navy.ndms.trac.client.widget.LongAnswerWidget;
import mil.navy.ndms.trac.client.widget.SelectionWidget;
import mil.navy.ndms.trac.client.widget.ShortAnswerWidget;
import mil.navy.ndms.trac.shared.Question;
import mil.navy.ndms.trac.shared.RequestForm;
import mil.navy.ndms.trac.shared.Response;
import mil.navy.ndms.trac.shared.ResponseForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SubmitRequestFormUiBinderView extends Composite implements SubmitRequestFormView{

	private static SubmitRequestFormUiBinderViewUiBinder uiBinder = GWT
			.create(SubmitRequestFormUiBinderViewUiBinder.class);

	interface SubmitRequestFormUiBinderViewUiBinder extends
			UiBinder<Widget, SubmitRequestFormUiBinderView> {
	}

	public SubmitRequestFormUiBinderView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	Presenter presenter;
	
	@UiField
	Button submit;
	
	@UiField
	VerticalPanel questionPanel;
	
	RequestForm requestForm;
	
	@UiHandler("submit")
	void onSubmit(ClickEvent e)
	{
		ResponseForm form = new ResponseForm();
		for (int i = 0; i < questionPanel.getWidgetCount()-1; i++) 
		{
			TakesValue<Serializable> widget = (TakesValue<Serializable>) questionPanel.getWidget(i+1);
			Question question = requestForm.getQuestions().get(i);
			Response<Serializable> response = new Response<Serializable>();
			response.setAnswer(widget.getValue());
			response.setPrompt(question);
			form.getResponses().add(response);
		}
		presenter.submit(form);
	}

	public void load(RequestForm form)
	{		
		this.requestForm = form;
		questionPanel.add(new Label(form.getName()));
		List<Question> questions = form.getQuestions();
		for (Question question : questions) {
			switch (question.getType()) {
			case BOOLEAN:
				questionPanel.add(new BooleanWidget(question.getPrompt()));
				break;
			case SHORT_ANSWER:
				questionPanel.add(new ShortAnswerWidget(question.getPrompt()));
				break;
			case LONG_ANSWER:
				questionPanel.add(new LongAnswerWidget(question.getPrompt()));	
				break;
			case SELECTION:
				questionPanel.add(new SelectionWidget(question.getPrompt(),question.getChoices(),false));	
				break;
			case MULISELECT:
				questionPanel.add(new SelectionWidget(question.getPrompt(),question.getChoices(),true));	
				break;
			default:
				break;
			}
		}
	}


	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
