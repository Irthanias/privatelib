package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.util.ConnectionInfo;
import org.example.util.DatabaseConnection;
import org.example.util.JdbcDatabaseConnection;
import org.example.util.UsernamePasswordCredentials;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;


/**
 * JavaFX App
 */
public class App extends Application {

    private static final String PROPERTIES_FILE = "/db.properties";

    @Override
    public void start(Stage stage) {

        var connectionInfo = getConnectionInfo();
        databaseConnection = new JdbcDatabaseConnection(connectionInfo.getHost(), connectionInfo.getCredentials().getUsername(), connectionInfo.getCredentials().getPassword());
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private static DatabaseConnection databaseConnection;

    private static ConnectionInfo getConnectionInfo() {
        try (InputStream input = DatabaseConnection.class.getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new RuntimeException("Database configuration file not found.");
            }
            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            return new ConnectionInfo(url,new UsernamePasswordCredentials(user, password));
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static DatabaseConnection getDatabaseConnection() {
        if(null == databaseConnection) {
            throw new RuntimeException("Database has not been initialized");
        }
        return databaseConnection;
    }
}