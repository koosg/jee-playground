package nl.luminis.test.logging;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.util.AnnotationLiteral;

import nl.luminis.test.GreetingService;
import nl.luminis.test.util.AnnotatedTypeBuilder;

public class LoggingGreetingsExtension implements Extension {

	
    public <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> event) {
    	System.out.println("testing " + event.getAnnotatedType().getJavaClass().getName());
        if (interceptAnnotatedType(event.getAnnotatedType())) {
            System.out.println("Adding the timing interceptor for " + event.getAnnotatedType().getJavaClass().getName());
            AnnotatedTypeBuilder<T> builder = new AnnotatedTypeBuilder<T>().readFromType(event.getAnnotatedType());
            builder.addToClass(new LogCallAnnotationLiteral());
            event.setAnnotatedType(builder.create());
        }
    }

    private boolean interceptAnnotatedType(AnnotatedType at) {
        if (at.getJavaClass().getEnclosingClass() != null) {
            return false;
        }

        if (at.isAnnotationPresent(LogCall.class)) {
            return false;
        }
        
        if(GreetingService.class.isAssignableFrom(at.getJavaClass())) {
        	return true;
        }
        return false;
    }

private static class LogCallAnnotationLiteral extends AnnotationLiteral<LogCall> implements LogCall {}
}
