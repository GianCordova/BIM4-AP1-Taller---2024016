package org.nexus.ap1clinica_dental.service;

import org.nexus.ap1clinica_dental.entity.Paciente;
import org.nexus.ap1clinica_dental.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> visualizarPacientes() {
        List<Paciente> paciente = pacienteRepository.findAll();
        return paciente;
    }

    public Paciente buscarPacienteporId(Integer id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        return paciente;
    }

    public void guardarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }
}
