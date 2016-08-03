package nl.luminis.test.web;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import nl.luminis.test.GreetingsFactory;

@Path("/jaxrs-sample")
@ApplicationPath("sample")
@Stateless
public class SampleJaxRs extends Application{

	@Inject
	private GreetingsFactory factory;

	@GET
	@Path("{input}")
	@Produces("text/plain")
	public String getMessageFromService(@PathParam("input") String input) {
		return factory.getService(input).sayHello();
	}

	@GET
	@Produces("text/plain")
	public String getBasicMessage() {
		return "it's all basic here...";
	}

}
