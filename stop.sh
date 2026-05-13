echo 'Stoppar docker'
docker compose down --remove-orphans -v

echo 'Tar bort volymen'
sudo rm -r ./singleton_db_data/
