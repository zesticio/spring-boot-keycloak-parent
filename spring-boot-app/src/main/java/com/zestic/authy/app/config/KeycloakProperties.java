/*
 * Version:  1.0.0
 *
 * Authors:  Kumar <Deebendu Kumar>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zestic.authy.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author deebendukumar
 */
@Data
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakProperties implements Serializable {

    private Boolean enabled = true;
    private String realm = "zestic";
    private String resourceName = "admin";
    private String resourceSecret = "6Rj0dV0YcXPYev8t7gS4aQ9AqAJVRJJy";
    private String authServerUrl = "admin";
    private Integer connectionPoolSize = 16;
    private Integer socketTimeout = 5000;
    private Integer connectionTimeout = 5000;

    private String username;
    private String password;
}
