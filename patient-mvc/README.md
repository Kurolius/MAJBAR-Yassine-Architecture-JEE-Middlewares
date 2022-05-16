# Activité pratique N°6
## (Technologie Web JEE : http, Servlet, JSP, MVC Spring MVC,Thymeleaf)
### Introduction
Dans ce travail on va commencer et initier au développement web avec le framework Spring et notamment son outil Spring Boot, et on va bien illustrer l’Architecture Web et comment l’échange des données se fait, et bien précisément l’architecture Web JEE avec le design pattern Spring MVC, et on va expérimenter cette architecture avec un rendu coté serveur avec le générateur de template Thymeleaf.
### Description :
Notre application une application qui permet de gérer des patients.
Chaque patient est défini par :
- Son ID de type Long
- Son Nom de type String
- Sa Date de naissance
- Un attribut qui indique si le patient est malade ou non
- Un score de type int
![image](https://user-images.githubusercontent.com/84138772/168592844-85df7f74-5741-471c-8209-74bfed87e596.png)
Les données sont stockées dans une base de données H2 ou MySQL
### Le modèle conceptuel de données de l’application :
![image](https://user-images.githubusercontent.com/84138772/168593035-aa2ccc0a-c751-4177-9391-b207afe58568.png)
### Architecture du projet :
![image](https://user-images.githubusercontent.com/84138772/168593406-ccd9223a-3abd-456a-a5fb-9f363fa5e7fb.png)
### Structure du projet :
![image](https://user-images.githubusercontent.com/84138772/168593778-928efec0-231e-4138-ad80-c5fcbc4ac13e.png)
### Exigences fonctionnelles
Gérer des les patients :
- Ajouter un patient
- Consulter tous les patients
- Consulter un patient
- Modifier les données d’un patient
- Supprimer un patient
- chercher les patients dont le nom contient un mot clé.
### Les vues/interfaces de notre application
#### Sign in
![image](https://user-images.githubusercontent.com/84138772/168594585-cb0a5d09-200b-4d1f-b63e-3a849d9e5144.png)
#### Liste des patients
![image](https://user-images.githubusercontent.com/84138772/168595609-2af7deb3-0c31-4229-b025-03192122c3ed.png)
#### Ajouter patient
![image](https://user-images.githubusercontent.com/84138772/168595897-d3bb3249-6dbe-474a-a84d-7a325342960d.png)
#### Modifier patient
![image](https://user-images.githubusercontent.com/84138772/168596033-5617c416-9c83-49a1-b3f8-fa7891c31ac4.png)


