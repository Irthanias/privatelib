package org.example.util;

public class ConnectionInfo {
    private final String host;
    private final UsernamePasswordCredentials credentials;


    public ConnectionInfo(String host, UsernamePasswordCredentials credentials) {
        this.host = host;
        this.credentials = credentials;
    }

    public String getHost() {
        return host;
    }

    public UsernamePasswordCredentials getCredentials() {
        return credentials;
    }
}
