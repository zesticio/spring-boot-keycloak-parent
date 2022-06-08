# authy
Identity and access management for Enterprise
This application is to administrate users based on a central KEYCLOAK server. 

Step 1: Download and install keycloak
####https://www.youtube.com/watch?v=HOwoNMoQkmw
Create initial admin user
Username - Admin
Password - admin

##Preconditions
### Keycloak installation and configuration
* Create a realm __customers__
* Create client __api-services__ to secure microservices
    * Client ID - api-services
    * Name - api-services
    * Description - This is to secure microservices
    * Enabled - On
    * Consent Required - Off
    * Login Theme - Keycloak
    * Client Protocol - openid-connect
    * Access Type - bearer-only
    * Front Channel Logout - Off
    * Admin Url - http://127.0.0.1:9080/
    * Add role __user-admin-user__ and __user-admin-admin__
    

* Create client "__frontend__"
    * Enabled - __On__
    * Client protocol: **openid-connect**
    * Access Type: **public**
    * Standard workflow enabled: **On**
    * Direct Access Grants Enabled: **On**
    * Root URL: **http://127.0.0.1:9090**
    * Valid Redirect URIs: **http://127.0.0.1:9090/***
    * Admin URL: **http://localhost:4200**
    * Web Origins: **http://localhost:4200**


* Create client __backend__
    * Enabled: __On__
    * Client protocol: **openid-connect**
    * Access Type: **confidential**
    * Standard workflow enabled: **On**
    * Direct Access Grants Enabled: **On**
    * Root URL: **http://localhost:9090**
    * Valid Redirect URIs: **http://localhost:9090/***
    * Admin URL: **http://localhost:9090**
    * Web Origins: **http://localhost:9090**
    * Generate __Secret__ in __Credentials tab__






Step 2: Login using admin user

Step 3: Create a new Realm, Under general set enabled = true, User-Managed Access = false, In Realm settings under 
login tab i have set require SSL = none. If its set to none all your APIs will be on http. You can also configure 
email server configuration in email tab. Normally keycloak uses email server to verify user email. In this section 
you can configure email server.
####https://www.youtube.com/watch?v=tJc-gHnfEp4
####https://www.youtube.com/watch?v=J0GWqfhs4ys

Step 4: Creating user
####https://www.youtube.com/watch?v=qlr6u_l_HQY

###Do Keycloak Clients have a Client Secret?
####Your client need to have the access-type set to confidential , then you will have a new tab credentials where you will see the client secret.

After we create a user we need to add roles to that user. Goto Role mapping select client roles - "realm-management" from 
available roles select "realm-admin" role for this user.



