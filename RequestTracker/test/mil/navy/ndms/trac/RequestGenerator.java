package mil.navy.ndms.trac;

import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import mil.navy.ndms.trac.shared.PromptType;
import mil.navy.ndms.trac.shared.Question;
import mil.navy.ndms.trac.shared.RequestForm;

public class RequestGenerator {

	
	public static RequestForm generateForm() {
		RequestForm form = new RequestForm();
		form.setFormat("1.0");
		form.setName("Request form");
		for (int i = 0; i < 30; i++) {
			Question question = new Question();
			switch (PromptType.values()[i % PromptType.values().length]) {
			case BOOLEAN:
				question.setPrompt("Guess Yes/No?");
				question.setType(PromptType.BOOLEAN);
				break;
			case SHORT_ANSWER:
				question.setPrompt("Guess Who?");
				question.setType(PromptType.SHORT_ANSWER);
				break;
			case LONG_ANSWER:
				question.setPrompt("Guess What?");
				question.setType(PromptType.LONG_ANSWER);
				break;
			case SELECTION:
				question.setPrompt("Can you guess?");
				question.getChoices().add(String.valueOf(i));
				question.getChoices().add(String.valueOf(i+1));
				question.getChoices().add(String.valueOf(i+2));
				question.setType(PromptType.SELECTION);
				break;
			case MULISELECT:
				question.setPrompt("Can you guest them all?");
				question.getChoices().add(String.valueOf(i));
				question.getChoices().add(String.valueOf(i+1));
				question.getChoices().add(String.valueOf(i+2));
				question.setType(PromptType.MULISELECT);
				break;

			default:
				break;
			}

			form.getQuestions().add(question);
		}
		return form;
	}
	
	//
	public static void main(String[] args) throws Exception {
		
		RequestForm form = generateForm();
		XStream stream = new XStream(new DomDriver());
		stream.autodetectAnnotations(true);
		stream.toXML(form, new FileWriter("forms/example-form.xml"));
		
	}
	
}
