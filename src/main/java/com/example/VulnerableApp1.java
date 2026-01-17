package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VulnerableApp1 {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            throw new IllegalArgumentException("Username required");
        }

        String userInput = args[0];

        String sql = "SELECT * FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userInput);

            // ✅ IMPORTANT CHANGE
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // process results (even if empty)
                rs.getString(1);
            }
        }
    }
}
