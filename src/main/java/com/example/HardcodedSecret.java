package com.example;

public class HardcodedSecret {

    public static void main(String[] args) {
        // ❌ CRITICAL: Hard-coded credentials
        String dbUser = "admin";
        String dbPassword = "P@ssw0rd123";

        System.out.println("Connecting as " + dbUser);
    }
}
