package org.nexus.ap1clinica_dental.service;

import java.util.List;
import org.nexus.ap1clinica_dental.entity.Paciente;
public interface IPacienteService {
    public List<Paciente> visualizarPacientes();
    public Paciente buscarPacienteporId(Integer id);
    public void guardarPaciente(Paciente paciente); //agregar y actualizar
    public void eliminarPaciente(Paciente paciente);
}
