package in.zestic.authy.app.interceptor;

import in.zestic.common.security.interceptors.PostHandleInterceptor;
import in.zestic.common.security.interceptors.PreHandleInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomPostHandleInterceptor implements PostHandleInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomPostHandleInterceptor.class.getSimpleName());
    
    public void intercept() {
        logger.info("post call intercept");
    }
}
