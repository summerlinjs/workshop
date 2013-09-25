package mil.navy.ndms.trac.server;

import mil.navy.ndms.trac.client.FormService;
import mil.navy.ndms.trac.shared.PromptType;
import mil.navy.ndms.trac.shared.Question;
import mil.navy.ndms.trac.shared.RequestForm;
import mil.navy.ndms.trac.shared.Response;
import mil.navy.ndms.trac.shared.ResponseForm;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class FormServiceImpl extends RemoteServiceServlet implements
		FormService {

	public RequestForm getRequestForm() {

		RequestForm form = new RequestForm();
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

	@Override
	public void submitRequestForm(ResponseForm form) {
		for (Response<?> response : form.getResponses()) {
			System.out.println(response.getAnswer());
		}
	}

}
