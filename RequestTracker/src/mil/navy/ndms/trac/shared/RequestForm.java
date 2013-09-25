package mil.navy.ndms.trac.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RequestForm implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Question> questions = new ArrayList<Question>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
