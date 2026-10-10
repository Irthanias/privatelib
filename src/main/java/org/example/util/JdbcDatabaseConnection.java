package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//klasse som implementerer jdbc for databasetilkoblinger

public class JdbcDatabaseConnection implements DatabaseConnection {
    private final String url;
    private final String user;
    private final String password;

    //gjeldende tilkoblingen
    private Connection currentConnection;

    //dette her er contructor
    public JdbcDatabaseConnection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    //kobler til databasen. User invalid når brukernavn eller passord er feil. Not found når database "ikke finnes".
    @Override
    public Connection open() throws UserInvalidException,DatabaseNotFoundException{
        try {
            currentConnection = DriverManager.getConnection(url, user, password);
            return currentConnection;
        } catch (SQLException e) {
            if(e.getErrorCode()==1045){
                throw new UserInvalidException();
            }
            throw new DatabaseNotFoundException();
        }
    }

    @Override
    public Connection getConnection(){
        if (currentConnection!=null){
            return currentConnection;
        }
        throw new RuntimeException("The connection hasn't been opened yet.");
    }
}
