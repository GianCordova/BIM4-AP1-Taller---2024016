package org.nexus.ap1clinica_dental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.nexus.ap1clinica_dental.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
}
