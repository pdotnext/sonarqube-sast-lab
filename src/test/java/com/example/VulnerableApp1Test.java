package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VulnerableApp1Test {

    @Test
    void shouldThrowExceptionWhenNoArgsProvided() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> VulnerableApp1.main(new String[]{})
        );

        assertEquals("Username required", exception.getMessage());
    }
}
