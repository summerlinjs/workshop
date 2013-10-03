package mil.navy.ndms.trac.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("question")
public class Question implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String prompt;
	private boolean required;
	private PromptType type;
	private List<String> choices = new ArrayList<String>();
	
	public List<String> getChoices() {
		return choices;
	}
	public void setChoices(List<String> choices) {
		this.choices = choices;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public PromptType getType() {
		return type;
	}
	public void setType(PromptType type) {
		this.type = type;
	}
	

}
