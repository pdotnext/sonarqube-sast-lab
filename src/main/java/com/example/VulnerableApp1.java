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

        // ✅ Explicit column selection (NO SELECT *)
        String sql = "SELECT id, name FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userInput);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    rs.getString("name");
                }
            }
        }
    }
}
