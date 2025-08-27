package org.nexus.ap1clinica_dental.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import org.nexus.ap1clinica_dental.entity.Paciente;
import org.nexus.ap1clinica_dental.service.IPacienteService;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;
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

    public void agregarPaciente(){
        this.pacienteSeleccionado = new Paciente();
    }

    public void guardarPaciente(){
        logger.info("Cliente a guardar: " + this.pacienteSeleccionado);
        //Agregar
        if (this.pacienteSeleccionado.getIdPaciente() ==null){
            this.pacienteService.guardarPaciente(this.pacienteSeleccionado);
            this.pacientes.add(this.pacienteSeleccionado);
        }
        //Modificar
        else {
            this.pacienteService.guardarPaciente(this.pacienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paciente actualizado"));
        }
        PrimeFaces.current().executeScript("PF('ventanaModalPaciente').hide");
        PrimeFaces.current().ajax().update("formulario-pacientes:mensaje-emergente","formulario-pacientes:tabla-pacientes");
        this.pacienteSeleccionado = null;
    }

    public void eliminarPaciente(){
        logger.info("Cliente a eliminar: " + this.pacienteSeleccionado);
        this.pacienteService.eliminarPaciente(this.pacienteSeleccionado);
        this.pacientes.remove(this.pacienteSeleccionado);
        this.pacienteSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage("Cliente eliminado"));
        PrimeFaces.current().ajax().update("formulario-pacientes:mensaje-emergente",
                "formulario-pacientes:tabla-pacientes");

    }



}
