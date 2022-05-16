# Activité pratique N°6
## (Technologie Web JEE : http, Servlet, JSP, MVC Spring MVC,Thymeleaf) </br> Partie 2
### Introduction
Dans ce travail on va continuer dans le développement web avec le framework Spring et notamment son outil Spring Boot, et on va illustrer l’Architecture Web JEE avec le design pattern Spring MVC, et on va expérimenter cette architecture avec un rendu coté serveur avec le générateur de template Thymeleaf, aussi on va initier la sécurité avec Spring Security avec un système d’authentification.
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

### Template
Généralement toutes les page d’une application web partagent le même contenu html (Header, footer, menus, etc..) et pour éviter de faire des copies coller dans toutes les pages, il est important de définit une page Template qui définit
- Toutes les parties fixes de toutes les pages (header, footer, menus, etc...)
- Déclarer les sections qui changeront de contenue en fonction de chaque page.

#### Thymeleaf Layout Dialect Maven Dependency Pour Spring Boot
![image](https://user-images.githubusercontent.com/84138772/168598549-3d41a3be-dfee-4799-8327-54ad104c369f.png)
#### Créer une page html "template"
##### ajouter le dialect thyemeleaf
![image](https://user-images.githubusercontent.com/84138772/168599591-a2071859-d7cf-4feb-a7a9-6435cb6671c4.png)
##### ajouter la section dans la page template
![image](https://user-images.githubusercontent.com/84138772/168599775-68571ee9-4827-43f2-953d-2d0f0dadec5d.png)
#### Utilliser la page template dans une autre page
##### ajouter le dialect thyemeleaf dans la page
![image](https://user-images.githubusercontent.com/84138772/168600534-79c686f1-7dc4-44a7-bea9-d35b9a0904ba.png)
##### coder la div
![image](https://user-images.githubusercontent.com/84138772/168600933-4d6262d4-efd0-4702-9607-262b1d6411b5.png)

**_NOTE:_**  c'est a l'interieure de cette balise qu'on code notre page .

### Les vues/interfaces de notre application
#### Sign in
![image](https://user-images.githubusercontent.com/84138772/168594585-cb0a5d09-200b-4d1f-b63e-3a849d9e5144.png)
#### Liste des patients
![image](https://user-images.githubusercontent.com/84138772/168595609-2af7deb3-0c31-4229-b025-03192122c3ed.png)
#### Ajouter patient
![image](https://user-images.githubusercontent.com/84138772/168595897-d3bb3249-6dbe-474a-a84d-7a325342960d.png)
#### Modifier patient
![image](https://user-images.githubusercontent.com/84138772/168596033-5617c416-9c83-49a1-b3f8-fa7891c31ac4.png)
