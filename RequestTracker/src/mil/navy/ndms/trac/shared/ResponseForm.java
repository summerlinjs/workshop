package mil.navy.ndms.trac.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseForm extends BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;
	List<Response<?>> responses = new ArrayList<Response<?>>();

	public List<Response<?>> getResponses() {
		return responses;
	}

	public void setResponses(List<Response<?>> responses) {
		this.responses = responses;
	}
}
