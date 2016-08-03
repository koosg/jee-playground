package nl.luminis.test.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("plain")
public class PlainHello {

	@GET
	@Produces("text/plain")
	public String sayHello() {
		return "just plain hello";
	}
}
