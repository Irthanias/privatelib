package org.example.util;

public final class UsernamePasswordCredentials {
    private final String username;
    private final String password;

    public UsernamePasswordCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return username.hashCode() ^ password.hashCode() * 1023;
    }
}
