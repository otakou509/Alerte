# Utilise une image officielle OpenJDK 21 légère
FROM openjdk:21-jdk-slim

# Argument pour le jar généré dans /target
ARG JAR_FILE=target/*.jar

# Copie le jar dans l'image
COPY ${JAR_FILE} app.jar

# Commande pour lancer l'application
ENTRYPOINT ["java","-jar","/app.jar"]
