package mil.navy.ndms.trac.server;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("config")
public class Configuration {

	@XStreamAlias("form-location")
	private String formLocation;
	@XStreamAlias("default-form")
	private String defaultForm;
	public String getFormLocation() {
		return formLocation;
	}
	public void setFormLocation(String formLocation) {
		this.formLocation = formLocation;
	}
	public String getDefaultForm() {
		return defaultForm;
	}
	public void setDefaultForm(String defaultForm) {
		this.defaultForm = defaultForm;
	}
	
}
