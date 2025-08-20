package org.nexus.ap1clinica_dental;

import java.util.List;
import java.util.Scanner;

import org.nexus.ap1clinica_dental.service.PacienteService;
import org.nexus.ap1clinica_dental.service.IPacienteService;
import org.nexus.ap1clinica_dental.entity.Paciente;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ap1clinicaDentalApplication implements CommandLineRunner{
	@Autowired
	private IPacienteService pacienteService;

	private static final Logger logger = LoggerFactory.getLogger(Ap1clinicaDentalApplication.class);

	String saltodelinea = System.lineSeparator();

	public static void main(String[] args) {
		SpringApplication.run(Ap1clinicaDentalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
