package org.example.util;

import java.sql.Connection;

public interface DatabaseConnection {
    Connection open() throws UserInvalidException, DatabaseNotFoundException;
    Connection getConnection();
}
