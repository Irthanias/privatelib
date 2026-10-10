package org.example.dao;

import org.example.models.Author;
import org.example.util.DatabaseConnection;

import java.sql.SQLException;

public final class AuthorDaoImpl {
    private final DatabaseConnection connection;

    public AuthorDaoImpl(DatabaseConnection connection) {
        this.connection = connection;
    }

    public Author getAuthorById(int id) {
        var conn = connection.getConnection();
        String sql = "SELECT first_name, last_name FROM writer WHERE writer_id=?";

        //var = datatype er infered
        try (var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            var results = stmt.executeQuery();

            if (!results.next()){
                throw new RuntimeException("No author with ID " + id);
            }
            var firstName = results.getString(1);
            var lastName = results.getString(2);

            var author = new Author();
            author.setId(id);
            author.setFirstName(firstName);
            author.setLastName(lastName);

            return author;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
