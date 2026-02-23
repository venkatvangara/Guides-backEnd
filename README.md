# Travel Guide App — Backend (Spring Boot)

 Installation & Lancement

1. Cloner le dépôt :
   git clone https://github.com/venkatvangara/Guides-backEnd

2. Configurer MySQL dans `application.properties`

3. Lancer l'application :
   mvn spring-boot:run

4. API disponible sur :
   http://localhost:8085

---

Endpoints Principaux

### Guides
- GET /guides?userId=1
- GET /guides/{id}?userId=1
- POST /guides?userId=1
- PUT /guides/{id}?userId=1
- DELETE /guides/{id}?userId=1

 Activities
- POST /activities/create/{guideId}?userId=1
- PUT /activities/{id}?userId=1
- DELETE /activities/{id}?userId=1
- GET /activities/{id}?userId=1

---

## 🗂 Base de Données

Tables :
- guide  
- activity  
- guide_invited_users
- guide_activities

---




Pour réaliser ce projet, j’ai suivi une approche simple et structurée :

1. Analyse du besoin
Afficher une liste de guides

Afficher les détails d’un guide

Gérer des activités (CRUD)

Assurer la communication entre Angular et Spring Boot

Utiliser une base MySQL pour stocker les données

2. Architecture
J’ai séparé le projet en deux parties pour plus de clarté :

Frontend Angular : interface utilisateur, navigation, formulaires

Backend Spring Boot : API REST, logique métier, accès à la base de données

3. Choix techniques
Angular pour une interface moderne et réactive

Spring Boot pour une API REST simple et rapide à mettre en place

MySQL pour une base relationnelle stable

Routing basé sur l’ID pour garantir la stabilité et la simplicité

Services Angular pour centraliser les appels API

Modèles TypeScript pour structurer les données

4. Déroulement du travail
Mise en place du backend (entités, contrôleurs, services)

Création des endpoints REST

Création du frontend (composants, routes, services)

Intégration backend ↔ frontend

Tests manuels (ajout, édition, suppression d’activités)

Nettoyage du code et préparation du rendu

Ajout d’une vidéo de démonstration

5. Difficultés rencontrées
Gestion du routing dynamique

Synchronisation entre les IDs du guide et les activités

Nettoyage du code pour la livraison finale

6. Résultat
Le projet est fonctionnel :

Liste des guides

Détails d’un guide

CRUD des activités

Navigation fluide

Backend et frontend connectés

Une vidéo de démonstration est fournie pour visualiser le fonctionnement.
