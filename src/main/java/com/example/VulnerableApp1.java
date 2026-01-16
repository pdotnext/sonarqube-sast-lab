package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class VulnerableApp1 {

    public static void main(String[] args) throws Exception {
        String userInput = args[0];

        // ❌ SQL Injection vulnerability
        Connection conntest1 = DriverManager.getConnection("jdbc:h2:mem:test");
        Statement stmt = conntest1.createStatement();
        stmt.execute("SELECT * FROM users WHERE name = '" + userInput + "'");
    }
}