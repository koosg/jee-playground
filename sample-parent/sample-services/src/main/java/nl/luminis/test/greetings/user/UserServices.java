/**
 * Disclaimer: this code is only for demo no production use
 */
package nl.luminis.test.greetings.user;

import javax.ejb.Stateless;

import nl.luminis.test.GreetingService;

/**
 * @author papo
 *
 */
@Stateless
public class UserServices implements GreetingService{

	@Override
	public String sayHello(){
		return "I just came to say: Hello";
	}

	@Override
	public boolean supports(String input) {
		return "user".equalsIgnoreCase(input);
	}
	
	

}
