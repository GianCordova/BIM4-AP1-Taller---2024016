package org.nexus.ap1clinica_dental;

import java.util.List;
import java.util.Scanner;

import org.nexus.ap1clinica_dental.service.IPacienteService;
import org.nexus.ap1clinica_dental.entity.Paciente;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Ap1clinicaDentalApplication implements CommandLineRunner{
	@Autowired
	private IPacienteService pacienteService;

	private static final Logger logger = LoggerFactory.getLogger(Ap1clinicaDentalApplication.class);

	String saltodelinea = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion de la clinica dental");
		SpringApplication.run(Ap1clinicaDentalApplication.class, args);
		logger.info("Aplicacion finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		clinicaDentalApp();
	}

	private void clinicaDentalApp(){
		logger.info("***Bienvenido a la aplicacion de la Clinica Dental***");
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola,opcion);
			logger.info(saltodelinea);
		}
	}

	private int mostrarMenu(Scanner scanner){
		logger.info("""
				***Aplicacion***
				1. Listar Pacientes
				2. Buscar Paciente
				3. Agregar Paciente
				4. Modificar Paciente
				5. Eliminar Paciente
				6. Salir
				""");
		var opcion = Integer.parseInt(scanner.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones (Scanner scanner, int opcion){
		var salir = false;
		switch (opcion){
			case 1 -> {
				logger.info(saltodelinea+"***Lista de Pacientes***"+saltodelinea);
				List<Paciente> pacientes = pacienteService.visualizarPacientes();
				pacientes.forEach(paciente -> logger.info(paciente.toString()+saltodelinea));
			}

			case 2 -> {
				logger.info(saltodelinea+"***Buscar Paciente por su ID***"+saltodelinea);
				var codigo = Integer.parseInt(scanner.nextLine());
				Paciente cliente = pacienteService.buscarPacienteporId(codigo);
				if (cliente != null){
					logger.info("Paciente encontrado: " + cliente + saltodelinea);
				} else {
					logger.info("Paciente no encontrado" + cliente + saltodelinea);
				}
			}

			case 3 -> {
				logger.info(saltodelinea+"***Agregar un Cliente"+saltodelinea);
				logger.info("Ingrese el nombre del paciente a agregar: ");
				var nombre = scanner.nextLine();
				logger.info("Ingrese el apellido del paciente a agregar: ");
				var apellido = scanner.nextLine();
				logger.info("Ingrese la fecha de nacimiento del paciente a agregar: ");
				var fechadeNacimiento = scanner.nextLine();
				logger.info("Ingrese el telefono del paciente a agregar: ");
				var telefono = scanner.nextLine();
                var paciente = new Paciente();
                paciente.setNombre(nombre);
				paciente.setApellido(apellido);
				paciente.setTelefono(telefono);
				paciente.setFechadeNacimiento(fechadeNacimiento);
				pacienteService.guardarPaciente(paciente);
				logger.info("Paciente guardado con exito: " + paciente+saltodelinea);
			}

			case 4 -> {
				//Buscar por codigo
				logger.info("Agregue el codigo del paciente a modificar");
				var id = Integer.parseInt(scanner.nextLine());
				Paciente paciente = pacienteService.buscarPacienteporId(id);
				//Guardar si no es null
				if (paciente != null){
					logger.info("Ingrese el nombre del paciente a agregar: ");
					var nombre = scanner.nextLine();
					logger.info("Ingrese el apellido del paciente a agregar: ");
					var apellido = scanner.nextLine();
					logger.info("Ingrese la fecha de nacimiento del paciente a agregar: ");
					var fechadeNacimiento = scanner.nextLine();
					logger.info("Ingrese el telefono del paciente a agregar: ");
					var telefono = scanner.nextLine();
					paciente.setNombre(nombre);
					paciente.setApellido(apellido);
					paciente.setApellido(fechadeNacimiento);
					paciente.setTelefono(telefono);
					pacienteService.guardarPaciente(paciente);
					logger.info("Paciente modificado con exito: " + paciente+saltodelinea);
				} else {
					logger.info("Paciente no encontrado");
				}
			}

			case 5 -> {
				logger.info(saltodelinea + "***Eliminar Paciente***"+saltodelinea);
				logger.info("Ingrese el codigo del paciente a eliminar");
				var id = Integer.parseInt(scanner.nextLine());
				var paciente = pacienteService.buscarPacienteporId(id);
				if (paciente !=null){
					pacienteService.eliminarPaciente(paciente);
					logger.info("Cliente eliminado, adiosito");
				} else {
					logger.info("Cliente no encontrado " +paciente+saltodelinea);
				}
			}

			case 6 -> {
				logger.info("Hasta la vista, Beibi" + saltodelinea + saltodelinea);
				salir = true;
			}
				default -> logger.info("Opcion invalida");
		}
		return false;
	}
}
