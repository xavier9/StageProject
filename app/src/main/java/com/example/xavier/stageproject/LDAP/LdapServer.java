package com.example.xavier.stageproject.LDAP;

/**
 * Created by xavier on 23/02/2016.
 */
import com.unboundid.ldap.sdk.LDAPConnection;

public class LdapServer {

    // The port number of the directory server.
    private static final int PORT = 389;

    // The base DN to use when searching the server.
    public static final String BASE_DN = "ou=Users,dc=eeb2,dc=be";

    // The address of the directory server.
    private static final String HOST = "openldap.eeb2.be";

    private static final String BIND_DN = "domain\\username";
    private static final String BIND_PW = "123456";

    private static LDAPConnection conn;

    public static LDAPConnection getConnection() {
        if (conn == null) {
            try {

                conn = new LDAPConnection(HOST, PORT, BIND_DN, BIND_PW);
            } catch (Exception e) {

            }
        }

        return conn;
    }

}
