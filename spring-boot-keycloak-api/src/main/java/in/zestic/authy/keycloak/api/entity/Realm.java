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
    private String name;
    private Boolean enabled;

    private Map<String, String> attributes;
}
