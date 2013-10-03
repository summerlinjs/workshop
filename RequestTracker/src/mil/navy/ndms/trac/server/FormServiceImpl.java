package mil.navy.ndms.trac.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import mil.navy.ndms.trac.client.FormService;
import mil.navy.ndms.trac.shared.PromptType;
import mil.navy.ndms.trac.shared.Question;
import mil.navy.ndms.trac.shared.RequestForm;
import mil.navy.ndms.trac.shared.Response;
import mil.navy.ndms.trac.shared.ResponseForm;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * The server side implementation of the RPC service.
 */
public class FormServiceImpl extends RemoteServiceServlet implements FormService {

	XStream stream;
	Configuration config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		stream = new XStream(new DomDriver());
		stream.processAnnotations(new Class<?>[]{RequestForm.class,Question.class,Configuration.class});
		String configLocation = config.getInitParameter("application-config");
		Configuration configuration = new Configuration();
		try {
			stream.fromXML(new FileInputStream(configLocation), configuration);
			this.config = configuration;
		} catch (FileNotFoundException e) {
			throw new ServletException("Initialization Failed", e);
		}
	}
	
	public RequestForm getRequestForm() {
		RequestForm form = new RequestForm();
		try {
			stream.fromXML(new FileInputStream(config.getFormLocation()+"/"+config.getDefaultForm()), form);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
