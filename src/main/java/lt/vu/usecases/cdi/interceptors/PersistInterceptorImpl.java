package lt.vu.usecases.cdi.interceptors;


import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@PersistInterceptor
public class PersistInterceptorImpl {

    @AroundInvoke
    public Object doSomeStuff(InvocationContext context) throws Exception {
        System.out.println("Persisting object: " + context.getParameters().toString());
        return context.proceed();
    }
}
