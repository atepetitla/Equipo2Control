/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Service
public class AlumnoService {

    private AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> obtenerAlumnoPorId(int id) {
        return alumnoRepository.findById(id);
    }

    @Transactional
    public void guardarAlumno(Alumno alumno) {
        try {
            alumnoRepository.save(alumno);
        } catch (Exception e) {

        }

    }

    @Transactional
    public void eliminarAlumno(int id) {
        alumnoRepository.deleteById(id);
    }

    public Optional<Alumno> getbynombre(String Nombre) {
        return alumnoRepository.findByNombre(Nombre);
    }
    public void agregarAlumnoStored(String nombre,String apellidoPaterno,String ApellidoMaterno){
        alumnoRepository.InsertarAlumno(nombre, apellidoPaterno, ApellidoMaterno);
    }
    @Transactional
    public void actualizarAlumnoStored(int idAlumno, String nuevoNombre, String nuevoApellidoPaterno, String nuevoApellidoMaterno) {
        alumnoRepository.actualizarAlumno(idAlumno, nuevoNombre, nuevoApellidoPaterno, nuevoApellidoMaterno);
    }
    
    @Transactional
    public void eliminarAlumnoStored(int idAlumno) {
        alumnoRepository.eliminarAlumno(idAlumno);
    }
    
    
}
