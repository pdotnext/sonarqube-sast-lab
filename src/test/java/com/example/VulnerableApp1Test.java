package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class VulnerableApp1Test {

    @BeforeEach
    void setupDatabase() throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    id INT PRIMARY KEY,
                    name VARCHAR(255)
                )
            """);
            stmt.execute("DELETE FROM users");
            stmt.execute("INSERT INTO users (id, name) VALUES (1, 'john')");
        }
    }

    @Test
    void shouldFailWhenNoArgsProvided() {
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> VulnerableApp1.main(new String[]{})
        );
        assertEquals("Username required", ex.getMessage());
    }

    @Test
    void shouldExecuteQueryWhenArgProvided() throws Exception {
        VulnerableApp1.main(new String[]{"john"});
    }
}
