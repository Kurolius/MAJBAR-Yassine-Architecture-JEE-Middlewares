# Activité pratique N°8
## (Technologie Web JEE : http, Servlet, JSP, MVC Spring MVC,Thymeleaf) </br> Partie 3
### Introduction
Dans ce travail on va continuer dans le développement web avec le framework Spring et notamment son outil Spring Boot, et on va illustrer l’Architecture Web JEE avec le design pattern Spring MVC, et on va expérimenter cette architecture avec un rendu coté serveur avec le générateur de template Thymeleaf, aussi on va initier la sécurité avec Spring Security avec un système d’authentification.
Dans cette 3éme partie, on va faire une authentification avec avec le service « User Details Service » après avoir expérimenter les 2 méthodes :
- Authentification en mémoire
- Authentification avec JDBC
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

### Gestion d’authentification avec User Details Service
#### La classe Utilisateurs
![image](https://user-images.githubusercontent.com/84138772/168604149-e110b2cc-8104-4b83-9498-1bf3509f904b.png)
#### La classe Role
![image](https://user-images.githubusercontent.com/84138772/168604230-5d94420f-f4b1-400b-99c5-cf8c0e61033a.png)
#### Les interfaces repositories
![image](https://user-images.githubusercontent.com/84138772/168604547-05f2f9a4-4368-4847-8c7d-f25f894e1242.png)
![image](https://user-images.githubusercontent.com/84138772/168604645-8baacecf-986b-4063-8b6c-66b8b6a39f4e.png)

> **_NOTE:_** C'est ces interfaces qui vont declarer les signatures des méthodes nécessaires
#### La sécurité
![image](https://user-images.githubusercontent.com/84138772/168605292-5a11114b-2b1b-4bb3-b8bd-bf7cf30f7210.png)

> **_NOTE:_** Interface ‘SecurityService’ qui va declarer les signatures des méthodes pour les traitements des utilisateurs et ses roles

Implementation de l’interface SecurityService :

![image](https://user-images.githubusercontent.com/84138772/168606430-ef166e61-9555-4a89-82f2-944cd885002f.png)

La classe UserDetailsServiceImpl :

![image](https://user-images.githubusercontent.com/84138772/168607214-0ccda638-43c8-4146-9a9c-24f83ee6e284.png)


> **_NOTE:_** La classe UserDetailsServiceImpl hérite de l’interface ‘UserDetailsService’:

Ensuite dans la classe de configuration de sécurité on va déclarer un objet de UserDetailsServiceImpl et on va faire un l’injection des dépendances avec l’annotation @Autowired:

![image](https://user-images.githubusercontent.com/84138772/168607760-1cfa5e70-4c21-41d8-9546-b3b0086e822c.png)

Puis dans la méthode configure :

![image](https://user-images.githubusercontent.com/84138772/168607943-377d65cf-6ebf-4d21-957c-6710ac745b4f.png)


### Les vues/interfaces de notre application
#### Sign in
![image](https://user-images.githubusercontent.com/84138772/168594585-cb0a5d09-200b-4d1f-b63e-3a849d9e5144.png)
#### Liste des patients
![image](https://user-images.githubusercontent.com/84138772/168595609-2af7deb3-0c31-4229-b025-03192122c3ed.png)
#### Ajouter patient
![image](https://user-images.githubusercontent.com/84138772/168595897-d3bb3249-6dbe-474a-a84d-7a325342960d.png)
#### Modifier patient
![image](https://user-images.githubusercontent.com/84138772/168596033-5617c416-9c83-49a1-b3f8-fa7891c31ac4.png)
