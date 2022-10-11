package in.zestic.authy.app.constant;

import in.zestic.common.exception.ApplicationError;
import in.zestic.common.util.HTTPErrorCodes;
import lombok.Getter;

/**
 * @author deebendukumar
 */
@Getter
public enum KeycloakError implements ApplicationError {

    KEYCLOAK_UNABLE_TO_CONNECT(0x0001, "Unable to connect keycloak server"),
    KEYCLOAK_UNAUTHORIZED(0x0191, "Unauthorized"),
    KEYCLOAK_FORBIDDEN(0x0193, "Forbidden"),
    KEYCLOAK_INTERNAL_SERVER_ERROR(0x01F4, "Internal server error"),
    KEYCLOAK_NOT_ENABLED(0x8001, "Keycloak not enabled, Please annotate with @EnableKeycloak"),
    APPLICATION_EDI_X12(0x8002, "Application EDI-X12"),
    APPLICATION_EDIFACT(0x8003, "Application EDIFACT"),
    APPLICATION_JAVA_SCRIPT(0x8004, "Application JavaScript"),
    APPLICATION_OCTET_STREAM(0x8005, "Application Octet Stream"),
    APPLICATION_OGG(0x8006, "Application Ogg"),
    APPLICATION_PDF(0x8007, "Application Pdf"),
    APPLICATION_XHTML_XML(0x8008, "Application XHTML+XML"),
    APPLICATION_X_SHOCKWAVE_FLASH(0x8009, "Application x-shockwave-flash"),
    APPLICATION_LD_JSON(0x8010, "Application ld+json"),
    APPLICATION_XML(0x8011, "Application xml"),
    APPLICATION_ZIP(0x8012, "Application Zip"),
    APPLICATION_X_WWW_FORM_URLENCODED(0x8013, "Application x-www-form-urlencoded");

    private final Integer code;
    private final String message;

    KeycloakError(final Integer code, final String message) {
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
