package org.nexus.ap1clinica_dental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import javax.annotation.processing.Generated;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Entity(name = "Pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString@EqualsAndHashCode
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;
    private String nombre;
    private String apellido;
    private String fechadeNacimiento;
    private String telefono;

    public Paciente(Integer idPaciente) {
    }

    public Paciente(Integer idPaciente, String nombre, String apellido, String fechadeNacimiento, String telefono) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechadeNacimiento = fechadeNacimiento;
        this.telefono = telefono;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechadeNacimiento() {
        return fechadeNacimiento;
    }

    public void setFechadeNacimiento(String fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechadeNacimiento=" + fechadeNacimiento +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
