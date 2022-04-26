package com.olympus.parthenon;

import com.olympus.parthenon.artemis.repository.EditionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParthenonApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParthenonApplication.class, args);
	}
}
