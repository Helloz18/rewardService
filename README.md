##Dockeriser ce service
- ajouter un fichier Dockerfile (attention, la casse dans le nom du fichier est importante)

création du fichier Dockerfile à la racine du projet rewardService

insertion des infos suivantes :

FROM java:8-jdk-alpine

MAINTAINER heloise

COPY target/TourGuide-0.0.1-SNAPSHOT.jar TourGuide-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/rewardService-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080

- création du jar de rewardService

mvn clean package

- création de l’image docker via la commande

docker build --tag=rewardservice:latest .

(le tag doit être en miniscule)

- lancement de l’image via la commande

docker run -p5000:8080 rewardservice:latest

l’image tourne sur le port 5000 à l’adresse localhost:5000
