package in.zestic.authy.keycloak.api.entity;

import in.zestic.common.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SMTPServer extends Entity<String, SMTPServer> {

    private String id;
    private String password;
    private String replyToDisplayName;
    private String starttls;
    private String auth;
    private String port;
    private String host;
    private String replyTo;
    private String from;
    private String fromDisplayName;
    private String ssl;
    private String user;

    private Map<String, List<String>> attributes;
}
