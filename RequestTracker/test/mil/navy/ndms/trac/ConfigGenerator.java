package mil.navy.ndms.trac;

import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import mil.navy.ndms.trac.server.Configuration;
import mil.navy.ndms.trac.shared.PromptType;
import mil.navy.ndms.trac.shared.Question;
import mil.navy.ndms.trac.shared.RequestForm;

public class ConfigGenerator {

	
	public static Configuration generateConfig() {
		Configuration config = new Configuration();
		config.setDefaultForm("example-form.xml");
		config.setFormLocation("C:/gitrepos/workshop/RequestTracker/forms");
		return config;
	}
	
	//
	public static void main(String[] args) throws Exception {
		
		Configuration config = generateConfig();
		XStream stream = new XStream(new DomDriver());
		stream.autodetectAnnotations(true);
		stream.toXML(config, new FileWriter("config/application-config.xml"));
		
	}
	
}
