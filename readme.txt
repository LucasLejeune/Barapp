Installation du projet:
- Dans une invite de commande se rendre à la racine du projet
- Entrer la commande: docker-compose up -d 
- Ouvrir MySqlWorkbench puis importer la base de donnée depuis le fichier .sql
- Toujours à la racine éxécuter la commande: mvn spring-boot:run
- Ensuite éxécuter la commande: cd Bar-app
- Puis éxécuter la commande: npm run dev
- Vous pouvez ensuite accéder au site en tant que client via l'url suivante: http://localhost:5173/?table=1
- Vous pouvez ensuite accéder au site en tant que barmaker via l'url suivante: http://localhost:5173/commands?barmaker=1