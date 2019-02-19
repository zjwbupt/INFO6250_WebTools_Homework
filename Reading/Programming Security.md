# Programming Security

- Combining Container-Managed and Programmatic Security
- Using the *isUserInRole* method
- Using the *getRemoteUser* method
- Using the *getuserPrincipal* method
- Programmatically controlling all aspect of security
- Using SSL with programmatic security

## Declarative Security

- Preventing unauthorized users from **accessing** sensitive data

- preventing attackers from stealing network data while it is in **transit**


## Combining Container-Managed And Programmatic Security

The Declarative Security:

- Either allowed or denied.
- Provide no option to customize the output depending the role of client.

There are 3 methods in *HttpServletRequest*:

1. *isUserInRole*

   If user login successfully, 

   ```java
   request.isUserInRole("lowStatus");
   request.isUserInRole("nobleSpirited")
   ```

   will return true;

2. *getRemoteUser*

    This method returns the name of the current user. For example, if the client has successfully logged in as user `valjean`, `request.getRemoteUser()` would return `“valjean”`.

3. *getUserPrincipal*

    This method returns the current username wrapped inside a `java.security.Principal` object. The `Principal` object contains little information beyond the username (available with the `getName` method). So, the main reason for using `getUserPrincipal` in lieu of `getRemoteUser` is to be compatible with preexisting security code (the `Principal` class is not specific to the servlet and JSP API and has been part of the Java platform since version 1.1). 

