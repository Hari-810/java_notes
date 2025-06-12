package com.userdata;

public class User {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String gender;
    private String country;
    private String dateOfBirth;

    public User(String name, int age, String email, String phone,
                String gender, String country, String dateOfBirth) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
    }

    // Add getters (optional, used by DatabaseHandler)
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getGender() { return gender; }
    public String getCountry() { return country; }
    public String getDateOfBirth() { return dateOfBirth; }
}
