package in.zestic.authy.keycloak.api.entity;

import in.zestic.common.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Realm extends Entity<String, Realm> {

    private String id;
    private String realm;
    private String name;
    private Boolean enabled;
    private Boolean registrationAllowed;
    private Boolean loginWithEmailAllowed;
    private Boolean duplicateEmailsAllowed;
    private Boolean resetPasswordAllowed;
    private Boolean editUsernameAllowed;
    private Boolean bruteForceProtected;

    private SMTPServer smtpServer;

    private Map<String, String> attributes;
}
