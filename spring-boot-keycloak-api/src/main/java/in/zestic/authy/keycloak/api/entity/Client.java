package in.zestic.authy.keycloak.api.entity;

import in.zestic.common.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Entity<String, Client> {

    private String id;
    private String clientId;
    private String name;
    private String description;
    private Boolean enabled;
    private String secret;
    private Boolean bearerOnly;
    private Boolean consentRequired;
    private Boolean standardFlowEnabled;
    private Boolean implicitFlowEnabled;
    private Boolean directAccessGrantsEnabled;
    private Boolean serviceAccountsEnabled;
    private Map<String, String> attributes;
}
