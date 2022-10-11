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
public class User extends Entity<String, User> {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String msisdn;
    private String passport;

    private Map<String, List<String>> attributes;
}
