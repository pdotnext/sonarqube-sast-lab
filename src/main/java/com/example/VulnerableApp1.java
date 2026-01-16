package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class VulnerableApp1 {

    public static void main(String[] args) throws Exception {

        // ✅ Defensive input check
        if (args.length == 0) {
            throw new IllegalArgumentException("Username required");
        }

        String userInput = args[0];

            String sql = "SELECT Customers.name, Orders.id, Orders.price " +                   // Compliant
                          "FROM Orders JOIN Customers ON Orders.customerId = Customers.id ";

        // ✅ Proper resource handling
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userInput);
            pstmt.execute();
        }
    }
}
