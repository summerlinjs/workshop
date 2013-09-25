package mil.navy.ndms.trac.client.widget;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class SelectionWidget extends Composite implements TakesValue<String> {

	private static SelectionWidgetUiBinder uiBinder = GWT
			.create(SelectionWidgetUiBinder.class);

	interface SelectionWidgetUiBinder extends UiBinder<Widget, SelectionWidget> {
	}

	@UiField
	Label question;
	
	@UiField(provided=true)
	ListBox answer;
	
	
	public SelectionWidget(String questionText, List<String> choices, boolean isMultipleSelect) {
		answer = new ListBox(isMultipleSelect);
		for (String choice : choices) {
			answer.addItem(choice);
		}
		initWidget(uiBinder.createAndBindUi(this));
		question.setText(questionText);
	}


	@Override
	public void setValue(String value) {
		
		Collection<String> values= Arrays.asList(value.split(","));
		for (int i = 0; i < answer.getItemCount(); i++) {
			if(values.contains(answer.getValue(i)))
			{
				answer.setSelectedIndex(i);
			}
		}
	}


	@Override
	public String getValue() {
		String value = "";
		
		for (int i = 0; i < answer.getItemCount(); i++) {
			if(answer.isItemSelected(i))
			{
				value += answer.getValue(i);
			}
		}
		return value;
	}
	
	

}
