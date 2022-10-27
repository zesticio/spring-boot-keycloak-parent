package in.zestic.authy.app.handler;

import in.zestic.authy.keycloak.api.exception.KeycloakException;
import in.zestic.common.entity.Result;
import in.zestic.common.handlers.BaseGlobalExceptionHandler;
import in.zestic.common.ratelimit.RateLimitException;
import org.apache.http.conn.HttpHostConnectException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<Result> httpHostConnectionException(Exception ex, WebRequest request) throws IOException {
        return createErrorResponseEntity(ex, HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value());
    }

    @ExceptionHandler(ForbiddenException.class)
    public final ResponseEntity<Result> forbiddenException(Exception ex, WebRequest request) throws IOException {
        return createErrorResponseEntity(ex, HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value());
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public final ResponseEntity<Result> notAuthorizedException(Exception ex, WebRequest request) throws IOException {
        return createErrorResponseEntity(ex, HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value());
    }

    protected ResponseEntity<Result> createErrorResponseEntity(Exception exception, HttpStatus status, Integer code) {
        logger.error(String.format("Error: %s with code: %d", exception.getMessage(), code));
        Result<Void> result = new Result(code, exception.getMessage());
        ResponseEntity<Result> response = new ResponseEntity<>(result, status);
        return response;
    }
}
