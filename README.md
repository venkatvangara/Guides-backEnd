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


