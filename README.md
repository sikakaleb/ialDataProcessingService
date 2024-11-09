
# Projet DataProcessingService

Ce projet est un microservice pour le traitement et le stockage de données biométriques de santé provenant de capteurs, dans le cadre d'un projet e-santé. Le service est construit avec Spring Boot et utilise MongoDB pour le stockage. Il expose une série d’API pour chaque type de données capturées par les capteurs (ECG, EMG, fréquence cardiaque, température, etc.).

## Prérequis

- **Docker et Docker Compose** : pour exécuter le projet avec un environnement conteneurisé.
- **MongoDB** : MongoDB Cloud (préconfiguré) est utilisé pour le stockage de données. Une URI MongoDB de test est fournie, mais vous pouvez utiliser votre propre base de données.

## Lancer le projet

1. **Configurer l'URI MongoDB** : Assurez-vous que l'URI de MongoDB est correctement configuré dans le fichier `.env` ou `application.properties`. Une URI par défaut est incluse pour faciliter la configuration de base.

2. **Exécuter le service** :
   ```bash
   docker-compose up --build
   ```

## Prise en main

Une fois le service lancé, vous pouvez interagir avec les différentes API pour chaque type de capteur via les points d'entrée suivants :

- Base URL : `http://localhost:8080`

### Contrôleurs et Points d’Entrée

| Contrôleur                  | Méthode HTTP | URI                                    | Description                                       |
|-----------------------------|--------------|----------------------------------------|---------------------------------------------------|
| **Temperature Controller**  | `POST`       | `/api/temperature/data`                | Enregistre les données de température             |
|                             | `GET`        | `/api/temperature/{patientId}`         | Récupère les données de température d'un patient  |
|                             | `GET`        | `/api/temperature/data/{patientId}`    | Récupère toutes les données de température d'un patient |
| **SpO2 Controller**         | `POST`       | `/api/spo2/data`                       | Enregistre les données de saturation en oxygène   |
|                             | `GET`        | `/api/spo2/{patientId}`                | Récupère les données de SpO2 d'un patient         |
|                             | `GET`        | `/api/spo2/data/{patientId}`           | Récupère toutes les données de SpO2 d'un patient  |
| **Respiratory Rate Controller** | `POST`  | `/api/respiratory-rate/data`           | Enregistre les données de fréquence respiratoire  |
|                             | `GET`        | `/api/respiratory-rate/{patientId}`    | Récupère les données de fréquence respiratoire d'un patient |
| **Movement Controller**     | `POST`       | `/api/movement/data`                   | Enregistre les données de mouvement               |
|                             | `GET`        | `/api/movement/{patientId}`            | Récupère les données de mouvement d'un patient    |
| **Heart Rate Controller**   | `POST`       | `/api/heart-rate/data`                 | Enregistre les données de fréquence cardiaque     |
|                             | `GET`        | `/api/heart-rate/{patientId}`          | Récupère les données de fréquence cardiaque d'un patient |
| **EMG Controller**          | `POST`       | `/api/emg/data`                        | Enregistre les données d'EMG                      |
|                             | `GET`        | `/api/emg/{patientId}`                 | Récupère les données d'EMG d'un patient           |
| **EDA Controller**          | `POST`       | `/api/eda/data`                        | Enregistre les données de conductance électrodermale |
|                             | `GET`        | `/api/eda/{patientId}`                 | Récupère les données d'EDA d'un patient           |
| **ECG Controller**          | `POST`       | `/api/ecg/data`                        | Enregistre les données d'ECG                      |
|                             | `GET`        | `/api/ecg/{patientId}`                 | Récupère les données d'ECG d'un patient           |
| **Blood Pressure Controller** | `POST`     | `/api/blood-pressure/data`             | Enregistre les données de pression artérielle     |
|                             | `GET`        | `/api/blood-pressure/{patientId}`      | Récupère les données de pression artérielle d'un patient |
| **Hello World Controller**  | `GET`        | `/hello`                               | Test de disponibilité du service                  |
|                             | `GET`        | `/`                                    | Test de base                                      |

## Structure des Données et Hypothèses

Chaque type de donnée possède un DTO (Data Transfer Object) spécifique pour gérer les transferts de données. Voici un aperçu des structures des DTOs utilisés :

- **TemperatureDataDTO** : Données de température.
- **SpO2DataDTO** : Données de saturation en oxygène.
- **RespiratoryRateDataDTO** : Données de fréquence respiratoire.
- **MovementDataDTO** : Données de mouvement.
- **HeartRateDataDTO** : Données de fréquence cardiaque.
- **EMGDataDTO** : Données d'EMG.
- **EDADataDTO** : Données de conductance électrodermale.
- **ECGDataDTO** : Données d'ECG.
- **BloodPressureDataDTO** : Données de pression artérielle.

### Hypothèses d'Architecture

- **Flux de Données** :
    - Les capteurs transmettent les données au Raspberry Pi pour un traitement préliminaire avant l'envoi au backend via un broker EMQX.
    - Chaque type de données est envoyé sur une queue distincte afin de diriger automatiquement les données vers le contrôleur approprié.

- **Gestion des Données** :
    - Les données sont transmises sous forme JSON, incluant des informations comme l'ID du patient, le type de capteur, l'horodatage et les valeurs mesurées. Cela facilite la gestion des données pour les différents capteurs.

- **Traitement** : Le traitement des alertes et le filtrage sont gérés par un autre microservice dédié, permettant à `DataProcessingService` de se concentrer sur l'ingestion et le stockage des données.

## Modifier la Base de Données

Pour utiliser une autre base de données, modifiez l'URI MongoDB dans le fichier `.env` ou `application.properties`. Assurez-vous que les noms de collections sont identiques pour conserver la compatibilité avec les DTOs et les contrôleurs existants.

Voici une section que vous pouvez ajouter dans votre fichier README pour guider les utilisateurs dans l’utilisation des données de test sur Swagger :

---

### Données de Test pour Swagger

Pour faciliter les tests de vos endpoints via Swagger, voici des exemples de données JSON que vous pouvez utiliser pour chaque modèle de données. Ces données couvrent différents capteurs et types de données biométriques, permettant de simuler l'ingestion et la visualisation des informations.

#### Exemple de Données

1. **BloodPressureDataDTO** :
   ```json
   {
     "patientId": "12345",
     "deviceId": "BPDevice01",
     "systolic": 120,
     "diastolic": 80,
     "unit": "mmHg",
     "recordedAt": 1672444800000
   }
   ```

2. **EcgDataDTO** :
   ```json
   {
     "patientId": "12345",
     "deviceId": "ECGDevice01",
     "timestampedValues": [
       { "timestamp": 0.0, "amplitude": 1.2 },
       { "timestamp": 1.0, "amplitude": 1.3 }
     ]
   }
   ```

3. **EdaDataDTO** :
   ```json
   {
     "patientId": "12345",
     "deviceId": "EDADevice01",
     "timestampedValues": [
       { "timestamp": 0.0, "conductance": 0.5 },
       { "timestamp": 1.0, "conductance": 0.6 }
     ]
   }
   ```

4. **EmgDataDTO** :
   ```json
   {
     "patientId": "12345",
     "deviceId": "EMGDevice01",
     "timestampedValues": [
       { "timestamp": 0.0, "amplitude": 0.9 },
       { "timestamp": 1.0, "amplitude": 1.1 }
     ]
   }
   ```

5. **HeartRateDataDTO** :
   ```json
   {
     "patientId": "12345",
     "deviceId": "HRDevice01",
     "heartRate": 75,
     "unit": "bpm",
     "recordedAt": 1672444800000
   }
   ```

6. **MovementDataDTO** :
   ```json
   {
     "patientId": "12345",
     "deviceId": "MovementDevice01",
     "accelerationValues": [
       { "timestamp": 0.0, "x": 0.1, "y": 0.0, "z": -9.8 },
       { "timestamp": 1.0, "x": 0.2, "y": 0.1, "z": -9.7 }
     ]
   }
   ```

7. **RespiratoryRateDataDTO** :
   ```json
   {
     "patientId": "12345",
     "deviceId": "RespDevice01",
     "respiratoryRate": 16,
     "unit": "rpm",
     "recordedAt": 1672444800000
   }
   ```

8. **SpO2DataDTO** :
   ```json
   {
     "patientId": "12345",
     "deviceId": "SpO2Device01",
     "oxygenSaturation": 98,
     "unit": "%",
     "recordedAt": 1672444800000
   }
   ```

9. **TemperatureDataDTO** :
   ```json
   {
     "patientId": "12345",
     "deviceId": "TempDevice01",
     "temperature": 37.0,
     "unit": "°C",
     "recordedAt": 1672444800000
   }
   ```

#### Instructions pour l'utilisation

1. **Accédez** à l'interface Swagger de votre application.
2. **Sélectionnez** l'endpoint correspondant à chaque DTO, comme `/bloodpressure`, `/ecg`, etc.
3. **Copiez** l'un des exemples ci-dessus dans le champ de demande JSON pour chaque type de données.
4. **Cliquez sur "Exécuter"** pour envoyer la demande et vérifier la réponse.

Ces exemples vous permettront de vérifier rapidement le bon fonctionnement des contrôleurs et des endpoints API.