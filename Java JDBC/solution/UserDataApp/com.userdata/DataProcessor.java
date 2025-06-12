package com.userdata;

import java.util.Map;

public class DataProcessor {

    public User preprocess(Map<String, String> rawData) {
        String name = rawData.get("name").trim();
        int age = Integer.parseInt(rawData.get("age").trim());
        if (age < 0 || age > 120) throw new IllegalArgumentException("Invalid age");

        String email = rawData.get("email").trim().toLowerCase();
        if (!email.matches("^\\S+@\\S+\\.\\S+$")) throw new IllegalArgumentException("Invalid email");

        String phone = rawData.get("phone").replaceAll("[^0-9]", "");
        if (phone.length() < 10) throw new IllegalArgumentException("Invalid phone");

        String gender = normalizeGender(rawData.get("gender"));
        String country = capitalize(rawData.get("country").trim());
        String dob = rawData.get("dob");

        return new User(name, age, email, phone, gender, country, dob);
    }

    private String normalizeGender(String gender) {
        gender = gender.trim().toLowerCase();
        if (gender.equals("m") || gender.equals("male")) return "Male";
        if (gender.equals("f") || gender.equals("female")) return "Female";
        return "Other";
    }

    private String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
