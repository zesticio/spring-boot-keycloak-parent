package in.zestic.authy.keycloak.config;

import in.zestic.authy.keycloak.security.CustomKeycloakSpringBootConfigResolver;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.management.HttpSessionManager;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.security.Principal;

@Profile("!test")
@Order(1)
@ComponentScan
@KeycloakConfiguration
@EnableGlobalMethodSecurity(jsr250Enabled = true) //this will allow role based authentication
@EnableConfigurationProperties(KeycloakSpringBootProperties.class)
public class KeycloakSecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(KeycloakSecurityConfiguration.class.getSimpleName());

    public KeycloakSecurityConfiguration() {
    }

    /**
     * Registers the KeycloakAuthenticationProvider with the authentication manager.
     * We have extended user authentication using below
     * @param auth AuthenticationManagerBuilder
     * @throws Exception Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        SimpleAuthorityMapper grantedAuthorityMapper = new SimpleAuthorityMapper();
        grantedAuthorityMapper.setPrefix("ROLE_");
        grantedAuthorityMapper.setConvertToUpperCase(true);

        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(grantedAuthorityMapper);
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    /**
     *
     * @return SessionAuthenticationStrategy
     */
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(buildSessionRegistry());
    }

    @Bean
    @Override
    @ConditionalOnMissingBean(HttpSessionManager.class)
    protected HttpSessionManager httpSessionManager() {
        return new HttpSessionManager();
    }

    /**
     *
     * @return SessionRegistry
     */
    @Bean
    protected SessionRegistry buildSessionRegistry() {
        return new SessionRegistryImpl();
    }

    /**
     * TODO
     * @param http HttpSecurity
     * @throws Exception Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                //whitelist for every user where they are login or not
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                //only allowing admin to access endpoints starting with /admin
                //.antMatchers("/admin*").hasRole("ADMIN")
                .anyRequest().authenticated();
        http.csrf().disable();
    }

    /**
     *
     * @param properties KeycloakSpringBootProperties
     * @return KeycloakConfigResolver
     */
    @Bean
    @Primary
    public KeycloakConfigResolver keycloakConfigResolver(KeycloakSpringBootProperties properties) {
        return new CustomKeycloakSpringBootConfigResolver(properties);
    }

    /**
     *
     * @return KeycloakSecurityContext
     */
    @Bean
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public KeycloakSecurityContext provideKeycloakSecurityContext() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Principal principal = attributes.getRequest().getUserPrincipal();
        if (principal == null) {
            return null;
        }

        if (principal instanceof KeycloakAuthenticationToken) {
            principal = Principal.class.cast(KeycloakAuthenticationToken.class.cast(principal).getPrincipal());
        }

        if (principal instanceof KeycloakPrincipal) {
            return KeycloakPrincipal.class.cast(principal).getKeycloakSecurityContext();
        }
        return null;
    }
}
