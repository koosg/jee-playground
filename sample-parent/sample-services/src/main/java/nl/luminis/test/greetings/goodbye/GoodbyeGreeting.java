package nl.luminis.test.greetings.goodbye;

import javax.ejb.Stateless;
import javax.inject.Named;

import nl.luminis.test.DefaultGreeting;
import nl.luminis.test.GreetingService;

@Stateless
@DefaultGreeting
public class GoodbyeGreeting implements GreetingService {

	@Override
	public String sayHello() {
		return "You say 'Goodbye'";
	}

	@Override
	public boolean supports(String input) {
		return "goodbye".equalsIgnoreCase(input);
	}

}
