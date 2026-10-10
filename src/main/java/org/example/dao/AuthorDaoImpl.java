package org.example.dao;

import org.example.models.Author;
import org.example.util.DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public final class AuthorDaoImpl {
    private final DatabaseConnection connection;

    public AuthorDaoImpl(DatabaseConnection connection) {
        this.connection = connection;
    }

    public Author getAuthorById(int id) {
        var conn = connection.getConnection();
        String sql = "SELECT writer_id, first_name, last_name FROM writer WHERE writer_id=?";

        //var = datatype er inferred
        try (var stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            var results = stmt.executeQuery();

            if (!results.next()){
                throw new RuntimeException("No author with ID " + id);
            }

            var author = new Author();
            author.setId(results.getInt(1));
            author.setFirstName(results.getString(2));
            author.setLastName(results.getString(3));

            return author;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Author> getAuthorByName(String firstName, String lastName) {
        var conn = connection.getConnection();
        String sql = "SELECT writer_id, first_name, last_name FROM writer WHERE (first_name != '' and first_name LIKE ? OR last_name != '' and last_name LIKE ?)";

        //var = datatype er inferred
        try (var stmt = conn.prepareStatement(sql)) {
            var authors = new ArrayList<Author>();
            stmt.setString(1, firstName);
            stmt.setString(2,lastName);
            var results = stmt.executeQuery();

            while (results.next()){
                var author = new Author();
                author.setId(results.getInt(1));
                author.setFirstName(results.getString(2));
                author.setLastName(results.getString(3));

                authors.add(author);
            }
            return authors;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
