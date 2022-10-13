package in.zestic.authy.app.handler;

import in.zestic.common.handlers.TimingDynamicInvocationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic proxies allow one single class with one single method to service multiple method calls to arbitrary classes
 * with an arbitrary number of methods. A dynamic proxy can be thought of as a kind of Facade, but one that can pretend
 * to be an implementation of any interface. Under the cover, it routes all method invocations to a single handler – the
 * invoke() method.
 */
public class LogoutInvocationHandler implements InvocationHandler {

    private final static Logger logger = LoggerFactory.getLogger(TimingDynamicInvocationHandler.class);

    private final Map<String, Method> methods = new HashMap<>();
    private final Object target;

    public LogoutInvocationHandler(Object target) {
        this.target = target;
        for (Method method : target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        Object result = methods.get(method.getName()).invoke(target, args);
        long elapsed = System.nanoTime() - start;
        logger.info("Executing {} finished in {} ns", method.getName(), elapsed);
        return result;
    }
}
