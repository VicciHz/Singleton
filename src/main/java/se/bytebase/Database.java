package se.bytebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Database {
  public Connection connection;

  public Database(String url, String user, String pass) {
    try {
      this.connection = DriverManager.getConnection(url, user, pass);
    } catch (SQLException e) {
      throw new RuntimeException("Database connection failed", e);
    }
  }

  public void registerUser(String username, String email) {
    String sql = "INSERT INTO users (username, email) VALUES (?, ?) ON CONFLICT (email) DO NOTHING";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
      pstmt.setString(1, username);
      pstmt.setString(2, email);
      int rows = pstmt.executeUpdate();
      if (rows > 0) {
        System.out.println("User registered: " + username + ", " + email);
      } else {
        System.out.println("User already exists, skipping: " + email);
      }
    } catch (SQLException e) {
      System.err.println("Error registering user: " + e.getMessage());
    }
  }

  public void listAllUsers() {
    String sql = "SELECT id, username, email, created_at FROM users";
    try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

      System.out.println("\n--- USER DIRECTORY ---");
      while (rs.next()) {
        System.out.printf("ID: %d | Username: %-12s | Email: %-20s%n",
            rs.getInt("id"), rs.getString("username"), rs.getString("email"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
