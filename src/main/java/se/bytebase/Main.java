package se.bytebase;

// Goal: Make the database connection into a singleton
public class Main {
  public static void main(String[] args) {
    String url = "jdbc:postgresql://localhost:5432/singleton_db";
    String user = "postgres";
    String pass = "1234";

    Database db = new Database(url, user, pass);

    db.registerUser("Jack", "jack@fake.se");
    db.registerUser("Leon", "leon@fake.se");

    db.listAllUsers();
  }
}
