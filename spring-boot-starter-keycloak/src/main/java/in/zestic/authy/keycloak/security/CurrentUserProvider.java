package in.zestic.authy.keycloak.security;

import in.zestic.authy.keycloak.api.entity.User;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collection;

@Configuration
public class CurrentUserProvider {

    @SuppressWarnings("unchecked")
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST)
    public User getCurrentUser() {
        User user = new User();
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userId = principal.getKeycloakSecurityContext().getToken().getSubject();
        String username = principal.toString();
        String email = principal.getKeycloakSecurityContext().getToken().getEmail();
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        user.setId(userId);
        user.setUsername(username);
        user.setEmail(email);
        return user;
    }
}
