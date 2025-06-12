package com.userdata;

import java.sql.*;

public class DatabaseHandler {
    private Connection conn;
    private String dbName;

    public DatabaseHandler(String hostUrl, String user, String password, String dbName) throws SQLException {
        this.dbName = dbName;
        // Step 1: Connect to MySQL server (no DB yet)
        Connection serverConn = DriverManager.getConnection(hostUrl, user, password);
        createDatabaseIfNotExists(serverConn);
        serverConn.close();

        // Step 2: Connect to the target DB
        conn = DriverManager.getConnection(hostUrl + "/" + dbName, user, password);

        // Step 3: Ensure table exists
        createTableIfNotExists();
    }

    private void createDatabaseIfNotExists(Connection connection) throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    private void createTableIfNotExists() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100),
                age INT,
                email VARCHAR(100),
                phone VARCHAR(20),
                gender VARCHAR(10),
                country VARCHAR(50),
                dob DATE
            )
        """;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    public void insertUser(User user) throws SQLException {
        String sql = """
            INSERT INTO users (name, age, email, phone, gender, country, dob)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getGender());
            stmt.setString(6, user.getCountry());
            stmt.setString(7, user.getDateOfBirth());
            stmt.executeUpdate();
        }
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
