echo 'Startar docker databasen'
docker compose up --build -d

echo 'Kompelerar java appen'
mvn clean package

echo 'startar singleton'
clear
java -jar ./target/Singleton-1.0-SNAPSHOT.jar
