package com.userdata;
import java.util.*;

public class InputReader {
    public Map<String, String> readFromConsole() {
        Map<String, String> data = new HashMap<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Name: ");
            data.put("name", sc.nextLine());

            System.out.print("Enter Age: ");
            data.put("age", sc.nextLine());

            System.out.print("Enter Email: ");
            data.put("email", sc.nextLine());

            System.out.print("Enter Phone: ");
            data.put("phone", sc.nextLine());

            System.out.print("Enter Gender: ");
            data.put("gender", sc.nextLine());

            System.out.print("Enter Country: ");
            data.put("country", sc.nextLine());

            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            data.put("dob", sc.nextLine());
        }

        return data;
    }
}
