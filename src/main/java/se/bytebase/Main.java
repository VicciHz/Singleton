package se.bytebase;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String url = "jdbc:postgresql://localhost:5432/singleton_db";
    String user = "postgres";
    String pass = "1234";

    Database db1 = Database.getInstance(url, user, pass);
    Database db2 = Database.getInstance(url, user, pass);

    db1.registerUser("Jack", "jack@fake.se");
    db2.registerUser("Leon", "leon@fake.se");

    db2.listAllUsers();
  }
}
