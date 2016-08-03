package nl.luminis.test;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Lock(LockType.READ)
public class ElderlyGreeter {

	@Inject
	GreetingService greeter;
	
	
//	@Schedule(second="*/5", hour="*", minute="*", persistent=true)
	public void GrandaKeepsRepeating() {
		System.out.println("ehehehe..." + greeter.sayHello());
	}
}
