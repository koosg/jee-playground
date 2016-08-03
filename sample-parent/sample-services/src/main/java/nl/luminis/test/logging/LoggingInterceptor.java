package nl.luminis.test.logging;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@LogCall
@SuppressWarnings("serial")
public class LoggingInterceptor implements Serializable {
    @AroundInvoke
    public Object logCall(InvocationContext invocation) throws Exception {
    	System.out.println(" You're calling " + invocation.getMethod() + " on class " + invocation.getClass().getName());
    	
        Object result =  invocation.proceed();
        System.out.println(" and it returned: " + result);
        return result;
}

}
