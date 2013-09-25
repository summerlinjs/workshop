package mil.navy.ndms.trac.shared;

import java.io.Serializable;

public class Response<T extends Serializable> implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Question prompt;
	private T answer;
	public Question getPrompt() {
		return prompt;
	}
	public void setPrompt(Question prompt) {
		this.prompt = prompt;
	}
	public T getAnswer() {
		return answer;
	}
	public void setAnswer(T answer) {
		this.answer = answer;
	}
	
}
