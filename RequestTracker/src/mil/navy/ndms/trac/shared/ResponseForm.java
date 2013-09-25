package mil.navy.ndms.trac.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResponseForm implements Serializable {

	private static final long serialVersionUID = 1L;
	String createdBy;
	String updatedBy;
	Date createdDate;
	Date updatedDate;
	
	List<Response<?>> responses = new ArrayList<Response<?>>();

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Response<?>> getResponses() {
		return responses;
	}

	public void setResponses(List<Response<?>> responses) {
		this.responses = responses;
	}
}
