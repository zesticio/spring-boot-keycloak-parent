package in.zestic.authy.app.constant;

import in.zestic.springboot.common.exception.ApplicationError;

import java.util.HashMap;
import java.util.Map;

/**
 * @author deebendukumar
 */
public enum KeycloakError implements ApplicationError {

    KEYCLOAK_NOT_ENABLED(0x0001, "Keycloak not enabled, Please annotate with @EnableKeycloak"),
    APPLICATION_EDI_X12(0x0002, "Application EDI-X12"),
    APPLICATION_EDIFACT(0x0003, "Application EDIFACT"),
    APPLICATION_JAVA_SCRIPT(0x0004, "Application JavaScript"),
    APPLICATION_OCTET_STREAM(0x0005, "Application Octet Stream"),
    APPLICATION_OGG(0x0006, "Application Ogg"),
    APPLICATION_PDF(0x0007, "Application Pdf"),
    APPLICATION_XHTML_XML(0x0008, "Application XHTML+XML"),
    APPLICATION_X_SHOCKWAVE_FLASH(0x0009, "Application x-shockwave-flash"),
    APPLICATION_LD_JSON(0x0010, "Application ld+json"),
    APPLICATION_XML(0x0011, "Application xml"),
    APPLICATION_ZIP(0x0012, "Application Zip"),
    APPLICATION_X_WWW_FORM_URLENCODED(0x0013, "Application x-www-form-urlencoded");

    private final Integer code;
    private final String message;

    private KeycloakError(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
