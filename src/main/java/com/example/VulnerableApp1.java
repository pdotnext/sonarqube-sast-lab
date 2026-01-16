Statement stmt = connection.createStatement();
String query = "SELECT * FROM users WHERE id = " + userInput;
stmt.execute(query);