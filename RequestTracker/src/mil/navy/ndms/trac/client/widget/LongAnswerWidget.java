package mil.navy.ndms.trac.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class LongAnswerWidget extends Composite implements TakesValue<String> {

	private static ShortAnswerWidgetUiBinder uiBinder = GWT
			.create(ShortAnswerWidgetUiBinder.class);

	interface ShortAnswerWidgetUiBinder extends
			UiBinder<Widget, LongAnswerWidget> {
	}
	@UiField
	Label question;
	
	@UiField
	TextArea answer;

	public LongAnswerWidget(String questionText) {
		initWidget(uiBinder.createAndBindUi(this));
		question.setText(questionText);
	}

	@Override
	public void setValue(String value) {
		answer.setValue(value);
	}

	@Override
	public String getValue() {
		return answer.getValue();
	}

}
