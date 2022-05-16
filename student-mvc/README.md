# Activité pratique N°9
## (Activité Pratique Spring MVC, Spring Data JPA, Spring Security)
### Introduction
Dans cette application Web basée sur Spring MVC, Spring Data JPA et Spring Security on aura l'occasion de voir comment faire la gestion des etudiants.
### Description :
Notre application une application qui permet de gérer des etudiants.
Chaque etudiant est défini par :
- Son ID de type Long
- Son Nom de type String
- Son Prenom de type String
- Son email
- Sa Date de naissance
 - Son genre : MASCULIN ou FEMININ
 - Un attribut qui indique si il est en règle ou non

![image](https://user-images.githubusercontent.com/84138772/168612300-7f47ef41-aa39-4864-ba3e-f479cd28c322.png)

### Exigences fonctionnelles
Gérer des les etudiants :
- Chercher des étudiants par nom.
- la pagination entre les une taille bien précis des étudiants.
- La suppression des étudiants en utilisant la méthode (DELETE au lieu de GET).
- L'ajout des étudiants avec validation des formulaires.
- L'édition et la mis à jour des étudiants.
- La Création d'une page template.

### Structure du projet
![image](https://user-images.githubusercontent.com/84138772/168613529-c560547e-8656-4fb0-8ee9-726d1bdbe233.png)

### La sécurité avec Spring Security
#### La classe implémentation de UserDetailsService UserDetailsServiceImpl

![image](https://user-images.githubusercontent.com/84138772/168614028-6592f661-7112-4984-83e3-ced9edfd3ea4.png)

#### La classe de configuration de la sécurité

![image](https://user-images.githubusercontent.com/84138772/168614313-b3873049-7428-4169-a347-215172c92198.png)


### Les vues/interfaces de notre application
#### Sign in
![image](https://user-images.githubusercontent.com/84138772/168594585-cb0a5d09-200b-4d1f-b63e-3a849d9e5144.png)
#### Liste des etudiants
![image](https://user-images.githubusercontent.com/84138772/168615069-bde5637a-aea1-4112-aa3e-4aa043d03732.png)
#### Ajouter etudiants
![image](https://user-images.githubusercontent.com/84138772/168615270-80af70ff-e932-479e-967e-b8bd9498003f.png)
#### Modifier etudiants
![image](https://user-images.githubusercontent.com/84138772/168615391-dd5972da-edae-45f4-8366-1928a4e9a25f.png)
