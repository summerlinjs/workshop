package mil.navy.ndms.trac.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

public class BooleanWidget extends Composite implements TakesValue<Boolean> {

	private static BooleanWidgetUiBinder uiBinder = GWT.create(BooleanWidgetUiBinder.class);

	interface BooleanWidgetUiBinder extends UiBinder<Widget, BooleanWidget> {
	}

	public BooleanWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Label question;
	String id = DOM.createUniqueId();
	
	@UiField(provided=true)
	RadioButton trueRadioButton = new RadioButton(id);
	

	@UiField(provided=true)
	RadioButton falseRadioButton= new RadioButton(id);
	
	public BooleanWidget(String questionText) {
		initWidget(uiBinder.createAndBindUi(this));	
		this.question.setText(questionText);
	}

	@Override
	public void setValue(Boolean value) {
		if(value == true)
		{
			trueRadioButton.setValue(true);
			falseRadioButton.setValue(false);
		}
		else
		{
			trueRadioButton.setValue(false);
			falseRadioButton.setValue(true);
		}
	}

	@Override
	public Boolean getValue() {
		return trueRadioButton.getValue();
	}

	
}
