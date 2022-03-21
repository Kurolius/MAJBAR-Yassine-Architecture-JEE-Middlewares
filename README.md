# MAJBAR-Yassine-Architecture-JEE-Middlewares
## Activité pratique N°1
### (Inversion de contrôle et Injection des dépendances)
#### Introduction :
Dans ce premier chapitre on a pu étudier les différents types de couplage (couplage fort / couplage faible) et les différentes manières d’injection de contrôle et injection de dépendances.
c’est ce qu’on va essayer de mettre en pratique dans cette activité.

#### Packages :
![image10](https://user-images.githubusercontent.com/84138772/156883912-79e5f5b7-f965-40f6-8fd8-5828fbca82b2.png)

#### Code :
##### Interface DAO :
![image2](https://user-images.githubusercontent.com/84138772/156883943-e3cb503c-7d29-4665-ae77-95602b256c58.png)
##### Implémentation de l’interface DAO :
![image4](https://user-images.githubusercontent.com/84138772/156883963-d480e2c7-ccaa-4ad0-a501-b075d2c85c44.png)
##### Interface métier :
![image6](https://user-images.githubusercontent.com/84138772/156883983-845f3401-0323-4920-8b49-717b983b0842.png)
##### Implémentation de l’interface métier :
![image9](https://user-images.githubusercontent.com/84138772/156883999-054e3c6c-25ee-4817-87a6-79d616a8dfa8.png)


###### Injection de l’interface IDao
![image1](https://user-images.githubusercontent.com/84138772/156884004-4fa5e5b2-74d7-44e2-9b2a-6bb6bfdfe5ab.png)

##### instanciation statique :
![image5](https://user-images.githubusercontent.com/84138772/156884132-bcbb5f51-1589-40dc-b85d-e12739a89099.png)
##### instanciation dynamique :
![image7](https://user-images.githubusercontent.com/84138772/156884153-368bfb44-5fb3-4fab-9269-0e38117cc519.png)
##### En utilisant le Framework Spring (Version XML) : 
![image3](https://user-images.githubusercontent.com/84138772/156884172-0bd09d00-aea4-4d47-9dcd-c47b1de87832.png)
##### En utilisant le Framework Spring (Version annotations) :
![image8](https://user-images.githubusercontent.com/84138772/156884185-c4f3ae9b-dd51-4ca4-be57-91adbc8cba01.png)


**Note :** notez bien que dans la version annotation il est obligatoire d’utiliser les annotations @Component et @Autowired  dans les implémentations des interfaces DAO et Metier .

## Activité pratique N°2
#### Introduction
Dans ce chapitre on a vu le  Mapping Objet Relationnel (ORM).
#### L’architecture du projet :
![0](https://user-images.githubusercontent.com/84138772/159248745-a95da50b-e6bd-40ad-9e43-65a39c0d1038.png)

#### Les entités JPA :
##### Entité Patient:
![1](https://user-images.githubusercontent.com/84138772/159248793-c61cd165-ea6f-4151-afee-0805681e98fc.png)
#### Les interfaces JPA :
##### PatientRepository :
![2](https://user-images.githubusercontent.com/84138772/159248817-3906283a-a5d5-421f-9a37-13a0f8298aa9.png)
#### Resultat :
![3](https://user-images.githubusercontent.com/84138772/159248829-c903b960-22f4-499d-b700-08b2d5728d85.png)
## Activité pratique N°3
### (ORM JPA Hibernate SpringData)
#### Introduction
Dans ce chapitre on a vu comme faire du Mapping Objet Relationnel (ORM), en utilisant l'API JPA et le module SpringData.
#### L’architecture du projet :
![1](https://user-images.githubusercontent.com/84138772/159227909-bf306716-9d11-4e66-95bb-47dd1217483e.png)

#### application.properties File
![2](https://user-images.githubusercontent.com/84138772/159228013-62e07d03-160f-4109-a4ad-cfc2d29ba77c.png)
#### L'interface Web H2
![3](https://user-images.githubusercontent.com/84138772/159228086-f63d6de4-eb3b-478e-a033-030e03270285.png)
#### L’exécution :
![5](https://user-images.githubusercontent.com/84138772/159228234-d64b75aa-7e3d-47da-8624-02580f8b839a.png)
##### La base de donnée sous H2:
![4](https://user-images.githubusercontent.com/84138772/159228394-d1cb2759-e142-47fa-bf28-0ba23583e9c7.png)
##### Récupération des données :
###### Methode SpringData

![5-5](https://user-images.githubusercontent.com/84138772/159228638-92c6f376-7a5d-403d-826a-25715d3f47e2.png)

###### La récupération des données grace à HQL(Hibernate Query Language) :

![6](https://user-images.githubusercontent.com/84138772/159228645-7451f1b5-faaa-4b1d-a30a-04228bff9cfc.png)
###### Résultat
![7](https://user-images.githubusercontent.com/84138772/159228663-aed070b8-96b5-491a-99ac-794ffb81f03f.png)

## Activité pratique N°4
### (Associations et Héritage)
#### Introduction
Dans ce chapitre on a vu le  Mapping Objet Relationnel (ORM) et la gestion des assotioations entre les tables d'une base de donnée.
#### L’architecture du projet :
![1](https://user-images.githubusercontent.com/84138772/159235189-cd38127f-6c87-4fdd-a674-2ce44c303e06.png)
#### Les entités JPA :
##### Entité Consultation:
![2](https://user-images.githubusercontent.com/84138772/159235298-6cef7b18-122b-4c15-a870-16220785d3b5.png)
##### Entité Medecin :
![3](https://user-images.githubusercontent.com/84138772/159235440-c0bad36b-3d1e-45ca-a96a-0abb53000ac2.png)
##### Entité Patient :
![4](https://user-images.githubusercontent.com/84138772/159235520-1f4ef692-1c39-4bb9-84e2-2a4f24a4f640.png)
##### Entité Rendez-vous :
![5](https://user-images.githubusercontent.com/84138772/159235604-6314706b-90d4-4091-ac7c-30135fec3707.png)
#### Les interfaces JPA :
##### ConsultationRepository :
![6](https://user-images.githubusercontent.com/84138772/159235799-3cdb4b18-6d9a-4142-9de0-f4a67d97409a.png)
##### MedecinRepository :
![7](https://user-images.githubusercontent.com/84138772/159235852-eb51f41d-39a8-4dea-ab62-0fd42821dd82.png)
##### PatientRepository :
![8](https://user-images.githubusercontent.com/84138772/159235906-cdff993c-0a30-4334-9ae1-41c8616c6f75.png)
##### RendezVousRepository :
![9](https://user-images.githubusercontent.com/84138772/159235979-7f9c3710-dffa-4f62-b305-51c180af8664.png)
#### Base de donnée : 
![10](https://user-images.githubusercontent.com/84138772/159241447-879ca14e-ab68-4010-b854-06ab1fe249f4.png)
#### Route :
![11](https://user-images.githubusercontent.com/84138772/159241505-50971fe0-a61f-4a99-93ec-004b4c381be9.png)
#### Resultat :
![12](https://user-images.githubusercontent.com/84138772/159241553-a6ca5ffa-371e-4c8c-917b-fde365de25a3.png)
## Activité pratique N°5
### (Associations et Héritage)
#### Introduction
Dans ce chapitre on a vu le  Mapping Objet Relationnel (ORM) et la gestion des assotioations entre les tables d'une base de donnée.
#### L’architecture du projet :
![1](https://user-images.githubusercontent.com/84138772/159246425-1de572f8-e73c-4e5f-bd1f-a52eba642668.png)
#### Les entités JPA :
##### Entité User :
![3](https://user-images.githubusercontent.com/84138772/159246528-59a1160a-d1aa-4c94-a4cd-dc7bb9fe1bde.png)
##### Entité Role :
![2](https://user-images.githubusercontent.com/84138772/159246572-06b3e856-2e27-4c9d-bd6e-c22f95dfb128.png)
#### Les interfaces JPA :
##### UserRepository :
![5](https://user-images.githubusercontent.com/84138772/159246691-e24137b8-c3b8-4cbe-afde-4384045fc86a.png)
##### RoleRepository :
![4](https://user-images.githubusercontent.com/84138772/159246749-79966ecc-b949-4b64-bd0d-1e473181d545.png)
#### Couche Metier :
##### UserService :
![6](https://user-images.githubusercontent.com/84138772/159246890-edaa7a6d-6f62-4531-819d-ca6b29fd7476.png)
##### UserService Implementation :
![7 1](https://user-images.githubusercontent.com/84138772/159246942-d664befb-2ac8-487b-9110-20374e71060d.png)
![7 2](https://user-images.githubusercontent.com/84138772/159246957-766c837c-532c-432d-89dc-dcc68ea56f08.png)
#### Couche Presentation :
![8](https://user-images.githubusercontent.com/84138772/159247029-6dbb1889-1e53-437e-b5fa-a737ac3862b5.png)
#### Resultat :
![9](https://user-images.githubusercontent.com/84138772/159247161-c3dd45de-90a2-4b5b-9894-0f256a86f2c3.png)




