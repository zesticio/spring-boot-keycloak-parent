package in.zestic.authy.app.interceptor;

import in.zestic.common.security.interceptors.GenericServiceInterceptor;
import in.zestic.common.security.interceptors.PreHandleInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomPreHandleInterceptor implements PreHandleInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomPreHandleInterceptor.class.getSimpleName());

    public void intercept() {
        logger.info("pre call intercept");
    }
}
