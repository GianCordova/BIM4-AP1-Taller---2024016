package org.nexus.ap1clinica_dental.controller;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.nexus.ap1clinica_dental.entity.Paciente;
import org.nexus.ap1clinica_dental.service.IPacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import jakarta.faces.view.ViewScoped;

import java.util.List;

//Componente generico
@Component
//Alcande de tipo VIEW

//Getter y Setter de Lombok
@Data
public class IndexController {

    @Autowired
    IPacienteService pacienteService;
    private List<Paciente> pacientes;
    private Paciente pacienteSeleccionado;
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.pacientes = this.pacienteService.visualizarPacientes();
        this.pacientes.forEach(paciente -> logger.info(paciente.toString()));
    }

}
