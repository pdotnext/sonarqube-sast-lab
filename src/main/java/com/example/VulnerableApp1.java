package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class VulnerableApp1 {

    public static void main(String[] args) throws Exception {
        String userInput = args[0];

        // ❌ SQL Injection vulnerability
        Connection conntest1 = DriverManager.getConnection("jdbc:h2:mem:test");
        String sql = "SELECT * FROM users WHERE name =?";
        PreparedStatement pstmt = conntest1.prepareStatement(sql);
        pstmt.setString(1, userInput);
        pstmt.execute();
    }
}