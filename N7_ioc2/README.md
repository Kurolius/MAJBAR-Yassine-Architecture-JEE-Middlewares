# Activité pratique N°1
## (Inversion de contrôle et Injection des dépendances)
### Introduction :
Dans ce premier chapitre on a pu étudier les différents types de couplage (couplage fort / couplage faible) et les différentes manières d’injection de contrôle et injection de dépendances.
c’est ce qu’on va essayer de mettre en pratique dans cette activité.

### Packages :
![image10](https://user-images.githubusercontent.com/84138772/156883912-79e5f5b7-f965-40f6-8fd8-5828fbca82b2.png)

### Code :
#### Interface DAO :
![image2](https://user-images.githubusercontent.com/84138772/156883943-e3cb503c-7d29-4665-ae77-95602b256c58.png)
#### Implémentation de l’interface DAO :
![image4](https://user-images.githubusercontent.com/84138772/156883963-d480e2c7-ccaa-4ad0-a501-b075d2c85c44.png)
#### Interface métier :
![image6](https://user-images.githubusercontent.com/84138772/156883983-845f3401-0323-4920-8b49-717b983b0842.png)
#### Implémentation de l’interface métier :
![image9](https://user-images.githubusercontent.com/84138772/156883999-054e3c6c-25ee-4817-87a6-79d616a8dfa8.png)


##### Injection de l’interface IDao
![image1](https://user-images.githubusercontent.com/84138772/156884004-4fa5e5b2-74d7-44e2-9b2a-6bb6bfdfe5ab.png)

#### instanciation statique :
![image5](https://user-images.githubusercontent.com/84138772/156884132-bcbb5f51-1589-40dc-b85d-e12739a89099.png)
#### instanciation dynamique :
![image7](https://user-images.githubusercontent.com/84138772/156884153-368bfb44-5fb3-4fab-9269-0e38117cc519.png)
#### En utilisant le Framework Spring (Version XML) : 
![image3](https://user-images.githubusercontent.com/84138772/156884172-0bd09d00-aea4-4d47-9dcd-c47b1de87832.png)
#### En utilisant le Framework Spring (Version annotations) :
![image8](https://user-images.githubusercontent.com/84138772/156884185-c4f3ae9b-dd51-4ca4-be57-91adbc8cba01.png)


**Note :** notez bien que dans la version annotation il est obligatoire d’utiliser les annotations @Component et @Autowired  dans les implémentations des interfaces DAO et Metier .