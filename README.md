# authy
Identity and access management for Enterprise

Step 1: Download and install keycloak
####https://www.youtube.com/watch?v=HOwoNMoQkmw
Create initial admin user
Username - Admin
Password - admin

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

