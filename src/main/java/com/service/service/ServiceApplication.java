package com.service.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		String activeProfile = dotenv.get("SPRING_PROFILES_ACTIVE", "dev");
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, activeProfile);

		// Sélectionnez l'URI MongoDB selon le profil actif
		String mongoUri;
		if ("dev".equals(activeProfile)) {
			logger.info("URI MongoDB pour le profil {} chargé ", activeProfile);
			mongoUri = dotenv.get("SPRING_DATA_MONGODB_URI");
		} else {
			mongoUri = dotenv.get("SPRING_DATA_MONGODB_URI");
		}

		if (mongoUri != null && !mongoUri.isEmpty()) {
			System.setProperty("spring.data.mongodb.uri", mongoUri);
			logger.info("URI MongoDB pour le profil {} chargé : {}", activeProfile, mongoUri);
		} else {
			logger.warn("URI MongoDB non défini dans le fichier .env pour le profil {}", activeProfile);
		}

		SpringApplication.run(ServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner testMongoConnection(MongoTemplate mongoTemplate) {
		return args -> {
			try {
				mongoTemplate.getDb().listCollectionNames();
				logger.info("Connexion à MongoDB réussie.");
			} catch (Exception e) {
				logger.error("Échec de la connexion à MongoDB", e);
			}
		};
	}
}
