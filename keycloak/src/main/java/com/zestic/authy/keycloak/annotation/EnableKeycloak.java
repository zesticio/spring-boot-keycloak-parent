package com.zestic.authy.keycloak.annotation;

import com.zestic.authy.keycloak.config.KeycloakAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Add the @Import annotation to your @Pcap4J annotation class and pass in your configuration class
 * This should result in the config only being loaded when the annotation is present
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({KeycloakAutoConfiguration.class})
public @interface EnableKeycloak {
}
