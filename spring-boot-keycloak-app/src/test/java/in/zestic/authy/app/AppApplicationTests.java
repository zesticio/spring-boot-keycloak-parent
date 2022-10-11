package in.zestic.authy.app;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@PropertySource("classpath:application-test.properties ")
public class AppApplicationTests {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AppApplicationTests.class);

    private Keycloak keycloak;

    @Value("${keycloak.auth-server-url}")
    public String authServerUrl;
    @Value("${keycloak.realm}")
    public String realm;
    @Value("${keycloak.resource-name}")
    public String resourceName;
    @Value("${keycloak.resource-secret}")
    public String resourceSecret;
    @Value("${keycloak.connection-pool-size}")
    public Integer connectionPoolSize;

    @Before
    public void setup() {
        logger.info(authServerUrl);
        keycloak = KeycloakBuilder.builder() //
                .serverUrl(authServerUrl) //
                .realm(realm) //
                .username("deebendu.kumar@zestic.in")
                .password("HxFZPul4GO4cY6jYeTeFSCR5zvhIbFYo")
                .clientId(resourceName) //
                .clientSecret((String) resourceSecret) //
                .resteasyClient(new ResteasyClientBuilder()
                        .connectionPoolSize(connectionPoolSize)
                        .build())
                .build();
    }

    @Test
    public void contextLoads() {
        logger.info(authServerUrl);
    }

    @Test
    public void testAccessToken() {
        logger.info(keycloak.tokenManager().getAccessToken().getToken());
    }
}
