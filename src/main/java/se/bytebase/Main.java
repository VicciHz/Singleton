package se.bytebase;

// TODO: Database can be instantiated multiple times — wasting connections.
// Make it a singleton: private constructor, static field, static getInstance().
// BONUS: Make the singleton thread-safe.
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
