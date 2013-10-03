package mil.navy.ndms.trac.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("request-form")
public class RequestForm implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String format;

	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
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
