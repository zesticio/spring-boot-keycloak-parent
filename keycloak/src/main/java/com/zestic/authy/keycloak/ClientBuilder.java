package com.zestic.authy.keycloak;

public class ClientBuilder {

    private String clientId;
    private String clientSecret;
    private String serverUrl;
    private String realm;

    public ClientBuilder clientId(final String clientId) {
        this.clientId = clientId;
        return this;
    }

    public ClientBuilder clientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public ClientBuilder serverUrl(final String serverUrl) {
        this.serverUrl = serverUrl;
        return this;
    }

    public ClientBuilder realm(final String realm) {
        this.realm = realm;
        return this;
    }

    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

    public Client build() {
        Client client = new Client();
        client.setClientId(this.clientId);
        client.setClientSecret(this.clientSecret);
        client.setRealm(this.realm);
        client.setServerUrl(this.serverUrl);
        client.configureKeyCloak();
        return client;
    }

}
