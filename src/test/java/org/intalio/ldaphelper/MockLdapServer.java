package org.intalio.ldaphelper;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;

public class MockLdapServer {

    static InMemoryDirectoryServer server;
    static LDAPConnection conn;

    public void shutdown() {

        if (server != null)
            server.shutDown(true);

    }

    public LDAPConnection configureandStartServer() {

        try {

            InMemoryDirectoryServerConfig sConfig = new InMemoryDirectoryServerConfig("ou=People,dc=examples,dc=com");
            sConfig.addAdditionalBindCredentials("uid=admin,ou=system", "secret");

            // Create and start the server instance and populate it with an
            // initial set of data from the file "/tmp/test.ldif".
            server = new InMemoryDirectoryServer(sConfig);
            server.importFromLDIF(true, "/tmp/test.ldif");

            // Start the server so it will accept client connections.
            server.startListening();

            // Get a connection to the server.
            conn =  server.getConnection();
            

        } catch (LDAPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection() {
        // Close the connection.
        conn.close();

    }

    // Create a base configuration for the server.

    public static void main(String[] args) {

    }

}
