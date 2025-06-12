package com.userdata;

import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        try {
            InputReader reader = new InputReader();
            Map<String, String> rawInput = reader.readFromConsole();

            DataProcessor processor = new DataProcessor();
            User user = processor.preprocess(rawInput);

            String hostUrl = "jdbc:mysql://localhost:3306/";
            String dbName = "userdb";
            String dbUser = "root";
            String dbPassword = "Admin@12345";

            DatabaseHandler db = new DatabaseHandler(hostUrl, dbUser, dbPassword, dbName);

            db.insertUser(user);
            db.close();

            System.out.println("User data saved successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
