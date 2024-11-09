package com.service.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ServiceApplication {

	// Initialisation du logger
	private static final Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

	public static void main(String[] args) {
		// Charger les variables d'environnement depuis le fichier .env
		Dotenv dotenv = Dotenv.load();

		// Récupérer le profil actif de l'environnement
		String activeProfile = dotenv.get("SPRING_PROFILES_ACTIVE", "dev");

		// Définir le profil actif
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, activeProfile);

		// Récupérer l'URI MongoDB à partir du fichier .env
		String mongoUri = dotenv.get("SPRING_DATA_MONGODB_URI");

		// Vérifier et loguer l'URI MongoDB
		if (mongoUri != null && !mongoUri.isEmpty()) {
			logger.info("URI MongoDB chargé depuis .env : {}", mongoUri);
		} else {
			logger.warn("URI MongoDB non défini dans le fichier .env !");
		}

		dotenv.entries().forEach(entry -> {
			logger.info("Variable chargée : {} = {}", entry.getKey(), entry.getValue());
		});


		// Log pour indiquer quel environnement est chargé
		logger.info("Le profil actif est : {}", activeProfile);

		// Lancement de l'application Spring Boot
		SpringApplication.run(ServiceApplication.class, args);
	}
}
