create database keycloak;
create user keycloak with encrypted password 'keycloakrw';
grant all privileges on database keycloak to keycloak;