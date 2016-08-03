package nl.luminis.test;


import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@Stateless
public class GreetingsFactory {

	@Inject @Any
	private Instance<GreetingService> services;

	public GreetingService getService(String input) {
		// services should be ambiguous?
		for (GreetingService service : services) {
			if (service.supports(input)) {
				return service;
			}
		}
		System.out.println("Could not find proper service, returning default");
		return (GreetingService) services.select(new DefaultGreetingAnnotationLiteral()).get();
	}
}
